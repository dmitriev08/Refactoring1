public class AvisRentals {
    public static void main(String[] args) {
        Customer andrey = new Customer("Andrey Dmitriev");
        Car renoDuster = new Car("Reno Duster", Car.REGULAR);
        Car ladaGranta = new Car("Lada Granta", Car.SPORT);
        Rental rent = new Rental(renoDuster, 5);
        Rental rent2 = new Rental(ladaGranta, 1);
        andrey.addRental(rent);
        andrey.addRental(rent2);
        System.out.println(andrey.statement());
    }
}
