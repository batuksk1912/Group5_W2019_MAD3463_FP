package com.lambton;

public abstract class PartTime extends Employee {

    private Float rate;
    private Float hoursWorked;

    public PartTime() {
        super();
        this.rate = 0.0f;
        this.hoursWorked = 0.0f;
    }

    public PartTime(Integer id, String name, Integer age, Vehicle vehicle, Float rate, Float hoursWorked) {
        super(id, name, age, vehicle);
        this.rate = rate;
        this.hoursWorked = hoursWorked;
    }

    public PartTime(PartTime partTime) {
        this.rate = partTime.rate;
        this.hoursWorked = partTime.hoursWorked;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Float getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(Float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String printMyData() {
        return super.printMyData() + "\nEmployee Type : Part Time" +
                "\nRate : " + rate +
                "\nHours Worked : " + hoursWorked;
    }
}
