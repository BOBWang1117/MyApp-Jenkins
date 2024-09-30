package com.example.userscrud.repository;

import com.example.userscrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM user WHERE email = ?1", nativeQuery = true)
    User findByEmailAddress(String emailAddress);

    @Modifying
    @Query(value = "DELETE FROM user WHERE email = :email", nativeQuery = true)
    User deleteByEmail(String email);

    @Modifying
    @Query(value = "DELETE FROM USER WHERE NAME=:name", nativeQuery = true)
    void deleteByName(String name);

    @Query(value = "SELECT * FROM USER WHERE name=?1", nativeQuery = true)
    List<User> findByName(String name);
}
