class Rental {
    final private Car car;
    final private int daysRented;

    public Rental(Car car, int daysRented) {
        this.car = car;
        this.daysRented = daysRented;
    }
    public int getDaysRented() {
        return daysRented;
    }
    public Car getCar() {
        return car;
    }

    double forAmount() {
        double localAmount = 0;
        switch (getCar().getPriceCode()) {
            case Car.REGULAR -> {
                localAmount += 2;
                if (getDaysRented() > 2)
                    localAmount += (getDaysRented() - 2) * 1500;
            }
            case Car.MINI_VAN -> localAmount += getDaysRented() * 2500;
            case Car.SPORT -> {
                localAmount += 4000;
                if (getDaysRented() > 3)
                    localAmount += (getDaysRented() - 3) * 3500;
            }
        }
        return localAmount;
    }

    int getFrequentPoints() {
        int localPoints = 1;
        if ((getCar().getPriceCode() ==
                Car.MINI_VAN) && getDaysRented() > 1)
            localPoints++;
        return localPoints;
    }
}
