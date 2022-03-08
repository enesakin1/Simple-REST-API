package com.web.restful.api.service;

import com.web.restful.api.entity.Department;
import com.web.restful.api.entity.Worker;
import com.web.restful.api.error.DepartmentNotFoundException;
import com.web.restful.api.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentService {

    DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Long id) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(id);
        if (!department.isPresent()) {
            throw new DepartmentNotFoundException("Department not exist (" + id + ")");
        }
        return department.get();
    }

    public Department assignWorker(Department department, Worker worker) {
        return saveDepartment(department);
    }

    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }

    public List<Department> updateDepartment(List<Department> departments) throws DepartmentNotFoundException {
        List<Department> dbDepartments = new ArrayList<>();
        for (Department department : departments) {
            Department dbDepartment = getDepartmentById(department.getDepartmentId());
            if (Objects.nonNull(department.getName()) && !"".equalsIgnoreCase(department.getName())) {
                dbDepartment.setName(department.getName());
            }
            dbDepartments.add(dbDepartment);
        }

        for (Department department : dbDepartments){
            departmentRepository.save(department);
        }

        return dbDepartments;
    }
}
