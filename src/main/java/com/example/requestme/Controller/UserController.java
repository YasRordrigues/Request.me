package com.example.requestme.Controller;

import com.example.requestme.Services.UserService;
import com.example.requestme.dtos.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("listAll")
    public ResponseEntity<List<UserDTO>> listAll() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    @GetMapping("findById/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable(name = "id") Long id) {

        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }


    @PutMapping("updateUser/{id}")
    public ResponseEntity<UserDTO> UserDTOUpdate(@PathVariable(name = "id") Long id, @RequestBody UserDTO userDto) {
        return new ResponseEntity<>(userService.updateUser(id, userDto), HttpStatus.OK);
    }


    @PostMapping("createUser")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("deleteUser/{id}")
   public void deleteUser(@PathVariable(name = "id") Long id){
          userService.deleteUser(id);
    }


}
