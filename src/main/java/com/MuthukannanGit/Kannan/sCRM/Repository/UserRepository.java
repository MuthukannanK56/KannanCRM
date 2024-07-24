package com.MuthukannanGit.Kannan.sCRM.Repository;

import com.MuthukannanGit.Kannan.sCRM.DTO.GetCredentialDTO;
import com.MuthukannanGit.Kannan.sCRM.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "Select * from users where role = role", nativeQuery = true)
    List<User> findByRole(@Param("role") String role);


    @Query("SELECT new com.MuthukannanGit.Kannan.sCRM.DTO.GetCredentialDTO(u.id, u.username, u.password) FROM User u WHERE u.id = :id")
    public GetCredentialDTO findUsersById(@Param("id") long role);



}