package se.ecutb.OmarAli.todo_app.dto;

import se.ecutb.OmarAli.todo_app.constants.messages.ValidationMessages;
import se.ecutb.OmarAli.todo_app.entity.AppUser;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class TodoFormDto {

    @NotBlank(message = ValidationMessages.FIELD_REQUIRED_MESSAGE)
    @Size(min = 2, max = 255, message = ValidationMessages.TODO_TITLE_MESSAGE)
    private String title;

    @NotBlank(message = ValidationMessages.FIELD_REQUIRED_MESSAGE)
    @Size(min = 5, max = 255, message = ValidationMessages.TODO_DESCRIPTION_MESSAGE)
    private String description;

    @Future
    private LocalDate deadline;

    private double reward;

    private AppUser assignee;

    boolean isDone;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }

    public AppUser getAssignee() {
        return assignee;
    }

    public void setAssignee(AppUser assignee) {
        this.assignee = assignee;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
