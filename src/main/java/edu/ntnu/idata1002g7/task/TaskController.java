package edu.ntnu.idata1002g7.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @PostMapping
    public void registerNewTask(@RequestBody Task task) {
        taskService.addNewTask(task);
    }

    @DeleteMapping(path = "{taskId}")
    public void deleteTask(@PathVariable("taskId") Long taskId) {
        taskService.deleteTask(taskId);
    }

    @PutMapping(path = "{taskId}")
    public void updateTask(
            @PathVariable("taskId") Long taskId,
            @RequestParam(required = false) String title) {
        taskService.updateTask(taskId, title);
    }
}
