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
        String result = "Выписка для " + getName() + "\n";
        for (Rental each: rentals) {
            double thisAmount = each.forAmount();
            result += "\t" + each.getCar().getTitle() + "\t" +
                    thisAmount + "\n";
        } //while loop
        result += "К оплате " + getTotalAmount() + " руб\n";
        result += "Вы заработали  " +
                getTotalFrequentPoints() + " бонусных баллов.";
        return result;
    }

    private int getTotalFrequentPoints() {
        int ret = 0;
        for (Rental each : rentals) {
            ret += each.getFrequentPoints();
        }
        return ret;
    }

    private double getTotalAmount() {
        double ret = 0;
        for (Rental each : rentals) {
            ret += each.forAmount();
        }
        return ret;
    }

}



