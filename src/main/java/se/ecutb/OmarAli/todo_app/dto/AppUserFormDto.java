package se.ecutb.OmarAli.todo_app.dto;

import se.ecutb.OmarAli.todo_app.constants.messages.ValidationMessages;
import se.ecutb.OmarAli.todo_app.constants.regex.RegexPatterns;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AppUserFormDto {

    @NotBlank(message = ValidationMessages.FIELD_REQUIRED_MESSAGE)
    @Pattern(regexp = RegexPatterns.USERNAME_PATTERN, message = ValidationMessages.USERNAME_FORMAT_MESSAGE)
    private String userName;

    @NotBlank(message = ValidationMessages.FIELD_REQUIRED_MESSAGE)
    @Size(min = 2, max = 255, message = ValidationMessages.NAME_MESSAGE)
    private String firstName;

    @NotBlank(message = ValidationMessages.FIELD_REQUIRED_MESSAGE)
    @Size(min = 2, max = 255, message = ValidationMessages.NAME_MESSAGE)
    private String lastName;

    @NotBlank(message = ValidationMessages.FIELD_REQUIRED_MESSAGE)
    @Pattern(regexp = RegexPatterns.PASSWORD_PATTERN, message = ValidationMessages.PASSWORD_MESSAGE)
    private String password;

    @NotBlank(message = ValidationMessages.FIELD_REQUIRED_MESSAGE)
    private String passwordConfirm;

    boolean admin;

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
