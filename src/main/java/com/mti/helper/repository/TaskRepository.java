package com.mti.helper.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mti.helper.domain.Task;

/**
 * TaskRepository
 */
@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

}