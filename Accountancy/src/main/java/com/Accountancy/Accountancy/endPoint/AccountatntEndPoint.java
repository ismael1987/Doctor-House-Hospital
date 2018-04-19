package com.Accountancy.Accountancy.endPoint;

import com.Accountancy.Accountancy.model.AccountanctRepository;
import com.Accountancy.Accountancy.model.Patient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountatntEndPoint {

    private Accountant accountant;
    private AccountanctRepository accountanctRepository;
    private Patient patient;

    public AccountatntEndPoint(Accountant accountant, AccountanctRepository accountanctRepository, Patient patient) {
        this.accountant = accountant;
        this.accountanctRepository = accountanctRepository;
        this.patient = patient;
    }

    @GetMapping("/bill")
    List<Patient> getbills(){
        return accountanctRepository.findAll();
    }

    @PostMapping("/bill")
    void setPatient(@RequestBody Patient patient){
        Patient invoice = accountant.account(patient);
        accountanctRepository.save(invoice);
    }

}
