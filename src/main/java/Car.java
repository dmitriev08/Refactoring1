public class Car {
    public static final int SPORT = 2;
    public static final int REGULAR = 0;
    public static final int MINI_VAN = 1;
    private String _title;
    private int _priceCode;

    public Car(String title, int priceCode) {
        _title = title;
        _priceCode = priceCode;
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int arg) {
        _priceCode = arg;
    }

    public String getTitle() {
        return _title;
    }
}
