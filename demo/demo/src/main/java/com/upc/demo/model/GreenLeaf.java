package com.upc.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="green_leafs")
public class GreenLeaf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "tip", nullable = false)
    private String tip;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "big_tree_id", nullable = false)
    private BigTree bigTree;
}
