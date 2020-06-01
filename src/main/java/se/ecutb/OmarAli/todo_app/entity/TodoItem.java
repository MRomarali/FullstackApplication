package se.ecutb.OmarAli.todo_app.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int todoItemId;
    private String title;
    private String description;
    private LocalDate deadline;
    private boolean isDone;
    private double reward;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REMOVE})
    @JoinColumn(name = "user_id")
    private AppUser assignee;


    public TodoItem(String title, String description, LocalDate deadline, boolean isDone, double reward, AppUser assignee) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.isDone = isDone;
        this.reward = reward;
        this.assignee = assignee;
    }

    public TodoItem(String title, String description, LocalDate deadline, boolean isDone, double reward) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.isDone = isDone;
        this.reward = reward;
    }

    public TodoItem(){}

    public int getTodoItemId() {
        return todoItemId;
    }

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

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem todoItem = (TodoItem) o;
        return todoItemId == todoItem.todoItemId &&
                isDone == todoItem.isDone &&
                Double.compare(todoItem.reward, reward) == 0 &&
                Objects.equals(title, todoItem.title) &&
                Objects.equals(description, todoItem.description) &&
                Objects.equals(deadline, todoItem.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(todoItemId, title, description, deadline, isDone, reward);
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "todoItemId=" + todoItemId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", isDone=" + isDone +
                ", reward=" + reward +
                ", assignee=" + assignee +
                '}';
    }
}
