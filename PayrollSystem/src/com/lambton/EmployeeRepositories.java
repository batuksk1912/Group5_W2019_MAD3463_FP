package com.lambton;

import java.util.ArrayList;

public class EmployeeRepositories {

    private static EmployeeRepositories INSTANCE;
    private ArrayList<Employee> arr;

    private EmployeeRepositories() {
        arr = new ArrayList<>();
    }

    public static EmployeeRepositories getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EmployeeRepositories();
        }
        return INSTANCE;
    }

    public void addOrder(Employee employee) {
        arr.add(employee);
    }

    public Employee getEmployeeById(Integer employeeId) {
        for (Employee e : arr) {
            if (e.getId().equals(employeeId)) {
                return e;
            }
        }
        return null;
    }

    public void removeOrder(Employee e) {
        arr.remove(e);
    }

    public void removeOrderById(Integer employeeId) {
        for (Employee e : arr) {
            if (e.getId().equals(employeeId)) {
                arr.remove(e);
            }
        }
    }

    public ArrayList<Employee> getAllEmployee() {
        return arr;
    }

    public Float getAllEarnings() {
        Float totalEarnings = 0.0f;
        for (Employee e : arr) {
            if (!(e instanceof CommissionBasedPartTime) && !(e instanceof FixedBasedPartTime)) {
                totalEarnings = totalEarnings + e.calcEarnings();
            } else if (e instanceof CommissionBasedPartTime) {
                totalEarnings = totalEarnings + ((CommissionBasedPartTime) e).commissionPercalcEarnings();
            } else {
                totalEarnings = totalEarnings + ((FixedBasedPartTime) e).fixedAmountcalcEarnings();
            }
        }
        return totalEarnings;
    }
}
