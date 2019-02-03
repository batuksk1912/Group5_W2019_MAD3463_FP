package com.lambton;

public class Motorcycle extends Vehicle {

    private String sideCar;
    private String brakeType;

    public Motorcycle() {
        super();
        this.sideCar = null;
        this.brakeType = null;
    }

    public Motorcycle(String make, String plate, Integer year, Color color, String sideCar, String brakeType) {
        super(make, plate, year, color);
        this.sideCar = sideCar;
        this.brakeType = brakeType;
    }

    public Motorcycle(Motorcycle motorcycle) {
        this.sideCar = motorcycle.sideCar;
        this.brakeType = motorcycle.brakeType;
    }

    @Override
    public String printMyData() {
        return super.printMyData() +
                "\nSide Car : " + sideCar +
                "\nbrakeType : " + brakeType;
    }
}
