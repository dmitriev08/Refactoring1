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
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();

            switch (each.getCar().getPriceCode()) {
                case Car.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2)
                        thisAmount += (each.getDaysRented() - 2) * 1500;
                    break;
                case Car.MINI_VAN:
                    thisAmount += each.getDaysRented() * 2500;
                    break;
                case Car.SPORT:
                    thisAmount += 4000;
                    if (each.getDaysRented() > 3)
                        thisAmount += (each.getDaysRented() - 3) * 3500;
                    break;
            }
            frequentRenterPoints++;
            if ((each.getCar().getPriceCode() ==
                    Car.MINI_VAN) && each.getDaysRented() > 1)
                frequentRenterPoints++;
            result += "\t" + each.getCar().getTitle() + "\t" +
                    String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        } //while loop
        result += "К оплате " + String.valueOf(totalAmount) + " руб\n";
        result += "Вы заработали  " +
                String.valueOf(frequentRenterPoints) + " бонусных баллов.";
        return result;
    }
}



