package com.project3.backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private String dep;
    private String url;
    private String contact;
    private int outgoingStudents;
    private int incomingStudents;
    private LocalDate springSem;
    private LocalDate autumnSem;
    @OneToMany(mappedBy = "partner", cascade = CascadeType.ALL)
    private List<Mod> mods;

    // Constructors-
    public Partner(Long id, String name, String country, String dep, String url, String contact, int outgoingStudents, int incomingStudents, LocalDate springSem, LocalDate autumnSem, List<Mod> mods) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.dep = dep;
        this.url = url;
        this.contact = contact;
        this.outgoingStudents = outgoingStudents;
        this.incomingStudents = incomingStudents;
        this.springSem = springSem;
        this.autumnSem = autumnSem;
        this.mods = mods;
    }

    public Partner() {
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String department) {
        this.dep = department;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contactPerson) {
        this.contact = contactPerson;
    }

    public int getOutgoingStudents() {
        return outgoingStudents;
    }

    public void setOutgoingStudents(int studentsSent) {
        this.outgoingStudents = studentsSent;
    }

    public int getIncomingStudents() {
        return incomingStudents;
    }

    public void setIncomingStudents(int studentsAccepted) {
        this.incomingStudents = studentsAccepted;
    }

    public LocalDate getSpringSem() {
        return springSem;
    }

    public void setSpringSem(LocalDate springSemesterStart) {
        this.springSem = springSemesterStart;
    }

    public LocalDate getAutumnSem() {
        return autumnSem;
    }

    public void setAutumnSem(LocalDate autumnSemesterStart) {
        this.autumnSem = autumnSemesterStart;
    }

    public List<Mod> getModules() {
        return mods;
    }

    public void setModules(List<Mod> mods) {
        this.mods = mods;
    }
}
