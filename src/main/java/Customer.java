import java.util.ArrayList;

public class Customer {
    final private String name;
    final private ArrayList <Rental> rentals = new ArrayList();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
//        Enumeration rentals = this.rentals();
        String result = "Выписка для " + getName() + "\n";
        for (Rental each: rentals) {
            double thisAmount = forAmount(each);

            frequentRenterPoints += getFrequentPoints(each);
            result += "\t" + each.getCar().getTitle() + "\t" +
                    thisAmount + "\n";
            totalAmount += thisAmount;
        } //while loop
        result += "К оплате " + totalAmount + " руб\n";
        result += "Вы заработали  " +
                frequentRenterPoints + " бонусных баллов.";
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
            case Car.REGULAR -> {
                localAmount += 2;
                if (each.getDaysRented() > 2)
                    localAmount += (each.getDaysRented() - 2) * 1500;
            }
            case Car.MINI_VAN -> localAmount += each.getDaysRented() * 2500;
            case Car.SPORT -> {
                localAmount += 4000;
                if (each.getDaysRented() > 3)
                    localAmount += (each.getDaysRented() - 3) * 3500;
            }
        }
        return localAmount;
    }
}



