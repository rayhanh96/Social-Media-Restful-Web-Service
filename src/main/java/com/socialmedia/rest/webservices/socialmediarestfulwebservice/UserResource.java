package com.socialmedia.rest.webservices.socialmediarestfulwebservice;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    private UserDaoService service;
    UserResource(UserDaoService service){
        this.service = service;
    }
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return service.findAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id){
        User user = service.findUser(id);

        if(user == null){
            throw new UserNotFoundException("id of " + id + " does not exist!!!");
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = service.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        User user = service.findUser(id);
        if(user == null){
            throw new UserNotFoundException("id of " + id + " does not exist!!!");
        }
        service.deleteUser(id);
    }
}
