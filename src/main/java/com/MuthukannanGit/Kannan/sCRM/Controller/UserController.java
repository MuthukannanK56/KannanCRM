package com.MuthukannanGit.Kannan.sCRM.Controller;

import com.MuthukannanGit.Kannan.sCRM.DTO.GetCredentialDTO;
import com.MuthukannanGit.Kannan.sCRM.Model.User;
import com.MuthukannanGit.Kannan.sCRM.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/crm/user/v1")
public class UserController{
    @Autowired
    private UserService userService;

    @GetMapping("users")
    public List<User> getUser(){
        return userService.getUserName();
    }

    @GetMapping("getbyrole")
    public List<User> getUserByRole(@RequestParam String role){

        return userService.getUSerByRole(role);
    }

    @GetMapping("getcredentials")
        public Optional<GetCredentialDTO> getCredentials(@RequestParam long id){
        return userService.getUserById(id);
    }



}
