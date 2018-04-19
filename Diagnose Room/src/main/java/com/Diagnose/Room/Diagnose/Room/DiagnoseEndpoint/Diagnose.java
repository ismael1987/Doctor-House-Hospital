package com.Diagnose.Room.Diagnose.Room.DiagnoseEndpoint;

import com.Diagnose.Room.Diagnose.Room.model.Patient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Diagnose {


   private Doctor doctor;

    public Diagnose(Doctor doctor) {
        this.doctor = doctor;
    }

    private List<Patient> patients = new ArrayList<>();

    @GetMapping("/patients")
    List<Patient> getAll() {
        return patients;
    }

    @PostMapping("/diagnose")
     void setPatient(@RequestBody Patient patient){
       Patient checked = doctor.check(patient);
       patients.add(checked);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity("http://localhost:9008/patients",checked ,Patient.class);

     }



}
