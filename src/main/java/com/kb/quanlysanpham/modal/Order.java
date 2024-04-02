package com.kb.quanlysanpham.modal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Entity
@Table(name = "Orders")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date orderDate;

    private double totalPrice;
    private String status;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    // Getters and setters
}
