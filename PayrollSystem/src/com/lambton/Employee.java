package com.lambton;

public abstract class Employee implements IPrintable {

    private Integer id;
    private String name;
    private Integer age;
    private Vehicle vehicle;

    public Employee() {
        this.id = 0;
        this.name = null;
        this.age = 0;
        this.vehicle = null;
    }

    public Employee(Integer id, String name, Integer age, Vehicle vehicle) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.vehicle = vehicle;
    }

    public Employee(Employee employee) {
        this.id = employee.id;
        this.name = employee.name;
        this.age = employee.age;
        this.vehicle = employee.vehicle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Integer calcBirthYear(Integer age) {
        return 2019 - age;
    }

    public Float calcEarnings() {
        return 1000.00f;
    }

    public String vehicleChecker() {
        if (vehicle == null) {
            return "No Vehicle";
        } else if (vehicle instanceof Car) {
            return "Car";
        } else {
            return "Motorcycle";
        }
    }

    @Override
    public String printMyData() {
        return "\n---Employee Records---\n\n" +
                "Employer ID : " + id +
                "\nName : " + name + '\n' +
                "Year of Birth : " + age +
                "\nVehicle Status : " + vehicleChecker() + "\n" + (vehicle != null ? vehicle.printMyData() : "No Vehicle Information");
    }
}
