package com.aatif.graphql.learning.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Post {
    private String id;
    private String title;
    private String content;

}
