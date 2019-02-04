package com.lambton;

import java.util.EnumSet;
import java.util.Scanner;

public class Main {

    private static Scanner i;

    private static String hasVehicle = "DEFAULT";
    private static String vehicleType;
    private static String employeeId;
    private static String employeeName;
    private static String employeeAge;

    private static String rate;
    private static String hoursWorked;

    private static Intern intern;
    private static FixedBasedPartTime fixedBasedPartTime;
    private static CommissionBasedPartTime commissionBasedPartTime;
    private static FullTime fullTime;

    private static Car car;
    private static Motorcycle motorcycle;

    private static EmployeeRepositories employeeRepositories = EmployeeRepositories.getInstance();
    private static Employee employee;

    public static void showMainMenu() {
        clearScreen();
        System.out.println("Welcome to Payroll System. Please choose an option below:");
        System.out.println("1. Add a new Employee");
        System.out.println("2. Print current Employees list");
        System.out.println("3. Print Employee by ID");
        System.out.println("4. Delete Employee by ID");
        System.out.println("Q. Quit");
        System.out.print("Please enter your choice : ");
        String option = getAnswer("String");
        switch (option) {
            case "q":
                System.err.println("Do you wanna exit ? (Y/N)");
                String exit = getAnswer("String");
                if (exit.equals("Y") || exit.equals("y")) {
                    i.close();
                    System.exit(0);
                }
                break;

            case "1":
                //try-catch-dani-edit
                try {
                    System.out.print("Please enter  the Employee's ID:");
                    employeeId = getAnswer("Integer");
                } catch (Exception e) {
                    System.out.println("Error!");
                    i.reset();
                }


                System.out.print("Please enter  the Employee's NAME:");
                employeeName = getAnswer("String");
                System.out.print("Please enter the Employee's AGE :");
                employeeAge = getAnswer("Integer");
                showHasVehicleMenu();
                showEmployeeTypeMenu();
                break;

            case "2":
                clearScreen();
                System.out.println("List of current Employees:");
                for (Employee employee : employeeRepositories.getAllEmployee()) {
                    System.out.println(employee.printMyData());
                }
                System.out.println("\n\nTotal Earnings : " + employeeRepositories.getAllEarnings());
                System.err.println("\n\nPress any key to return to main menu...");
                getAnswer("String");
                showMainMenu();
                break;
            case "3":
                System.out.println("Please enter the Employee's ID:");
                String showId = getAnswer("Integer");
                employee = employeeRepositories.getEmployeeById(Integer.valueOf(showId));
                if (employee != null) {
                    System.out.println(employee.printMyData());
                    getAnswer("String");
                } else {
                    System.out.println("No Record found.");
                    getAnswer("String");
                }
                break;
            case "4":
                System.out.println("Please enter the Employee's ID:");
                String deleteId = getAnswer("Integer");
                employee = employeeRepositories.getEmployeeById(Integer.valueOf(deleteId));
                if (employee != null) {
                    employeeRepositories.removeEmployeeById(Integer.valueOf(deleteId));
                    System.out.println("Employee record deleted successfully.");
                    getAnswer("String");
                } else {
                    System.out.println("No Record found.");
                    getAnswer("String");
                }
                break;
            default:
                System.err.println("\n\nInvalid option! Press any key to return to main menu...");
                getAnswer("String");
                showMainMenu();
                break;
        }
    }

    public static boolean checkColor(String test) {

        for (Vehicle.Color c : Vehicle.Color.values()) {
            if (c.name().equals(test)) {
                return true;
            }
        }
        return false;
    }

    private static String getAnswer(String dataType) {
        String answer = null;
        Integer answerInt = null;
        Float answerFloat = null;
        i = new Scanner(System.in);

        boolean bError = true;
        do {
            if (dataType == "Integer") {
                try {
                    answerInt = Integer.parseInt(i.nextLine());
                    answer = answerInt.toString();
                    bError = false;
                } catch (Exception e) {
                    System.err.println("Error! Please enter an " + dataType + "!");
                    i.reset();
                }
            } else if (dataType == "Float") {
                try {
                    answerFloat = Float.parseFloat(i.nextLine());
                    answer = answerFloat.toString();
                    bError = false;
                } catch (Exception e) {
                    System.err.println("Error! Please enter an " + dataType + "!");
                    i.reset();
                }
            } else if (dataType == "EnumColor") {
                try {
                    answer = i.nextLine();
                    answer = answer.toUpperCase();
                    if (checkColor(answer)) {
                        bError = false;
                    } else {
                        throw new Exception("Invalid color! Try again!");
                    }
                } catch (Exception e) {
                    System.err.println("Error! Please enter a valid " + dataType + "!");
                    i.reset();
                }
            } else if (dataType == "String") {
                answer = i.nextLine();
                answer = answer.toLowerCase();
                bError = false;
            }
        } while (bError);
        return answer;
    }

    @SuppressWarnings("Duplicates")
    public static void showEmployeeTypeMenu() {
        clearScreen();
        System.out.println("Enter the Employee's CONTRACT TYPE:");
        System.out.println("1. Part-time");
        System.out.println("2. Intern");
        System.out.println("3. Full-time");
        System.out.print("Please enter your choice :");
        String option = getAnswer("Integer");
        switch (option) {
            case "1":
                System.out.print("Please enter the Employee's RATE :");
                rate = getAnswer("Float");
                System.out.print("Please enter the Employee's HOURS WORKED :");
                hoursWorked = getAnswer("Float");
                showPartTimeTypeMenu();
                break;
            case "2":
                System.out.print("Please enter the Employee's SCHOOL NAME :");
                String schoolName = getAnswer("String");
                if (hasVehicle == null) {
                    intern = new Intern(Integer.valueOf(employeeId), employeeName, Integer.valueOf(employeeAge), null, schoolName);
                    intern.setAge(intern.calcBirthYear(Integer.valueOf(employeeAge)));
                } else {
                    if (vehicleType.equals("Car")) {
                        intern = new Intern(Integer.valueOf(employeeId), employeeName, Integer.valueOf(employeeAge), car, schoolName);
                        intern.setAge(intern.calcBirthYear(Integer.valueOf(employeeAge)));
                    } else {
                        intern = new Intern(Integer.valueOf(employeeId), employeeName, Integer.valueOf(employeeAge), motorcycle, schoolName);
                        intern.setAge(intern.calcBirthYear(Integer.valueOf(employeeAge)));
                    }
                }
                employeeRepositories.addRecord(intern);
                break;
            case "3":
                System.out.print("Please enter the Employee's SALARY :");
                String salary = getAnswer("Float");
                System.out.print("Please enter the Employee's BONUS :");
                String bonus = getAnswer("Float");
                if (hasVehicle == null) {
                    fullTime = new FullTime(Integer.valueOf(employeeId), employeeName, Integer.valueOf(employeeAge), null, Float.valueOf(salary), Float.valueOf(bonus));
                    fullTime.setAge(fullTime.calcBirthYear(Integer.valueOf(employeeAge)));
                } else {
                    if (vehicleType.equals("Car")) {
                        fullTime = new FullTime(Integer.valueOf(employeeId), employeeName, Integer.valueOf(employeeAge), car, Float.valueOf(salary), Float.valueOf(bonus));
                        fullTime.setAge(fullTime.calcBirthYear(Integer.valueOf(employeeAge)));
                    } else {
                        fullTime = new FullTime(Integer.valueOf(employeeId), employeeName, Integer.valueOf(employeeAge), motorcycle, Float.valueOf(salary), Float.valueOf(bonus));
                        fullTime.setAge(fullTime.calcBirthYear(Integer.valueOf(employeeAge)));
                    }
                }
                employeeRepositories.addRecord(fullTime);
                break;
            default:
                System.err.println("Invalid option!");
                showEmployeeTypeMenu();
                break;
        }
    }

    @SuppressWarnings("Duplicates")
    public static void showPartTimeTypeMenu() {
        clearScreen();
        System.out.println("Enter the Employee's Part-time TYPE:");
        System.out.println("1. Commissioned based");
        System.out.println("2. Fixed Based");
        System.out.print("Please enter your choice :");
        String option = getAnswer("Integer");
        switch (option) {
            case "1":
                System.out.print("Please enter the Employee's COMMISSION :");
                String commission = getAnswer("Float");
                Float commissionRate = Float.valueOf(commission);
                Float totalCommission = ((Float.valueOf(rate) * Float.valueOf(hoursWorked)) * commissionRate) / 100.00f;
                if (hasVehicle == null) {
                    commissionBasedPartTime = new CommissionBasedPartTime(Integer.valueOf(employeeId), employeeName, Integer.valueOf(employeeAge), null, Float.valueOf(rate), Float.valueOf(hoursWorked), totalCommission);
                    commissionBasedPartTime.setAge(commissionBasedPartTime.calcBirthYear(Integer.valueOf(employeeAge)));
                } else {
                    if (vehicleType.equals("Car")) {
                        commissionBasedPartTime = new CommissionBasedPartTime(Integer.valueOf(employeeId), employeeName, Integer.valueOf(employeeAge), car, Float.valueOf(rate), Float.valueOf(hoursWorked), totalCommission);
                        commissionBasedPartTime.setAge(commissionBasedPartTime.calcBirthYear(Integer.valueOf(employeeAge)));
                    } else {
                        commissionBasedPartTime = new CommissionBasedPartTime(Integer.valueOf(employeeId), employeeName, Integer.valueOf(employeeAge), motorcycle, Float.valueOf(rate), Float.valueOf(hoursWorked), totalCommission);
                        commissionBasedPartTime.setAge(commissionBasedPartTime.calcBirthYear(Integer.valueOf(employeeAge)));
                    }
                }
                employeeRepositories.addRecord(commissionBasedPartTime);
                break;
            case "2":
                System.out.print("Please enter the Employee's FIXED AMOUNT :");
                String fixedAmount = getAnswer("Float");
                if (hasVehicle == null) {
                    fixedBasedPartTime = new FixedBasedPartTime(Integer.valueOf(employeeId), employeeName, Integer.valueOf(employeeAge), null, Float.valueOf(rate), Float.valueOf(hoursWorked), Float.valueOf(fixedAmount));
                    fixedBasedPartTime.setAge(fixedBasedPartTime.calcBirthYear(Integer.valueOf(employeeAge)));
                } else {
                    if (vehicleType.equals("Car")) {
                        fixedBasedPartTime = new FixedBasedPartTime(Integer.valueOf(employeeId), employeeName, Integer.valueOf(employeeAge), car, Float.valueOf(rate), Float.valueOf(hoursWorked), Float.valueOf(fixedAmount));
                        fixedBasedPartTime.setAge(fixedBasedPartTime.calcBirthYear(Integer.valueOf(employeeAge)));
                    } else {
                        fixedBasedPartTime = new FixedBasedPartTime(Integer.valueOf(employeeId), employeeName, Integer.valueOf(employeeAge), motorcycle, Float.valueOf(rate), Float.valueOf(hoursWorked), Float.valueOf(fixedAmount));
                        fixedBasedPartTime.setAge(fixedBasedPartTime.calcBirthYear(Integer.valueOf(employeeAge)));
                    }
                }
                employeeRepositories.addRecord(fixedBasedPartTime);
                break;
            default:
                System.err.println("Invalid option!");
                showPartTimeTypeMenu();
                break;
        }
    }

    public static void showHasVehicleMenu() {
        clearScreen();
        System.out.println("Does this Employee has a Vehicle?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Please enter your choice :");
        String option = getAnswer("Integer");
        switch (option) {
            case "1":
                showVehicleTypeMenu();
                break;
            case "2":
                hasVehicle = null;
                break;
            default:
                System.err.println("Invalid option!");
                showHasVehicleMenu();
                break;
        }
    }

    public static void showVehicleTypeMenu() {
        clearScreen();
        System.out.println("Please enter the Vehicle's TYPE");
        System.out.println("1. Car");
        System.out.println("2. Motorcycle");
        System.out.print("Please enter your choice :");
        String option = getAnswer("Integer");
        EnumSet<Vehicle.Color> allColors = EnumSet.allOf(Vehicle.Color.class);
        switch (option) {
            case "1":
                vehicleType = "Car";
                System.out.print("Please enter the car's MAKE :");
                String carMake = getAnswer("String");

                System.out.print("Please enter the car's COLOR " + allColors + " :");
                String carColor = getAnswer("EnumColor");

                System.out.print("Please enter the car's YEAR :");
                String carYear = getAnswer("Integer");
                System.out.print("Please enter the car's PLATE :");
                String carPlate = getAnswer("String");
                System.out.print("Please enter the car's SEAT NUMBER :");
                String carSeats = getAnswer("Integer");
                System.out.print("Please enter the car's DOOR NUMBER :");
                String carDoors = getAnswer("Integer");
                car = new Car(carMake, carPlate, Integer.valueOf(carYear), Car.Color.valueOf(carColor.toUpperCase()), Integer.valueOf(carSeats), Integer.valueOf(carDoors));
                break;
            case "2":
                vehicleType = "Motorcycle";
                System.out.print("Please enter the motorcycle's MAKE :");
                String motorcycleMake = getAnswer("String");

                System.out.print("Please enter the motorcycle's COLOR " + allColors + " :");
                String motorcycleColor = getAnswer("EnumColor");

                System.out.print("Please enter the motorcycle's YEAR :");
                String motorcycleYear = getAnswer("Integer");
                System.out.print("Please enter the motorcycle's PLATE :");
                String motorcyclePlate = getAnswer("String");
                System.out.print("Please enter the motorcycle's SIDE CAR INFORMATION :");
                String motorcycleSideCar = getAnswer("String");
                System.out.print("Please enter the motorcycle's BREAK TYPE :");
                String motorcycleBrakeType = getAnswer("String");
                motorcycle = new Motorcycle(motorcycleMake, motorcyclePlate, Integer.valueOf(motorcycleYear), Motorcycle.Color.valueOf(motorcycleColor.toUpperCase()), motorcycleSideCar, motorcycleBrakeType);
                break;
            default:
                System.err.println("Invalid option!");
                showVehicleTypeMenu();
                break;
        }
    }

    public static void clearScreen() {
        for (int clear = 0; clear < 1000; clear++) {
            System.out.println("\b");
        }
    }

    public static void main(String[] args) {
        try {
        while (true) {
            showMainMenu();
        }
        } catch (Exception e) {
                System.err.println("Something went wrong!");
        }
        /*
        Employee emp = e.getEmployeeById(1);
        System.out.println(emp.printMyData()); Case 3 get employee by id and Case 4 remove employee by id*/
    }
}