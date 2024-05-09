package com.example.demoworkshop.controller;

import com.example.demoworkshop.config.service.UserService;
import com.example.demoworkshop.service.user.IUserService;
import com.example.demoworkshop.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/user")
public class ApiUserController {
    @Autowired
    private IUserService userService;
    @GetMapping()
    public ResponseEntity<Iterable<User>> getListUser(){
        Iterable<User> userList = userService.findAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<User> addUser(@RequestBody User user){
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user){
        if (userService.findById(id).isPresent()){
            user.setId(id);
            userService.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable long id){
        if (userService.findById(id).isPresent()) {
            userService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/search")
    public ResponseEntity<Iterable<User>> searchUser(@RequestParam String key){
        Iterable<User> found = userService.findAllByNameContaining(key);
        return new ResponseEntity<>(found, HttpStatus.FOUND);
    }
    @GetMapping("/driversearch")
    public ResponseEntity<Iterable<User>> searchDriver(@RequestParam String key){
        return null;
    }
}
