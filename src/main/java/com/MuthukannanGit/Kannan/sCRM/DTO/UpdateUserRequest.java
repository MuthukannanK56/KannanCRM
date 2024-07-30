package com.MuthukannanGit.Kannan.sCRM.DTO;

import java.util.Date;

public class UpdateUserRequest {

    private String username;
    private String password;
    private String email;
    private String role;
    private Date LastModifiedAt;

    public UpdateUserRequest(String username, String password, String email, String role, Date lastModifiedAt) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        LastModifiedAt = lastModifiedAt;
    }

    public UpdateUserRequest() {
    }



    // Getters and setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getLastModifiedAt() {
        return LastModifiedAt;
    }

    public void setLastModifiedAt(Date lastModifiedAt) {
        LastModifiedAt = lastModifiedAt;
    }
}
