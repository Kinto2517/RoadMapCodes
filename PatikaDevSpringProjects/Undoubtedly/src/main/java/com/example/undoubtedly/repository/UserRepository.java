package com.example.undoubtedly.repository;

import com.example.undoubtedly.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    @Query("update User u set u.failed_attempt = ?1 where u.email = ?2")
    @Modifying
    public void updateFailedAttempt(int failed_attempt, String email);

    @Query("SELECT r FROM User r WHERE lower(r.firstName) like lower(concat('%',:search,'%')) "
            + "or lower(r.lastName) like lower(concat('%',:search,'%')) " +
            "or lower(r.experience) like lower(concat('%',:search,'%')) ")
    List<User> findByNameContainingOrSurnameContainingOrUsernameContaining(@Param("search") String search);

}
