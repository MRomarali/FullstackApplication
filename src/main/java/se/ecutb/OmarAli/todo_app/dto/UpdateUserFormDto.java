package se.ecutb.OmarAli.todo_app.dto;

import se.ecutb.OmarAli.todo_app.constants.messages.ValidationMessages;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class UpdateUserFormDto {

   @Positive
    private int userId;

    @NotBlank(message = ValidationMessages.FIELD_REQUIRED_MESSAGE)
    @Size(min = 2, max = 255, message = ValidationMessages.NAME_MESSAGE)
    private String firstName;

    @NotBlank(message = ValidationMessages.FIELD_REQUIRED_MESSAGE)
    @Size(min = 2, max = 255, message = ValidationMessages.NAME_MESSAGE)
    private String lastName;

    boolean admin;

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
