package com.example.demoworkshop.repository;

import com.example.demoworkshop.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    Iterable<User> findAllByUsernameContaining(String search);
    Iterable<User> findAllByLocation(String search);
}
