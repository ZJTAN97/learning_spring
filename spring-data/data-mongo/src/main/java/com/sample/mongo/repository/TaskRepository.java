package com.sample.mongo.repository;

import com.sample.mongo.model.Task;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findBySeverity(int severity);

    // custom query
    @Query("{assignee: ?0}")
    List<Task> getTaskByAssignee(String assignee);
}
