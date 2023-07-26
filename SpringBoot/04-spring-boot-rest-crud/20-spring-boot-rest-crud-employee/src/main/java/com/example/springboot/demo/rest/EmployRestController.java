package com.example.springboot.demo.rest;

import com.example.springboot.demo.entity.Employee;
import com.example.springboot.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployRestController(EmployeeService theEmployeeSevice){
        employeeService = theEmployeeSevice;
    }

    //Get all employee
    @GetMapping("/employee")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    //Mapping for get employee by id
    @GetMapping("/employee/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmploy = employeeService.findById(employeeId);
        if (theEmploy == null) {
            throw new RuntimeException("Employee id not found "+employeeId);
        }
        return theEmploy;
    }

    //Add mapping for POST
    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    //Mapping for PUT
    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @DeleteMapping("/employee/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee theEmploy = employeeService.findById(employeeId);
        if (theEmploy == null) {
            throw new RuntimeException("Employee id not found "+employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted employee id- "+ employeeId;
    }
}
