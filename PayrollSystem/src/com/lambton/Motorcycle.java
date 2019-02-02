package com.lambton;

public class Motorcycle extends Vehicle {

    public Motorcycle() {
        super();
    }

    public Motorcycle(String make, String plate, Integer year, Color color) {
        super(make, plate, year, color);
    }

    public Motorcycle(Vehicle vehicle) {
        super(vehicle);
    }

    @Override
    public String printMyData() {
        return super.printMyData();
    }
}
