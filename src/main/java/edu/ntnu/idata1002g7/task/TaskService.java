package edu.ntnu.idata1002g7.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public void addNewTask(Task task) {
        Optional<Task> taskOptional = taskRepository.findTaskById(task.getId());

        if (taskOptional.isPresent()) {
            throw new IllegalStateException("ID taken");
        }

        taskRepository.save(task);
    }

    public void deleteTask(Long taskId) {
        boolean exists = taskRepository.existsById(taskId);

        if (!exists) {
            throw new IllegalStateException("Task with id " + taskId + " does not exist");
        }

        taskRepository.deleteById(taskId);
    }

    @Transactional
    public void updateTask(Long taskId, String title) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalStateException("Task with id " + taskId + " does not exist"));

        if (title != null && title.length() > 0 && !Objects.equals(task.getTitle(), title)) {
            task.setTitle(title);
        }
    }
}
