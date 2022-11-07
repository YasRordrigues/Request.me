package com.example.requestme.Services;

import com.example.requestme.dtos.UserDTO;
import com.example.requestme.models.User;
import com.example.requestme.repository.UserRepository;
import com.example.requestme.utils.ConvertUserDtoUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    UserRepository userRepository;

   PasswordEncoder passwordEncoder;

    public UserDTO createUser(UserDTO user) {

        UserDTO userDTO = UserDTO.builder()
                .email(user.getEmail())
                .name(user.getName())
                .password(passwordEncoder.encode(user.getPassword()))
                .pixKey(user.getPixKey())
                .build();

        User new_user = ConvertUserDtoUtil.convertToEntity(userDTO);
        userRepository.save(new_user);
        return userDTO;
    }

    public List<UserDTO> getAllUser() {

        List<User> listUser = userRepository.findAll();

        return listUser.stream().map(ConvertUserDtoUtil::convertToDto).collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        return userRepository.findById(id).isPresent()
                ? ConvertUserDtoUtil.convertToDto(userRepository.findById(id).get())
                : null;
    }


    public UserDTO updateUser(Long id, UserDTO user) {
        Optional<User> actual_user = userRepository.findById(id);
        if(actual_user.isPresent()) {
            UserDTO userDTO  = UserDTO.builder()
                    .id(id)
                    .name(user.getName())
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .pixKey(user.getPixKey()).build();
            userRepository.save(ConvertUserDtoUtil.convertToEntity(userDTO));
            return userDTO;
        }
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public boolean userExists(String username) {
        return userRepository.existsByUsername(username);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        MessageFormat.format("username {0} not found", username)
                ));
    }
}
