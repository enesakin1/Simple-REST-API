package com.web.restful.api.controller;

import com.web.restful.api.entity.Worker;
import com.web.restful.api.error.WorkerNotFoundException;
import com.web.restful.api.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/worker")
public class WorkerController {

    private final WorkerService workerService;

    @Autowired
    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @PostMapping("save")
    public Worker saveWorker(@RequestBody Worker worker) {

        return workerService.saveWorker(worker);
    }

    @GetMapping("get")
    public List<Worker> getWorker() {
        return workerService.getWorker();
    }

    @GetMapping("get/{id}")
    public Worker getWorkerByID(@PathVariable("id") Long id) throws WorkerNotFoundException {
        return workerService.getWorkerByID(id);
    }

    @DeleteMapping("delete/{id}")
    public String deleteWorkerByID(@PathVariable("id") Long id) {
        workerService.deleteWorkerByID(id);
        return "Deleted worker that have id " + id;
    }

    @PutMapping("update")
    public List<Worker> updateWorker(@RequestBody List<Worker> workers) throws WorkerNotFoundException {
        return workerService.updateWorker(workers);
    }
}

