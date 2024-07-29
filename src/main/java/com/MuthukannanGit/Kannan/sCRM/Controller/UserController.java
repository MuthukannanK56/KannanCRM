package com.MuthukannanGit.Kannan.sCRM.Controller;

import com.MuthukannanGit.Kannan.sCRM.DTO.*;
import com.MuthukannanGit.Kannan.sCRM.Model.User;
import com.MuthukannanGit.Kannan.sCRM.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

        return userService.getUserByRole(role);
    }

//    @GetMapping("getcredentials")
//        public Optional<GetCredentialDTO> getCredentials(@RequestParam long id){
//        return userService.getUserById(id);
//    }


    @PostMapping("create")
    public ResponseEntity<UserDTO> createUser(@RequestBody CreateUserRequest request) {
        UserDTO userDTO = userService.createUser(request);
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UpdateUserRequest request) {
        UserDTO userDTO = userService.updateUser(id, request);
        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO userDTO = userService.getUserById(id);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> listUsers() {
        List<UserDTO> users = userService.listUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<UserDTO> authenticateUser(@RequestBody AuthenticateUserRequest request) {
        UserDTO userDTO = userService.authenticateUser(request);
        return ResponseEntity.ok(userDTO);
    }

}
