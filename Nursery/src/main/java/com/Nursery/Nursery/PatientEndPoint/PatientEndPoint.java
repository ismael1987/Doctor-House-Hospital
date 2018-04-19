package com.Nursery.Nursery.PatientEndPoint;

import com.Nursery.Nursery.model.NurseRepository;
import com.Nursery.Nursery.model.Patient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PatientEndPoint {


    private Nurse nurse;
    private Patient patient;

    private RestTemplate restTemplate;
    private NurseRepository nurseRepository;
    public PatientEndPoint(Nurse nurse, Patient patient, RestTemplate restTemplate, NurseRepository nurseRepository, List<Patient> listofpatient) {
        this.nurse = nurse;
        this.patient = patient;
        this.restTemplate = restTemplate;
        this.nurseRepository = nurseRepository;
        this.listofpatient = listofpatient;
    }

    private List<Patient> listofpatient = new ArrayList<>();

    @GetMapping("/patients")
    List<Patient> getall(){
        return nurseRepository.findAll();
    }

    @PostMapping("/patients")
    void addPatient (@RequestBody Patient patient){
        Patient treated = nurse.treatment(patient);
        nurseRepository.save(treated);
        restTemplate.postForEntity("http://localhost:9009/invoices",treated ,Patient.class);
    }

    @PostMapping("/patients/{id}")
    void addPatient2(@PathVariable String id){
        Patient patient= nurseRepository.findAll().stream()
                .filter(p1 -> p1.getId().equals(id))
                .findFirst().get();
        Patient treated = nurse.treatment(patient);
        nurseRepository.save(treated);
        restTemplate.postForEntity("http://localhost:9009/invoices",treated ,Patient.class);
    }

}
