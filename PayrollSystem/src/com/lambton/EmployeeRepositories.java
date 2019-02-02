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
            if (e.getId() == employeeId) {
                return e;
            }
        }
        return null;
    }

    public void removeOrder(Employee e) {
        arr.remove(e);
    }

    public void removeOrder(Integer employeeId) {
        for (Employee e : arr) {
            if (e.getId() == employeeId) {
                arr.remove(e);
            }
        }
    }

    public ArrayList<Employee> getAllEmployee() {
        return arr;
    }
}
