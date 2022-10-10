package com.example.requestme.Service;

import com.example.requestme.models.User;
import com.example.requestme.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        User new_user = new User();
        new_user.setName(user.getName());
        new_user.setEmail(user.getEmail());
        new_user.setPassword(user.getPassword());
        new_user.setPixKey(user.getPixKey());

        userRepository.save(new_user);
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

    public User updateUser(Long id, User user) {
        Optional<User> actual_user = userRepository.findById(id);

        if (actual_user.isPresent()) {
            User updated_user = actual_user.get();
            updated_user.setName(user.getName());
            updated_user.setEmail(user.getEmail());
            updated_user.setPassword(user.getPassword());
            return userRepository.save(updated_user);
        }
        else {
            return null;
        }
    }
}
