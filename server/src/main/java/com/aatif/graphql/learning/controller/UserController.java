package com.aatif.graphql.learning.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.aatif.graphql.learning.DTO.Address;
import com.aatif.graphql.learning.DTO.User;
import com.aatif.graphql.learning.Data.DataStore;

@Controller
public class UserController {


    @QueryMapping
    public User getUser(@Argument String name) {
        return DataStore.users.get(name);
    }

    @QueryMapping
    public List<User> getUsers() {
        return new ArrayList<>(DataStore.users.values());
    }

    @SchemaMapping //called 1 time for each User
    public Address address(User user) {
        System.out.printf("Fetching address for user: %s%n", user.getName());
        return DataStore.addresses.get(user.getId());
    }


}
