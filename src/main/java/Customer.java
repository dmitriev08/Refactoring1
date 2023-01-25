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
        String result = "Выписка для " + getName() + "\n";
        for (Rental each: rentals) {
            double thisAmount = each.forAmount();

            frequentRenterPoints += each.getFrequentPoints();
            result += "\t" + each.getCar().getTitle() + "\t" +
                    thisAmount + "\n";
            totalAmount += thisAmount;
        } //while loop
        result += "К оплате " + totalAmount + " руб\n";
        result += "Вы заработали  " +
                frequentRenterPoints + " бонусных баллов.";
        return result;
    }

}



