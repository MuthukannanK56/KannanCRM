package com.MuthukannanGit.Kannan.sCRM.DTO;

import lombok.Getter;
import lombok.Setter;

public class GetCredentialDTO {
    private Long id;
    private String username;

    private String password;

    public GetCredentialDTO(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    public GetCredentialDTO() {
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
}
