package com.lambton;
import java.util.Scanner;

public class Main {

    private static Scanner i;

    private static String hasVehicle = "DEFAULT";
    private static String vehicleType;
    private static String employeeId;
    private static String employeeName;
    private static String employeeAge;

    private static String carMake;
    private static String carColor;
    private static String carYear;
    private static String carPlate;
    private static String carSeats;
    private static String carDoors;

    private static String motorcycleMake;
    private static String motorcycleColor;
    private static String motorcycleYear;
    private static String motorcyclePlate;
    private static String motorcycleSideCar;
    private static String motorcycleBrakeType;

    private static String commission;
    private static String fixedAmount;
    private static String rate;
    private static String hoursWorked;

    private static String schoolName;

    private static String salary;
    private static String bonus;

    private static Intern intern;
    private static FixedBasedPartTime fixedBasedPartTime;
    private static CommissionBasedPartTime commissionBasedPartTime;
    private static FullTime fullTime;

    private static Car car;
    private static Motorcycle motorcycle;

    private static EmployeeRepositories employeeRepositories = EmployeeRepositories.getInstance();


    public static void showMainMenu() {
        clearScreen();
        System.out.println("Welcome to Payroll System. Please choose an option below:");
        System.out.println("1. Add a new Employee");
        System.out.println("2. Print current Employees list");
        System.out.println("Q. Quit");
        System.out.println("Please enter your choice :");
        String option = getAnswer();
        switch (option) {
            case "q":
                System.out.println("Do you wanna exit ? (Y/N)");
                String e = getAnswer();
                if (e.equals("Y") || e.equals("y")) {
                    i.close();
                    System.exit(0);
                }
                break;

            case "1":
                System.out.println("Please enter  the Employee's ID:");
                employeeId = getAnswer();
                System.out.println("Please enter  the Employee's NAME:");
                employeeName = getAnswer();
                System.out.println("Please enter the Employee's AGE :");
                employeeAge = getAnswer();
                showHasVehicleMenu();
                showEmployeeTypeMenu();
                break;

            case "2":
                System.out.println("List of current Employees:");
                for (Employee employee : employeeRepositories.getAllEmployee()) {
                    System.out.println(employee.printMyData());
                }
                System.out.println("\n\n\nTotal Earnings : " + employeeRepositories.getAllEarnings());
                getAnswer();
                showMainMenu();
                break;
            default:
                System.out.println("Invalid option!");
                showMainMenu();
                break;
        }
    }

    private static String getAnswer() {
        String answer;
        i = new Scanner(System.in);
        answer = i.nextLine();
        return answer.toLowerCase();
    }

    @SuppressWarnings("Duplicates")
    public static void showEmployeeTypeMenu() {
        clearScreen();
        System.out.println("Enter the Employee's CONTRACT TYPE:");
        System.out.println("1. Part-time");
        System.out.println("2. Intern");
        System.out.println("3. Full-time");
        System.out.println("Please enter your choice :");
        String option = getAnswer();
        switch (option) {
            case "1":
                System.out.println("Please enter the Employee's RATE :");
                rate = getAnswer();
                System.out.println("Please enter the Employee's HOURS WORKED :");
                hoursWorked = getAnswer();
                showPartTimeTypeMenu();
                break;
            case "2":
                System.out.println("Please enter the Employee's SCHOOL NAME :");
                schoolName = getAnswer();
                Integer employeeIntegerId = Integer.valueOf(employeeId);
                Integer employeeIntegerAge = Integer.valueOf(employeeAge);
                if (hasVehicle == null) {
                    intern = new Intern(employeeIntegerId, employeeName, employeeIntegerAge, null, schoolName);
                    intern.setAge(intern.calcBirthYear(employeeIntegerAge));
                } else {
                    if (vehicleType.equals("Car")) {
                        intern = new Intern(employeeIntegerId, employeeName, employeeIntegerAge, car, schoolName);
                        intern.setAge(intern.calcBirthYear(employeeIntegerAge));
                    } else {
                        intern = new Intern(employeeIntegerId, employeeName, employeeIntegerAge, motorcycle, schoolName);
                        intern.setAge(intern.calcBirthYear(employeeIntegerAge));
                    }
                }
                employeeRepositories.addOrder(intern);
                break;
            case "3":
                System.out.println("Please enter the Employee's SALARY :");
                salary = getAnswer();
                System.out.println("Please enter the Employee's BONUS :");
                bonus = getAnswer();
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
                employeeRepositories.addOrder(fullTime);
                break;
            default:
                System.out.println("Invalid option!");
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
        System.out.println("Please enter your choice :");
        String option = getAnswer();
        switch (option) {
            case "1":
                System.out.println("Please enter the Employee's COMMISSION :");
                commission = getAnswer();
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
                employeeRepositories.addOrder(commissionBasedPartTime);
                break;
            case "2":
                System.out.println("Please enter the Employee's FIXED AMOUNT :");
                fixedAmount = getAnswer();
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
                employeeRepositories.addOrder(fixedBasedPartTime);
                break;
            default:
                System.out.println("Invalid option!");
                showPartTimeTypeMenu();
                break;
        }
    }

    public static void showHasVehicleMenu() {
        clearScreen();
        System.out.println("Does this Employee has a Vehicle?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.println("Please enter your choice :");
        String option = getAnswer();
        switch (option) {
            case "1":
                showVehicleTypeMenu();
                break;
            case "2":
                hasVehicle = null;
                break;
            default:
                System.out.println("Invalid option!");
                showHasVehicleMenu();
                break;
        }
    }

    public static void showVehicleTypeMenu() {
        clearScreen();
        System.out.println("Please enter the Vehicle's TYPE");
        System.out.println("1. Car");
        System.out.println("2. Motorcycle");
        System.out.println("Please enter your choice :");
        String option = getAnswer();
        switch (option) {
            case "1":
                vehicleType = "Car";
                System.out.println("Please enter the car's MAKE :");
                carMake = getAnswer();
                System.out.println("Please enter the car's COLOR :");
                carColor = getAnswer();
                System.out.println("Please enter the car's YEAR :");
                carYear = getAnswer();
                System.out.println("Please enter the car's PLATE :");
                carPlate = getAnswer();
                System.out.println("Please enter the car's SEAT NUMBER :");
                carSeats = getAnswer();
                System.out.println("Please enter the car's DOOR NUMBER :");
                carDoors = getAnswer();
                Integer carYearInteger = Integer.valueOf(carYear);
                Integer carSeatsInteger = Integer.valueOf(carSeats);
                Integer carDoorsInteger = Integer.valueOf(carDoors);
                car = new Car(carMake, carPlate, carYearInteger, Car.Color.valueOf(carColor.toUpperCase()), carSeatsInteger, carDoorsInteger);
                break;
            case "2":
                vehicleType = "Motorcycle";
                System.out.println("Please enter the motorcycle's MAKE :");
                motorcycleMake = getAnswer();
                System.out.println("Please enter the motorcycle's COLOR :");
                motorcycleColor = getAnswer();
                System.out.println("Please enter the motorcycle's YEAR :");
                motorcycleYear = getAnswer();
                System.out.println("Please enter the motorcycle's PLATE :");
                motorcyclePlate = getAnswer();
                System.out.println("Please enter the motorcycle's SIDE CAR INFORMATION :");
                motorcycleSideCar = getAnswer();
                System.out.println("Please enter the motorcycle's BREAK TYPE :");
                motorcycleBrakeType = getAnswer();
                Integer motorcycleYearInteger = Integer.valueOf(motorcycleYear);
                motorcycle = new Motorcycle(motorcycleMake, motorcyclePlate, motorcycleYearInteger, Motorcycle.Color.valueOf(motorcycleColor.toUpperCase()), motorcycleSideCar, motorcycleBrakeType);
                break;
            default:
                System.out.println("Invalid option!");
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

        while (true) {
            //try {
            showMainMenu();
            //} catch (Exception e) {
            //System.out.println("Something went wrong!");
            //}
        }

        //Intern in = new Intern(1, "Baturay", 25, null, "Lambton College");
        //in.setAge(in.calcBirthYear(25));

        /*e.addOrder(in);

        Employee emp = e.getEmployeeById(1);

        System.out.println(emp.printMyData());

        for (Employee em : e.getAllEmployee()) {
            System.out.println(em.printMyData());
        }*/
    }
}