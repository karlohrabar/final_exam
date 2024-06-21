package com.hrabar.project.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Table(name = "db_comment")
@Entity
public class Comment {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Lob
    @Column
    private String content; //maybe some other type


    @ManyToOne
    @JoinColumn(name = "commented_by_user_id")
    private User commentedBy;

    @ManyToOne
    @JoinColumn(name = "commented_on_user_id")
    private User commentedOn;
}
