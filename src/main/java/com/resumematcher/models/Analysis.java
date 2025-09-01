package com.resumematcher.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_analysis")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Analysis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double matchPercentage;
    private String jobKeywords;
    private String resumeKeywords;
    private String missingKeywords;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
