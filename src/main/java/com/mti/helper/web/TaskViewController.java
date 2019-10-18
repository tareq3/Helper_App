
package com.mti.helper.web;

import com.mti.helper.domain.Task;
import com.mti.helper.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TaskViewController
 */
@Controller
public class TaskViewController {

    TaskRepository taskRepository;

    @Autowired
    public TaskViewController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @RequestMapping({ "/tasks", "", "/", })
    public String getTasks(Model model) {

        model.addAttribute("tasks", taskRepository.findAll());

        return "tasks";
    }

    @RequestMapping("delete/{id}")
    public String deleteTask(Model model, Task task) {
        System.out.println("Delete");
        taskRepository.delete(task);

        return "tasks";
    }

}