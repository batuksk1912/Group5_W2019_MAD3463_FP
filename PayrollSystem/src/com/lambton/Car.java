package com.lambton;

public class Car extends Vehicle {

    public Car() {
        super();
    }

    public Car(String make, String plate, Integer year, Color color) {
        super(make, plate, year, color);
    }

    public Car(Vehicle vehicle) {
        super(vehicle);
    }

    @Override
    public String printMyData() {
        return super.printMyData();
    }
}
