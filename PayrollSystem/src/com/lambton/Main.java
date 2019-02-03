package com.lambton;

public class Main {


    public static void main(String[] args) {

        EmployeeRepositories e = EmployeeRepositories.getInstance();

        Intern in = new Intern(1, "Baturay", 25, null, "Lambton College");
        in.setAge(in.calcBirthYear(25));

        e.addOrder(in);

        Employee emp = e.getEmployeeById(1);

        System.out.println(emp.printMyData());

        for (Employee em : e.getAllEmployee()) {
            System.out.println(em.printMyData());
        }

    }
}
