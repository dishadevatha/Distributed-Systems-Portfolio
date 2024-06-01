package com.portfolio3.api.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class PartnerUni {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String partnerName;
    private String country;
    private String department;
    private String url;
    private String contactPerson;
    private int outgoingStudents;
    private int incomingStudents;
    private LocalDate springSem;
    private LocalDate autumnSem;
    @OneToMany(mappedBy = "partneruni", cascade = CascadeType.ALL)
    private List<Module> modules;

    public PartnerUni(Long id, String partnerName, String country, String department, String url, String contactPerson, int outgoingStudents, int incomingStudents, LocalDate springSem, LocalDate autumnSem, List<Module> modules) {
        this.id = id;
        this.partnerName = partnerName;
        this.country = country;
        this.department = department;
        this.url = url;
        this.contactPerson = contactPerson;
        this.outgoingStudents = outgoingStudents;
        this.incomingStudents = incomingStudents;
        this.springSem = springSem;
        this.autumnSem = autumnSem;
        this.modules = modules;
    }

    public PartnerUni() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public int getOutgoingStudents() {
        return outgoingStudents;
    }

    public void setOutgoingStudents(int outgoingStudents) {
        this.outgoingStudents = outgoingStudents;
    }

    public int getIncomingStudents() {
        return incomingStudents;
    }

    public void setIncomingStudents(int incomingStudents) {
        this.incomingStudents = incomingStudents;
    }

    public LocalDate getSpringSem() {
        return springSem;
    }

    public void setSpringSem(LocalDate springSem) {
        this.springSem = springSem;
    }

    public LocalDate getAutumnSem() {
        return autumnSem;
    }

    public void setAutumnSem(LocalDate autumnSem) {
        this.autumnSem = autumnSem;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
}
