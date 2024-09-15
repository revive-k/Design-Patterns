import java.util.HashMap;
import java.util.Map;

public class FactoryPattern {
    public static void main(String[] args) {
        Vehicle car = Factory.getVehicle(VehicleType.CAR);
        Vehicle bike = Factory.getVehicle(VehicleType.BIKE);
        System.out.println(car.numberOfWheels());
        System.out.println(bike.numberOfWheels());
    }
}

class Factory {
    private static Map<VehicleType, Vehicle> map = new HashMap<>();

    static {
        map.put(VehicleType.CAR, new Car());
        map.put(VehicleType.BIKE, new Bike());
    }

    public static Vehicle getVehicle(VehicleType type) {
        return map.get(type);
    }
    public static void registerVehicle(VehicleType vehicleType, Vehicle vehicle) {
        map.put(vehicleType, vehicle);
    }
}

/*
    Either of Factory or SimpleFactory class can be used. 
    Factory is more enhanced over SimpleFactory as it removes if else statement
 */

class SimpleFactory {
    public static Vehicle getVehicle(VehicleType type) {
        if(VehicleType.CAR.equals(type)) return new Car();
        if(VehicleType.BIKE.equals(type)) return new Bike();
        return null;
    }
}

enum VehicleType {
    CAR, BIKE, TRUCK;
}

interface Vehicle {
    void drive();
    int numberOfWheels();

}

class Car implements Vehicle {

    @Override
    public void drive() {
        System.out.println("Driving car");
    }

    @Override
    public int numberOfWheels() {
        return 4;
    }
}

class Bike implements Vehicle {

    @Override
    public void drive() {
        System.out.println("Driving bike");
    }

    @Override
    public int numberOfWheels() {
        return 2;
    }
}
