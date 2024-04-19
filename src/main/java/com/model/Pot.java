package com.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pots")
public class Pot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String material;

    @Column(nullable = false)
    private String size;

    @ManyToOne
    @JoinColumn(name = "greenhouse_id", nullable = false)
    private Greenhouse greenhouse;


}
