package com.MuthukannanGit.Kannan.sCRM.Service;

import com.MuthukannanGit.Kannan.sCRM.DTO.GetCredentialDTO;
import com.MuthukannanGit.Kannan.sCRM.Model.User;
import com.MuthukannanGit.Kannan.sCRM.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUserName() {
        return userRepository.findAll();
    }

    public List<User> getUSerByRole(String role){
        return userRepository.findByRole(role);
    }

    public Optional<GetCredentialDTO> getUserById(Long id){
        return Optional.ofNullable(userRepository.findUsersById(id));
    }
}
