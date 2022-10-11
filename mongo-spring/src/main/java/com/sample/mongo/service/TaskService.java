package com.sample.mongo.service;

import com.sample.mongo.model.Task;
import com.sample.mongo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task addTask(Task task) {
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        return taskRepository.save(task);
    }

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }
    // https://www.youtube.com/watch?v=qVNOw9TWwxo
    // TODO: 15:26

}
