package se.ecutb.OmarAli.todo_app.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(unique = true)
    private String userName;
    private String firstName;
    private String lastName;
    private LocalDate regDate;
    private String password;
    private double balance;

    @ManyToMany(
            cascade = {CascadeType.MERGE},
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "app_user_app_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "app_user_role_id")
    )
    private Set<AppUserRole> roleSet = new HashSet<>();

    @OneToMany(mappedBy = "assignee", orphanRemoval = false, fetch = FetchType.EAGER,
    cascade = {CascadeType.MERGE, CascadeType.PERSIST}
    )
    private Set<TodoItem> todoItems = new HashSet<>();

    public AppUser(String userName, String firstName, String lastName, LocalDate regDate, String password,
                   double balance, Set<AppUserRole> roleSet, Set<TodoItem> todoItems) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.regDate = regDate;
        this.password = password;
        this.balance = balance;
        this.roleSet = roleSet;
        this.todoItems = todoItems;
    }

    public AppUser(String userName, String firstName, String lastName, LocalDate regDate, String password, double balance, Set<AppUserRole> roleSet) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.regDate = regDate;
        this.password = password;
        this.balance = balance;
        this.roleSet = roleSet;
    }

    public AppUser(String userName, String firstName, String lastName, LocalDate regDate, String password, double balance) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.regDate = regDate;
        this.password = password;
        this.balance = balance;
    }

    public AppUser(){}

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Set<AppUserRole> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<AppUserRole> roleSet) {
        this.roleSet = roleSet;
    }

    public Set<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void setTodoItems(Set<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }

    public boolean makeAdmin(AppUserRole admin){
        if (admin == null) return false;
        return roleSet.add(admin);
    }

    public boolean removeAdmin(AppUserRole admin){
        if (admin == null) return false;
        if (!roleSet.contains(admin)) return false;
        return roleSet.remove(admin);
    }

    public boolean addUsersTodo(TodoItem todoItem){
        if (todoItem == null) return false;
        if(todoItems.contains(todoItem)) return false;
        if(todoItems.add(todoItem)){
            todoItem.setAssignee(this);
            return true;
        }
        return false;
    }

    public boolean removeUsersTodo(TodoItem todoItem){
        if (todoItem == null) return false;
        if (!todoItems.contains(todoItem)) return false;
        if (todoItems.remove(todoItem)){
            todoItem.setAssignee(null);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return userId == appUser.userId &&
                Double.compare(appUser.balance, balance) == 0 &&
                Objects.equals(userName, appUser.userName) &&
                Objects.equals(firstName, appUser.firstName) &&
                Objects.equals(lastName, appUser.lastName) &&
                Objects.equals(regDate, appUser.regDate) &&
                Objects.equals(password, appUser.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, firstName, lastName, regDate, password, balance);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", regDate=" + regDate +
                ", balance=" + balance +
                '}';
    }
}
