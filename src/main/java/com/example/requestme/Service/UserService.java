package com.example.requestme.Service;

import com.example.requestme.models.User;
import com.example.requestme.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseGet(User::new);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
