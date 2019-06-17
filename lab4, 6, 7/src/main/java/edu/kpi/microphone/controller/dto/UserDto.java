package edu.kpi.microphone.controller.dto;


import javax.validation.constraints.*;

public class UserDto {
    @NotNull
    @NotEmpty
    @Size(min = 2, max = 20)
    @Pattern(regexp = "^[a-zA-Z_0-9]+$", message = "must consist of latin letters, numbers or underscores")
    private String username;

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 30)
    private String password;

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 30)
    private String password2;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDto setPassword2(String password2) {
        this.password2 = password2;
        return this;
    }
}
