public class Main {
    public static void main(String[] args) {
        Car c1 = new Car();
        Motorcycle mc1 = new Motorcycle();
        Vehicle[] arr = {c1, mc1};

       
        for (Vehicle v : arr) {
            v.startEngine();
            v.refuel();
            v.stopEngine();
            System.out.println(); 
        }
    }
}