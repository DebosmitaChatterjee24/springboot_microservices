package com.microservices.departmentService.repository;

import com.microservices.departmentService.model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository {

    List<Department> departmentList = new ArrayList<>();

//    create department
    public Department addDepartment(Department department) {
        departmentList.add(department);
        return department;
    }

//    find departmentById
    public Department findById(Long id) {
        return departmentList.stream()
                .filter(department -> department.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

//    get all departments
    public List<Department> getAllDepartments(){
        return departmentList;
    }


}
