package com.web.restful.api.service;

import com.web.restful.api.entity.Worker;
import com.web.restful.api.error.WorkerNotFoundException;
import com.web.restful.api.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {


    private final WorkerRepository workerRepository;

    @Autowired
    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public Worker saveWorker(Worker worker) {
        return workerRepository.save(worker);
    }

    public List<Worker> getWorker() {
        return workerRepository.findAll();
    }

    public Worker getWorkerByID(Long id) throws WorkerNotFoundException {
        Optional<Worker> worker = workerRepository.findById(id);
        if (!worker.isPresent()) {
            throw new WorkerNotFoundException("Worker not exist (" + id + ")");
        }
        return worker.get();
    }

    public void deleteWorkerByID(Long id) {
        workerRepository.deleteById(id);
    }

    public List<Worker> updateWorker(List<Worker> workers) throws WorkerNotFoundException {

        List<Worker> dbWorkers = new ArrayList<>();

        for (Worker worker : workers) {
            Worker dbWorker = getWorkerByID(worker.getWorkerId());
            if (worker.getBirth() != null) {
                dbWorker.setBirth(worker.getBirth());
            }
            if (worker.getEmail() != null && !"".equalsIgnoreCase(worker.getEmail())) {
                dbWorker.setEmail(worker.getEmail());
            }
            if (worker.getLastName() != null && !"".equalsIgnoreCase(worker.getLastName())) {
                dbWorker.setLastName(worker.getLastName());
            }
            if (worker.getName() != null && !"".equalsIgnoreCase(worker.getName())) {
                dbWorker.setName(worker.getName());
            }

            dbWorkers.add(dbWorker);
        }

        for (Worker worker : dbWorkers)
        {
            workerRepository.save(worker);
        }
        return dbWorkers;
    }
}
