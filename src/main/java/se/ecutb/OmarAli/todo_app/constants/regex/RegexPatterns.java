package se.ecutb.OmarAli.todo_app.constants.regex;

public class RegexPatterns {

    // password - 4-8 characters, at least 1 digit
    public static final String PASSWORD_PATTERN = "^(?=.*\\d).{4,8}$";
    // username - 3-15 characters, all lowercase, no special characters
    public static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";
    // date - format like 2020-12-31
    public static final String DATE_PATTERN = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
}
