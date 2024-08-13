package com.example.exerciserepository.Service;

import com.example.exerciserepository.Api.ApiException;
import com.example.exerciserepository.Model.User;
import com.example.exerciserepository.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Integer userID) {
        User u = userRepository.findUserById(userID);
        if (u==null) {
            throw new ApiException("user not found");
        }
        userRepository.delete(u);
    }

    public void updateUser(Integer userID,User user) {
        User u = userRepository.findUserById(userID);
        if (u == null) {
            throw new ApiException("user not found");
        }
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        u.setAge(user.getAge());
        u.setRole(user.getRole());
        userRepository.save(u);
    }

    public void checkUsernameAndPassword(String username, String password) {
        User u = userRepository.checkUserNameAndPassword(username,password);
        if (u==null) {
            throw new ApiException("username or password wrong");
        }
    }

    public User getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user==null) {
            throw new ApiException("user not found");
        }
        return user;
    }

    public List<User> getUserByRole(String role) {
        List<User> u = userRepository.getUserByRole(role);
        if (u.isEmpty()) {
            throw new ApiException("user not found");
        }
        return u;
    }

    public List<User> getUserByAgeORabove(int age) {
        List<User> u = userRepository.getUsersByThisAgeOrAbove(age);
        if (u.isEmpty()) {
            throw new ApiException("user not found");
        }
        return u;
    }
}
