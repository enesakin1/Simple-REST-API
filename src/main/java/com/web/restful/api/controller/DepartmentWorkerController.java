package com.web.restful.api.controller;

import com.web.restful.api.entity.Department;
import com.web.restful.api.entity.Worker;
import com.web.restful.api.error.DepartmentNotFoundException;
import com.web.restful.api.error.WorkerNotFoundException;
import com.web.restful.api.service.DepartmentService;
import com.web.restful.api.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class DepartmentWorkerController {

    DepartmentService departmentService;
    WorkerService workerService;

    @Autowired
    public DepartmentWorkerController(DepartmentService departmentService, WorkerService workerService) {
        this.departmentService = departmentService;
        this.workerService = workerService;
    }

    @PutMapping("department/{departmentId}/worker/{workerId}")
    public Department assignWorkerToDepartment(@PathVariable("departmentId") Long departmentId, @PathVariable("workerId") Long workerId) throws WorkerNotFoundException, DepartmentNotFoundException {
        Department department = departmentService.getDepartmentById(departmentId);
        Worker worker = workerService.getWorkerByID(workerId);
        worker.setDepartment(department);
        return departmentService.saveDepartment(department);
    }
}
