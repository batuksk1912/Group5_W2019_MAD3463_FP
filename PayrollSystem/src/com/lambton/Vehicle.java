package com.lambton;

public abstract class Vehicle implements IPrintable {

    private String make;
    private String plate;
    private Integer year;
    private Color color;

    public enum Color {
        Default, BLACK, WHITE, BLUE, RED, GREEN, GRAY;
    }

    public Vehicle() {
        this.make = null;
        this.plate = null;
        this.year = 0;
        this.color = Color.Default;
    }

    public Vehicle(String make, String plate, Integer year, Color color) {
        this.make = make;
        this.plate = plate;
        this.year = year;
        this.color = color;
    }

    public Vehicle(Vehicle vehicle) {
        this.make = vehicle.make;
        this.plate = vehicle.plate;
        this.year = vehicle.year;
        this.color = vehicle.color;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String printMyData() {
        return "Vehicle Information" +
                "\nMake : " + make +
                "\nPlate : " + plate +
                "\nYear : " + year +
                "\nColor : " + color;
    }
}
