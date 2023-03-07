package com.socialmedia.rest.webservices.socialmediarestfulwebservice;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import org.aspectj.bridge.Message;

import java.time.LocalDate;
public class User {
    private int id;
    @Size(min=1, message = "Name should have a minimum of at least one character!")
    private String name;
    @Past(message = "Birthdate should be in the past!")
    private LocalDate birthdate;

    public User(int id, String name, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
