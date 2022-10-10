package com.example.requestme.Controller;

import com.example.requestme.Service.UserService;
import com.example.requestme.dtos.UserDTO;
import com.example.requestme.models.User;
import com.example.requestme.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("users")
public class UserController {

    @Autowired
    private ModelMapper modelMapper;
    private UserService userService;

    @GetMapping("listAll")
    public List<UserDTO> listAll() {
        return userService.getAllUser().stream().map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("findById/{id}")
    public UserDTO findById(@PathVariable(name = "id") Long id) {
        User user = userService.getUserById(id);
        UserDTO userResponse = modelMapper.map(user, UserDTO.class);

        return ResponseEntity.ok().body(userResponse).getBody();
    }


    @PutMapping("updateUser/{id}")
    public ResponseEntity<UserDTO> UserDTOUpdate(@PathVariable(name = "id") Long id) {
        User user = userService.getUserById(id);
        UserDTO userResponse = modelMapper.map(user, UserDTO.class);

        return ResponseEntity.ok().body(userResponse);
    }



    @PostMapping("createUser")
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        User userRequest = modelMapper.map(userDTO, User.class);
        userService.createUser(userRequest);
        return modelMapper.map(userRequest, UserDTO.class);
    }

    @DeleteMapping("deleteUser/{id}")
    ResponseEntity<UserDTO>  deleteUser(@PathVariable(name = "id") Long id){
        return ResponseEntity.noContent().build();
    }


}
