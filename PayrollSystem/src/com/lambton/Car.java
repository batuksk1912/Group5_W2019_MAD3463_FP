package com.lambton;

public class Car extends Vehicle {

    private Integer seats;
    private Integer doorNumber;

    public Car() {
        super();
        this.seats = 0;
        this.doorNumber = 0;
    }

    public Car(String make, String plate, Integer year, Color color, Integer seats, Integer doorNumber) {
        super(make, plate, year, color);
        this.seats = seats;
        this.doorNumber = doorNumber;
    }

    public Car(Car car) {
        this.seats = car.seats;
        this.doorNumber = car.doorNumber;
    }

    @Override
    public String printMyData() {
        return super.printMyData() +
                "\nSeats : " + seats +
                "\nDoor Number : " + doorNumber;
    }
}
