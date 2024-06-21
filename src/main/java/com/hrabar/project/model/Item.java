package com.hrabar.project.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "db_item")
public class Item {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String title;

    @Column
    private String artist;

    @Column
    private String genre; //maybe enum

    @Column
    private String format; //maybe enum

    @Column
    private String condition; //maybe enum

    @Column
    private Integer price;

    @Column
    private String country;

    @Column
    private boolean sold;

    @PrePersist
    protected void onCreate(){
        sold = false;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
