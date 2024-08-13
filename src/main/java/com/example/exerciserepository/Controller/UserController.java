package com.example.exerciserepository.Controller;


import com.example.exerciserepository.Model.User;
import com.example.exerciserepository.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/get-users")
    public ResponseEntity getUsers() {

        return ResponseEntity.status(200).body(userService.getUsers());
    }


    @PostMapping("/add-user")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("User added successfully");
    }

    @PutMapping("/update-user/{userid}")
    public ResponseEntity updateUser(@PathVariable Integer userid,@Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        userService.updateUser(userid,user);
        return ResponseEntity.status(200).body("User updated successfully");
    }


    @DeleteMapping("/delete-user/{userid}")
    public ResponseEntity deleteUser(@PathVariable Integer userid) {

        userService.deleteUser(userid);
        return ResponseEntity.status(200).body("User deleted successfully");
    }

    @GetMapping("/check-username-password/{username}/{password}")
    public ResponseEntity checkUsernamePassword(@PathVariable String username, @PathVariable String password) {
        userService.checkUsernameAndPassword(username,password);
        return ResponseEntity.status(200).body("check completed successfully, user found and match username and password.");
    }

    @GetMapping("/get-user-by-email")
    public ResponseEntity getUserByEmail(@RequestBody String email) {

        return ResponseEntity.status(200).body(userService.getUserByEmail(email));
    }

    @GetMapping("/get-users-by-role")
    public ResponseEntity getUsersByRole(@RequestBody String role) {
        return ResponseEntity.status(200).body(userService.getUserByRole(role));
    }

    @GetMapping("/get-users-by-age-above")
    public ResponseEntity getUsersByAgeAbove(@RequestBody int age) {
        return ResponseEntity.status(200).body(userService.getUserByAgeORabove(age));
    }
}
