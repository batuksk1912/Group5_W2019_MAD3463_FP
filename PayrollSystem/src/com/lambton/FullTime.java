package com.lambton;

public class FullTime extends Employee {

    private Float salary;
    private Float bonus;

    public FullTime() {
        super();
        this.salary = 0.0f;
        this.bonus = 0.0f;
    }

    public FullTime(Integer id, String name, Integer age, Vehicle vehicle, Float salary, Float bonus) {
        super(id, name, age, vehicle);
        this.salary = salary;
        this.bonus = bonus;
    }

    public FullTime(FullTime fullTime) {
        this.salary = fullTime.salary;
        this.bonus = fullTime.bonus;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Float getBonus() {
        return bonus;
    }

    public void setBonus(Float bonus) {
        this.bonus = bonus;
    }

    @Override
    public Float calcEarnings() {
        return salary + bonus;
    }

    @Override
    public String printMyData() {
        return super.printMyData() + "\nEmployee Type : Full Time" +
                "Salary : " + salary +
                "Bonus : " + bonus +
                '}';
    }
}
