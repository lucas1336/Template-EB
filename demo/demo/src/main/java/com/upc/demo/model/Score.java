package com.upc.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="scores")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="driver_id", nullable = false)
    private Long driverId;

    @Column(name="value", nullable = false)
    private Float value;

    @Column(name="registered_at", nullable = false)
    public Date registeredAt;
}
