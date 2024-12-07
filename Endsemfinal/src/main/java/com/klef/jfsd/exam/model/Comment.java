package com.klef.jfsd.exam.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "comments") // Optional: Specifies the table name if database usage is needed later
public class Comment {
    private int postId;

    @Id
    private int id;

    private String name;
    private String email;
    private String body;
}
