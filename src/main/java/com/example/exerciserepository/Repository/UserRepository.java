package com.example.exerciserepository.Repository;

import com.example.exerciserepository.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    User findUserById(int id);

    @Query("select u from User u where u.username=?1 and u.password=?2")
    User checkUserNameAndPassword(String username, String password);

    List<User> getUserByRole(String role);

    @Query("select u from User u where u.age>=?1")
    List<User> getUsersByThisAgeOrAbove(int age);

}
