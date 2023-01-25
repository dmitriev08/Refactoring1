import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Выписка для " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            double thisAmount = forAmount(each);

            frequentRenterPoints += getFrequentPoints(each);
            result += "\t" + each.getCar().getTitle() + "\t" +
                    String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        } //while loop
        result += "К оплате " + String.valueOf(totalAmount) + " руб\n";
        result += "Вы заработали  " +
                String.valueOf(frequentRenterPoints) + " бонусных баллов.";
        return result;
    }

    private int getFrequentPoints(Rental each) {
        int localPoints = 1;
        if ((each.getCar().getPriceCode() ==
                Car.MINI_VAN) && each.getDaysRented() > 1)
            localPoints++;
        return localPoints;
    }

    private double forAmount(Rental each) {
        double localAmount = 0;
        switch (each.getCar().getPriceCode()) {
            case Car.REGULAR:
                localAmount += 2;
                if (each.getDaysRented() > 2)
                    localAmount += (each.getDaysRented() - 2) * 1500;
                break;
            case Car.MINI_VAN:
                localAmount += each.getDaysRented() * 2500;
                break;
            case Car.SPORT:
                localAmount += 4000;
                if (each.getDaysRented() > 3)
                    localAmount += (each.getDaysRented() - 3) * 3500;
                break;
        }
        return localAmount;
    }
}



