class Rental {
    private Car _car;
    private int _daysRented;

    public Rental(Car movie, int daysRented) {
        _car = movie;
        _daysRented = daysRented;
    }
    public int getDaysRented() {
        return _daysRented;
    }
    public Car getCar() {
        return _car;
    }
}
