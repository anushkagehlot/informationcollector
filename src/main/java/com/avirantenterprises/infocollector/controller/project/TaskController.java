package com.avirantenterprises.infocollector.controller.project;

import com.avirantenterprises.infocollector.model.project.Task;
import com.avirantenterprises.infocollector.service.project.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    private final String uploadDir = "uploads/project/";

    @GetMapping("/tasks")
    public String showTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "project/taskList";
    }

    @GetMapping("/task/new")
    public String showTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "project/taskForm";
    }

    @PostMapping("/task/save")
    public String saveTask(@ModelAttribute Task task, @RequestParam("attachment") MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                Path filePath = Paths.get(uploadDir).resolve(fileName).normalize();
                Files.createDirectories(filePath.getParent());
                Files.write(filePath, file.getBytes());
                task.setAttachmentPath(filePath.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/task/new?error";
        }

        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/task/edit/{id}")
    public String editTask(@PathVariable Long id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "project/taskForm";
    }

    @GetMapping("/task/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTaskById(id);
        return "redirect:/tasks";
    }

    @GetMapping("/task/view/{id}")
    public String viewTask(@PathVariable Long id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "project/taskView";
    }
}
