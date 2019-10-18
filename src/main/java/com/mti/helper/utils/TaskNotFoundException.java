package com.mti.helper.utils;

/**
 * TaskNotFoundException
 */
@SuppressWarnings("serial")
public class TaskNotFoundException extends Exception {
    Long id;

    public TaskNotFoundException(Long id) {
        super(String.format("Task is not found with Id: '%s'", id));

    }

    
}

    
