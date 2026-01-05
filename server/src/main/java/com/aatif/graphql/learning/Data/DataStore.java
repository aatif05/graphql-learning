package com.aatif.graphql.learning.Data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aatif.graphql.learning.DTO.Address;
import com.aatif.graphql.learning.DTO.Post;
import com.aatif.graphql.learning.DTO.User;

public class DataStore {
    public static Map<String, User> users = new HashMap<>();

    // Store Addresses, keyed by userId
    public static Map<String, Address> addresses = new HashMap<>();
    public static Map<String, List<Post>> postsByUserId = new HashMap<>();


    static {
        // Adding users
        users.put("aatif", new User("1", "aatif", 25));
        users.put("Sam", new User("2", "Sam", 30));

        // Adding addresses
        addresses.put("1", new Address("Fort", "Mumbai", "400001"));
        addresses.put("2", new Address("9 MG Road", "Bangalore", "560001"));

        // Posts
        postsByUserId.put("1", Arrays.asList(
            new Post("101", "Post A1", "Content A1"),
            new Post("102", "Post A2", "Content A2")
        ));
        postsByUserId.put("2", Arrays.asList(
            new Post("201", "Post S1", "Content S1")
        ));
    }

}
