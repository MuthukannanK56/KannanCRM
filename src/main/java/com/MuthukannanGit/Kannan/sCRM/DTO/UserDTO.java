package com.MuthukannanGit.Kannan.sCRM.DTO;

import jakarta.persistence.PrePersist;

import java.time.LocalDateTime;
import java.util.Date;

public class UserDTO {

    private Long id;
    private String username;

    private String password;
    private String email;
    private String role;
    private Date createdAt;
    private Date LastModifiedAt;


public UserDTO(){}
    public UserDTO(Long id, String username, String password, String email, String role, Date createdAt, Date lastModifiedAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.createdAt = createdAt;
        LastModifiedAt = lastModifiedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastModifiedAt() {
        return LastModifiedAt;
    }

    public void setLastModifiedAt(Date lastModifiedAt) {
        LastModifiedAt = lastModifiedAt;
    }
}

