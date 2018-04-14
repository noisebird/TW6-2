package com.example.employeeapi.controller;

import com.example.employeeapi.datasource.EmployeeRepository;
import com.example.employeeapi.model.Employee;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@EnableAutoConfiguration
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping("/employees")
    String getEmployees(Model model) {
        List<Employee> list=employeeRepository.getAllEmployees();
        model.addAttribute("message", list);

        return "employees";
    }


    @GetMapping("/employees/{id}")
    ResponseEntity getEmployee(@PathVariable("id") int id) {
        return new ResponseEntity<>(employeeRepository.getEmployee(id), HttpStatus.OK);
    }
}
