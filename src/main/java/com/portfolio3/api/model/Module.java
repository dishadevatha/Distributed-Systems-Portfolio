package com.portfolio3.api.model;

import jakarta.persistence.*;

@Entity
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int sem;
    private int credits;

    @ManyToOne
    @JoinColumn(name = "partneruni_id")
    private PartnerUni partnerUni;

    public Module(Long id, String name, int sem, int credits, PartnerUni partnerUni) {
        this.id = id;
        this.name = name;
        this.sem = sem;
        this.credits = credits;
        this.partnerUni = partnerUni;
    }

    public Module() {
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

    public PartnerUni getPartnerUni() {
        return partnerUni;
    }

    public void setPartnerUni(PartnerUni partnerUni) {
        this.partnerUni = partnerUni;
    }
}
