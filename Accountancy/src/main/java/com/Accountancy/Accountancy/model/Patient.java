package com.Accountancy.Accountancy.model;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Component
public class Patient {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> symptoms;
    private String illnees;
    private String treatment;
    private String bill;
    private LocalDate date;

    public Patient() {
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

    public List<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }

    public String getIllnees() {
        return illnees;
    }

    public void setIllnees(String illnees) {
        this.illnees = illnees;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getBill() {
        return bill;
    }

    public void setBill(String bill) {
        this.bill = bill;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", symptoms=" + symptoms +
                ", illnees='" + illnees + '\'' +
                ", treatment='" + treatment + '\'' +
                ", bill='" + bill + '\'' +
                ", date=" + date +
                '}';
    }
}
