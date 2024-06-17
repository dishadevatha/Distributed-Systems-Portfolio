package com.project3.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Mod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int sem;
    private int credits;


    @ManyToOne
    @JoinColumn(name = "partner_id")
    @JsonIgnore
    private Partner partner;


    // Constructors

    public Mod(Long id, String name, int sem, int credits, Partner partner) {
        this.id = id;
        this.name = name;
        this.sem = sem;
        this.credits = credits;
        this.partner = partner;
    }

    public Mod() {
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSem() {
        return sem;
    }

    public void setSem(int semester) {
        this.sem = semester;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int creditPoints) {
        this.credits = creditPoints;
    }

    public Partner getUniversity() {
        return partner;
    }

    public void setUniversity(Partner partner) {
        this.partner = partner;
    }
}
