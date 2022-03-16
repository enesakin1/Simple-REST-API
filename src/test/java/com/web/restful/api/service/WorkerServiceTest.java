package com.web.restful.api.service;

import com.web.restful.api.entity.Worker;
import com.web.restful.api.repository.WorkerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class WorkerServiceTest {

    @Autowired
    WorkerService workerService;

    @MockBean
    WorkerRepository workerRepository;

    Worker worker;

    @BeforeEach
    void setUp() {


        worker = Worker.builder()
                .workerId(1l)
                .birth(LocalDate.of(1999, 8, 24))
                .email("enes_kln@hotmail.com")
                .name("Enes")
                .lastName("Akın")
                .build();

        Mockito.when(workerRepository.save(worker)).thenReturn(worker);
    }

    @Test
    @DisplayName("Save Worker to DB")
    public void whenSavingWorkerToDB_ReturnsSavedWorkerEntity() {

        Worker returnedWorker = workerService.saveWorker(worker);

        assertEquals(worker,returnedWorker);
    }

}