package com.lambton;

public class Intern extends Employee {

    private String schoolName;

    public Intern() {
        super();
        this.schoolName = null;
    }

    public Intern(Integer id, String name, Integer age, Vehicle vehicle, String schoolName) {
        super(id, name, age, vehicle);
        this.schoolName = schoolName;
    }

    public Intern(Intern intern) {
        this.schoolName = intern.schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String printMyData() {
        return super.printMyData() + "\nEmployee Type : Intern" +
                "\nSchool Name : " + schoolName +
                "\nEarnings : " + calcEarnings();
    }
}
