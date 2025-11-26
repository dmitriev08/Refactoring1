public class AvisRentals {
    public static void main(String[] args) {
        Customer andrey = new Customer("Andrey Dmitriev");
        Car renoDuster = new Car("Renault Duster", Car.MINI_VAN);
        Car ladaGranta = new Car("Pegot", Car.REGULAR);
        Car ferrari = new Car("Ferrari Car", Car.SPORT);
        Rental rent = new Rental(renoDuster, 5);
        Rental rent2 = new Rental(ladaGranta, 1);
        Rental rent3 = new Rental(ferrari, 2);
        Rental rent4 = new Rental(ferrari, 8);
        andrey.addRental(rent);
        andrey.addRental(rent2);
        andrey.addRental(rent3);
        andrey.addRental(rent4);
        System.out.println(andrey.statement());
    }
}
