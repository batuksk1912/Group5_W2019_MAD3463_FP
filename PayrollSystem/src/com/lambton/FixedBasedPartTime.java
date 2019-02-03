package com.lambton;

public class FixedBasedPartTime extends PartTime {

    private Float fixedAmount;

    public FixedBasedPartTime() {
        super();
        fixedAmount = 0.0f;
    }

    public FixedBasedPartTime(Integer id, String name, Integer age, Vehicle vehicle, Float rate, Float hoursWorked, Float fixedAmount) {
        super(id, name, age, vehicle, rate, hoursWorked);
        this.fixedAmount = fixedAmount;
    }

    public FixedBasedPartTime(FixedBasedPartTime fixedBasedPartTime) {
        this.fixedAmount = fixedBasedPartTime.fixedAmount;
    }

    public Float getFixedAmount() {
        return fixedAmount;
    }

    public void setFixedAmount(Float fixedAmount) {
        this.fixedAmount = fixedAmount;
    }

    public Float fixedAmountcalcEarnings() {
        return ((getRate() * getHoursWorked()) + fixedAmount);
    }

    @Override
    public String printMyData() {
        return super.printMyData() + "\nFixed Based Part Time " +
                "Fixed Amount : " + fixedAmount;
    }
}
