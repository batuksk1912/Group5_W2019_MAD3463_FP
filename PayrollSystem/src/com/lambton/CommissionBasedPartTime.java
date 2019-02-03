package com.lambton;

public class CommissionBasedPartTime extends PartTime {

    private Float commission;

    public CommissionBasedPartTime() {
        super();
        commission = 0.0f;
    }

    public CommissionBasedPartTime(Integer id, String name, Integer age, Vehicle vehicle, Float rate, Float hoursWorked, Float commission) {
        super(id, name, age, vehicle, rate, hoursWorked);
        this.commission = commission;
    }

    public CommissionBasedPartTime(CommissionBasedPartTime commissionBasedPartTime) {
        this.commission = commissionBasedPartTime.commission;
    }

    public Float getCommission() {
        return commission;
    }

    public void setCommission(Float commission) {
        this.commission = commission;
    }

    public Float commissionPercalcEarnings() {
        return ((getRate() * getHoursWorked()) + commission);
    }

    @Override
    public String printMyData() {
        return super.printMyData() + "\nCommission Based Part Time" +
                "\nCommission : " + commission;
    }
}
