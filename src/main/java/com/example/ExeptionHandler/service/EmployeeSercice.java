package com.example.ExeptionHandler.service;

import com.example.ExeptionHandler.entity.Employee;
import com.example.ExeptionHandler.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeSercice {
    private static List<Employee> list = new ArrayList<>();

    static {
        Employee e = new Employee(1,"Employee 1", 35, "Iran");
        list.add(e);
        e =  new Employee(2,"Employee 2", 55, "Pakistan");
        list.add(e);
         e = new Employee(3,"Employee 3", 49, "Deutschland");
        list.add(e);
        e = new Employee(4,"Employee 4", 66, "Turki");
        list.add(e);
        e = new Employee(5,"Employee 5", 8, "USA");
        list.add(e);
    }
    public Employee getEmployee(Integer id){
        Optional<Employee> theEmployee = list.stream().filter(e -> e.getId() == id).findFirst();
            if (theEmployee.isPresent()) {
                throw new EmployeeNotFoundException("Employee not found for the id ->"+id);
            }
        return theEmployee.get();
        }

}
