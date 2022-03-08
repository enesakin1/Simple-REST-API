package com.web.restful.api.controller;

import com.web.restful.api.entity.Department;
import com.web.restful.api.error.DepartmentNotFoundException;
import com.web.restful.api.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/department")
public class DepartmentController {

    DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("get/{id}")
    public Department getById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping("save")
    public Department saveDepartment(@RequestBody Department department) {

        return departmentService.saveDepartment(department);
    }

    @DeleteMapping("delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        departmentService.deleteById(id);
        return "Deleted department that id = " + id;
    }

    @PutMapping("update")
    public List<Department> updateDepartments(@RequestBody List<Department> departments) throws DepartmentNotFoundException {
        return departmentService.updateDepartment(departments);
    }
}
