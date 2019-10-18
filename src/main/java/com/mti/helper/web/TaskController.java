package com.mti.helper.web;

import javax.validation.Valid;

import com.mti.helper.domain.Task;
import com.mti.helper.repository.TaskRepository;
import com.mti.helper.utils.ResponseFormat;
import com.mti.helper.utils.TaskNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * TaskController
 */


@RestController
@RequestMapping("api/v1")
public class TaskController {

    TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/hello")
    ResponseEntity<ResponseFormat> hello() {

        ResponseFormat responseFormat = new ResponseFormat("false", "You are successfully Connected!");
        return new ResponseEntity<ResponseFormat>(responseFormat, HttpStatus.OK);
    }
    

    
    @GetMapping("/tasks")
    ResponseEntity<ResponseFormat> getTasks() {

        ResponseFormat responseFormat = new ResponseFormat("false", taskRepository.findAll());
        return new ResponseEntity<ResponseFormat>(responseFormat, HttpStatus.OK);
    }

    @PostMapping("/task")
    ResponseEntity<ResponseFormat> addTask(@Valid @RequestBody Task task) {

        ResponseFormat responseFormat = new ResponseFormat("false", taskRepository.save(task));
        return new ResponseEntity<>(responseFormat, HttpStatus.CREATED);
    }

    @DeleteMapping("/task")
    ResponseEntity<ResponseFormat> deleteWishById(@RequestParam("id") Long id) throws TaskNotFoundException {
        Task task= taskRepository.findById(id).orElseThrow(()-> new TaskNotFoundException(id));
        taskRepository.delete(task);
        ResponseFormat responseFormat = new ResponseFormat("false","wish deleted successfully" );
        return new ResponseEntity<>(responseFormat, HttpStatus.OK);
    }


    
}