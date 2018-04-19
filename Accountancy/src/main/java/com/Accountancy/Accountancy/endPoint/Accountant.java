package com.Accountancy.Accountancy.endPoint;


import com.Accountancy.Accountancy.model.Patient;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Component
public class Accountant {
 private Patient Patient;

    public Accountant(Patient Patient) {
        this.Patient = Patient;
    }
    HashMap<String,String> prise = new HashMap<>(3);
    public Patient account(Patient patient) {
        String treatment = patient.getTreatment();
        String bill = getBillFromHash(treatment);
        patient.setBill(bill);
        patient.setDate(LocalDate.now());
        return patient;
    }

    public String getBillFromHash(String treatment) {
        String treatment1= "Vitamin C";
        String treatment2=  "Cetirizine";
        String treatment3=  "Chloroquine" ;
        prise.put(treatment1, "20$");
        prise.put(treatment2, "15$");
        prise.put(treatment3, "10$");
        String invoice = "";
        for (Map.Entry<String, String> entry : prise.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            if (prise.containsKey(key) && key.equals(treatment))
            {
                invoice = value;
                return invoice;
            }
            else
            {
                invoice = "0$";
            }

            System.out.println("Key = " + key);
            System.out.println("Values = " + value);
            System.out.println(invoice);
        }
        return invoice;
    }
}
