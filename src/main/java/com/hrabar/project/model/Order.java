package com.hrabar.project.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table(name = "db_order")
@Entity

public class Order {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private LocalDateTime timeStamp;

    @PrePersist
    protected void onCreate(){
        timeStamp = LocalDateTime.now();
    }

    @Column
    private String payment_method; //maybe enum

    @ManyToOne
    @JoinColumn(name = "placed_by_user_id")
    private User placedBy;

    @ManyToOne
    @JoinColumn(name = "sent_by_user_id")
    private User sentBy;

}
