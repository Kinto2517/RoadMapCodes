package com.example.humanresourcesproject.repository;

import com.example.humanresourcesproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    @Query("update User u set u.failed_attempt = ?1 where u.email = ?2")
    @Modifying
    public void updateFailedAttempt(int failed_attempt, String email);

}
