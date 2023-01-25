public class Car {
    public static final int SPORT = 2;
    public static final int REGULAR = 0;
    public static final int MINI_VAN = 1;
    private String title;
    private int priceCode;

    public Car(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int arg) {
        priceCode = arg;
    }

    public String getTitle() {
        return title;
    }
}
