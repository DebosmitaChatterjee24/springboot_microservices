package com.microservices.employeeService.repository;

import com.microservices.employeeService.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    List<Employee> employeeList = new ArrayList<>();

    // add employee
    public Employee addEmployee(Employee employee) {
        employeeList.add(employee);
        return employee;
    }

    // find employee by Id
    public Employee findEmployeeById(Long id){

        return employeeList.stream().filter(e -> e.id().equals(id)).findFirst().orElseThrow();
    }

    // get all employees
    public List<Employee> getAllEmployees(){
        return employeeList;
    }

    // get employee by department
    public List<Employee> findByDepartment(Long deparmentId){
        return employeeList.stream().filter(e -> e.departmentId().equals(deparmentId)).toList();
    }
}
