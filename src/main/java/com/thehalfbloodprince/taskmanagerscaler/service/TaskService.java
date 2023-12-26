package com.thehalfbloodprince.taskmanagerscaler.service;

import com.thehalfbloodprince.taskmanagerscaler.entities.TaskEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

@Service
public class TaskService {

    private ArrayList<TaskEntity> tasks = new ArrayList<>();
    private int nextTaskID = 1;

    // get all tasks
    public ArrayList<TaskEntity> getAllTasks() {
        return tasks;
    }

    // get a particular task
    public TaskEntity getTaskByID(int id) {
        for (TaskEntity task: tasks) {
            if (task.getId() == id) return task;
        }
        return null;
    }

    // MUTATORS
    // add a task
    public TaskEntity addTask(
            String title,
            String description,
            String deadline
    ) {
        TaskEntity newTask = new TaskEntity();
        newTask.setId(nextTaskID++);
        newTask.setTitle(title);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
        newTask.setDeadline(LocalDate.parse(deadline, formatter));
        newTask.setDescription(description);
        newTask.setCompleted(false);

        tasks.add(newTask);
        return newTask;
    }

}
