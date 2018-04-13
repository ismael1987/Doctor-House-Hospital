package com.Diagnose.Room.Diagnose.Room.model;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Patient {
   private String id;
   private String name;
   private String illnes;
   private List<String> symptoms;

    public Patient() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIllnes() {
        return illnes;
    }

    public void setIllnes(String illnes) {
        this.illnes = illnes;
    }

    public List<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", illnes='" + illnes + '\'' +
                ", symptoms=" + symptoms +
                '}';
    }
}
