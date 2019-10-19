
package com.mti.helper.web;

import com.mti.helper.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    // Initaial Page
    @RequestMapping({ "", "/", "/index" })
    public String init(Model model) {
        model.addAttribute("data", "tareq");

        return "index"; // here index is the html page or link
    }

    // tasks page
    @RequestMapping({ "/tasks" })
    public String getTasks(Model model) {

        model.addAttribute("datas", taskRepository.findAll());

        return "tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        System.out.println("Delete");
      
       
        taskRepository.deleteById(id);

        return "redirect:/tasks";
    }

}