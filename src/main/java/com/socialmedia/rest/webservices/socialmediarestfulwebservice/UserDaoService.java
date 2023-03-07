package com.socialmedia.rest.webservices.socialmediarestfulwebservice;

import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Configuration
public class UserDaoService {
    private static int userCount=0;
    public static List<User> users = new ArrayList<>();
    static {
        users.add(new User(++userCount, "Tim", LocalDate.now().minusYears(28)));
        users.add(new User(++userCount, "Harry", LocalDate.now().minusYears(25)));
        users.add(new User(++userCount, "Joshua", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount, "Sarah", LocalDate.now().minusYears(32)));
        users.add(new User(++userCount, "Layla", LocalDate.now().minusYears(20)));
    }

    public List<User> findAllUsers(){
        return users;
    }

    public User findUser(int id){
        Predicate<? super User> predicate = User -> User.getId()==id;
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User saveUser(User user){
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public void deleteUser(int id){
        Predicate<? super User> predicate = User -> User.getId()==id;
        users.removeIf(predicate);
    }

}
