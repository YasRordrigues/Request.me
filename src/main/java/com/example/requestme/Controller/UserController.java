package com.example.requestme.Controller;

import com.example.requestme.Service.UserService;
import com.example.requestme.models.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("users")
public class UserController {

    private UserService userService;

    @GetMapping("listAll")
    public List<User> listAll() {
        return userService.getAllUser();
    }

    @PostMapping("createUser")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
    @DeleteMapping("deleteUser/{id}")
    void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
