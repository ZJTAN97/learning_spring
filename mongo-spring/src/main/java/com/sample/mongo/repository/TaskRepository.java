package com.sample.mongo.repository;

import com.sample.mongo.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
}
