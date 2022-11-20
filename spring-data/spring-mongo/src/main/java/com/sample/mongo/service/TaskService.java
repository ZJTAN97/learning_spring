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

    public Task getTaskById(String taskId) {
        return taskRepository.findById(taskId).get();
    }

    public List<Task> getTaskBySeverity(int severity) {
        return taskRepository.findBySeverity(severity);
    }

    public List<Task> getTaskByAssignee(String assignee) {
        return taskRepository.getTaskByAssignee(assignee);
    }

    public Task updateTask(Task taskRequest) {
        Task task = taskRepository.findById(taskRequest.getTaskId()).get();
        task.setDescription(taskRequest.getDescription());
        task.setSeverity(taskRequest.getSeverity());
        task.setStoryPoint(taskRequest.getStoryPoint());
        task.setAssignee(taskRequest.getAssignee());
        return taskRepository.save(task);
    }

    public String deleteTask(String taskId) {
        taskRepository.deleteById(taskId);
        return "Task deleted.";
    }


}
