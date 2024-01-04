package com.microservices.departmentService.client;

import com.microservices.departmentService.model.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface EmployeeClient {

    @GetExchange(value = "employee/getEmployeesByDept/{deptId}")
    public List<Employee> getEmployeesByDepartment(@PathVariable("deptId") Long departmentId);
}
