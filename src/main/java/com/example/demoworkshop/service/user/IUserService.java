package com.example.demoworkshop.service.user;

import com.example.demoworkshop.model.entity.User;
import com.example.demoworkshop.service.IGeneratedService;
import jakarta.persistence.Id;
import org.springframework.data.repository.query.Param;

public interface IUserService extends IGeneratedService<User> {
    Iterable<User> findAllByNameContaining(String search);
}
