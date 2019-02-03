package com.lambton;

import java.util.Scanner;


public class Main {

    private static Scanner i;

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
                    //s.close();
                    System.exit(0);
                }
                break;

            case "1":
                System.out.println("Please enter  the Employee's NAME:");
                String employeeName = getAnswer();
                System.out.println("Please enter the Employee's AGE :");
                String employeeAge = getAnswer();
                showEmployeeTypeMenu();
                break;

            case "2":
                System.out.println("List of current Employees:");
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
        Scanner s = new Scanner(System.in);
        i = new Scanner(System.in);
        answer = i.nextLine();
        return answer.toLowerCase();
    }

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
                showPartTimeTypeMenu();
                break;

            case "2":
                System.out.println("Please enter the Employee's SCHOOL NAME :");
                String schoolName = getAnswer();
                showHasVehicleMenu();
                break;
            case "3":
                System.out.println("Please enter the Employee's SALLARY :");
                String sallary = getAnswer();
                System.out.println("Please enter the Employee's BONUS :");
                String bonus = getAnswer();
                showHasVehicleMenu();
                break;
            default:
                System.out.println("Invalid option!");
                showEmployeeTypeMenu();
                break;
        }
    }

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
                String commission = getAnswer();
                showHasVehicleMenu();
                break;

            case "2":
                System.out.println("Please enter the Employee's FIXED AMOUNT :");
                String fixedAmount = getAnswer();
                showHasVehicleMenu();
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
                showMainMenu();
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
                System.out.println("Please enter the car's MAKE :");
                String carMake = getAnswer();
                System.out.println("Please enter the car's COLOR :");
                String carcColor = getAnswer();
                System.out.println("Please enter the car's YEAR :");
                String carYear = getAnswer();
                System.out.println("Please enter the car's PLATE :");
                String carPlate = getAnswer();
                showMainMenu();
                break;

            case "2":
                System.out.println("Please enter the motorcycle's MAKE :");
                String motorcycleMake = getAnswer();
                System.out.println("Please enter the motorcycle's COLOR :");
                String motorcycleColor = getAnswer();
                System.out.println("Please enter the motorcycle's YEAR :");
                String motorcycleYear = getAnswer();
                System.out.println("Please enter the motorcycle's PLATE :");
                String motorcyclePlate = getAnswer();
                showMainMenu();
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
            showMainMenu();
        }
    }
}