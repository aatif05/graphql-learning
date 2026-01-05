package com.aatif.graphql.learning.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.stereotype.Controller;

import com.aatif.graphql.learning.DTO.Post;
import com.aatif.graphql.learning.DTO.User;
import com.aatif.graphql.learning.Data.DataStore;

@Controller
public class PostController {

    /**
     * batch mapping solves N + 1 select Problem.
     * Schema mapping calls the method once for each parent object (User in this case).
     * Batch mapping calls the method once for a list of parent objects.
     * Can be used to fetch records for List from DB in a single query using IN clause
     */
    @BatchMapping
    public Map<User, List<Post>> posts(List<User> users) {
        System.out.println("List of user" + users.size());
        Map<User, List<Post>> result = new HashMap<>();

        for (User user : users) {
            result.put(user, DataStore.postsByUserId.getOrDefault(user.getId(), Collections.emptyList()));
        }

        return result;
    }
}
