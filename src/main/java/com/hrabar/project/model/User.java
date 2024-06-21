package com.hrabar.project.model;

import com.hrabar.project.model.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "db_user")
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column
    private String username;

    @Column
    private String country;

    @Column
    private String zip_code;

    @Column
    private String city;

    @Column
    private String email;

    @Column
    private String full_name;

    @Column
    private String password;

    @PrePersist
    protected void onCreate(){
        role = Role.USER;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> itemList;

    @OneToMany(mappedBy = "placedBy")
    private List<Order> ordersPlaced;

    @OneToMany(mappedBy = "sentBy")
    private List<Order> orderSent;

    @OneToMany(mappedBy = "commentedBy")
    private List<Comment> commentsMade;

    @OneToMany(mappedBy = "commentedOn")
    private List<Comment> commentsReceived;

}
