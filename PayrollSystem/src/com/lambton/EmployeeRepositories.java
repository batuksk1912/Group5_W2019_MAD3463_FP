package com.lambton;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Iterator;

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

    public void addRecord(Employee employee) {
        arr.add(employee);
    }

    public Employee getEmployeeById(Integer employeeId) {
        for (Employee employee : arr) {
            if (employee.getId().equals(employeeId)) {
                return employee;
            }
        }
        return null;
    }

    public void removeEmployeeById(Integer employeeId) {
        for (Iterator<Employee> iteratorEmployee = arr.iterator(); iteratorEmployee.hasNext(); ) {
            Employee employee = iteratorEmployee.next();
            if (employee.getId().equals(employeeId)) {
                iteratorEmployee.remove();
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
