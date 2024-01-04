package com.microservices.employeeService.controller;

import com.microservices.employeeService.model.Employee;
import com.microservices.employeeService.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository empRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @PostMapping(value = "addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        LOGGER.info("Adding Employee : {}", employee);
        return empRepository.addEmployee(employee);
    }

    @GetMapping(value = "getEmpById/{id}")
    public Employee getEmpById(@PathVariable("id") Long id){
        LOGGER.info("Find Employee By Id : {}", id);
        return empRepository.findEmployeeById(id);
    }

    @GetMapping(value = "/getAllEmployees")
    public List<Employee> getAllEmployees(){
        LOGGER.info("Find All Employees");
        return empRepository.getAllEmployees();
    }

    @GetMapping(value = "getEmployeesByDept/{deptId}")
    public List<Employee> getEmployeesByDepartment(@PathVariable("deptId") Long departmentId){
        LOGGER.info("Find Employee By Department : {}", departmentId);
        return empRepository.findByDepartment(departmentId);
    }

}
