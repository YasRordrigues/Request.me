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

    @GetMapping("findById/{id}")
    public User findById(@PathVariable Long id) { return userService.getUserById(id);}

    @PutMapping("updateUser/{id}")
    public User updateUserById(@PathVariable(name = "id") Long id, @RequestBody User user){ return userService.updateUser(id, user);}


    @PostMapping("createUser")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @DeleteMapping("deleteUser/{id}")
    void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }


}
