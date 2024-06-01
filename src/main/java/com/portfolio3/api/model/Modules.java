package com.portfolio3.api.model;

import jakarta.persistence.*;

@Entity
public class Modules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int sem;
    private int credits;

    @ManyToOne
    @JoinColumn(name = "partner_id")
    private Partner partner;

    public Modules(Long id, String name, int sem, int credits, Partner partner) {
        this.id = id;
        this.name = name;
        this.sem = sem;
        this.credits = credits;
        this.partner = partner;
    }

    public Modules() {
    }

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

    public void setSem(int sem) {
        this.sem = sem;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Partner getPartnerUni() {
        return partner;
    }

    public void setPartnerUni(Partner partner) {
        this.partner = partner;
    }
}
