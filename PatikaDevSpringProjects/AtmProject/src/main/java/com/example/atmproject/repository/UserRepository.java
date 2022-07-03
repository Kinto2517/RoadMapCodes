package com.example.atmproject.repository;

import com.example.atmproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    @Query("update User u set u.failed_attempt = ?1 where u.email = ?2")
    @Modifying
    public void updateFailedAttempt(int failed_attempt, String email);

}
