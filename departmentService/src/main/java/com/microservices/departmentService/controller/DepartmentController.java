package com.microservices.departmentService.controller;

import com.microservices.departmentService.client.EmployeeClient;
import com.microservices.departmentService.model.Department;
import com.microservices.departmentService.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentRepository deptRepository;

    @Autowired
    private EmployeeClient employeeClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping(value = "/addDepartment")
    public Department add(@RequestBody Department department){
        LOGGER.info("Adding Department : {}", department);
        return deptRepository.addDepartment(department);
    }

    @GetMapping(value = "/getDeptById/{id}")
    public Department getDeptById(@PathVariable("id") Long id){
        LOGGER.info("Find Department By Id : {}", id);
        return deptRepository.findById(id);
    }

    @GetMapping(value = "/getAllDepartments")
    public List<Department> getAllDepartments(){
        LOGGER.info("Find All Departments");
        return deptRepository.getAllDepartments();
    }

    @GetMapping(value = "/getDepartmentsWithEmployees")
    public List<Department> getDepartmentsWithEmployees(){
        LOGGER.info("Get Department with Employees");
        List<Department> departments = deptRepository.getAllDepartments();
        departments.forEach( department -> {department.setEmployees(employeeClient.getEmployeesByDepartment(department.getId()));});
        return departments;
    }



}
