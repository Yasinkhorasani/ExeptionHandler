package com.example.ExeptionHandler.controller;

import com.example.ExeptionHandler.entity.Employee;
import com.example.ExeptionHandler.exceptions.EmployeeNotFoundException;
import com.example.ExeptionHandler.exceptions.ErrorObject;
import com.example.ExeptionHandler.service.EmployeeSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeSercice eService;

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable Integer id){
        return eService.getEmployee(id);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorObject> handleException(EmployeeNotFoundException ex) {
        ErrorObject eObject = new ErrorObject();
        eObject.setStatus(HttpStatus.NOT_FOUND.value());
        eObject.setMessage(ex.getMessage());
        eObject.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<ErrorObject>(eObject, HttpStatus.NOT_FOUND);
    }

}
