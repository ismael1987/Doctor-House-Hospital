package com.Hospital.Admission.Hospital.Admission.endpoint;



import com.Hospital.Admission.Hospital.Admission.model.Patient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PatientEndpoint {

    private List<Patient> patientslist= new ArrayList<>();


    private RestTemplate restTemplate;

    public PatientEndpoint(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/patients")
    List<Patient> getAll(){
        return patientslist;
    }

    @PostMapping("/addpatients")
    void addPatient(@RequestBody Patient patient ){
        patientslist.add(patient);

    }

    @PostMapping("/sendpatients")
    void post(){
        for (Patient p : patientslist) {
            restTemplate.postForEntity("http://localhost:9007/diagnose" , p , Patient.class);


        }

    }
}
