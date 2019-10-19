package com.mti.helper.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "key_name")
    @NotBlank(message = "key is required")
    String key;

    @NotBlank(message = "value is required")
    String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Task() {
    }

    public Task(Long id, @NotBlank(message = "key is required") String key,
            @NotBlank(message = "value is required") String value) {
        this.id = id;
        this.key = key;
        this.value = value;
    }

    
}