package com.thehalfbloodprince.taskmanagerscaler.entities;

import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.Date;

@Data
public class TaskEntity {
    private int id;
    private String title;
    private String description;
    private LocalDate deadline;
    private boolean completed;
}
