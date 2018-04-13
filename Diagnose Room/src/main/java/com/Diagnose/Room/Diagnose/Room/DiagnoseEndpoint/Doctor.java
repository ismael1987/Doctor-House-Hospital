package com.Diagnose.Room.Diagnose.Room.DiagnoseEndpoint;

import com.Diagnose.Room.Diagnose.Room.model.Patient;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class Doctor {
   private Patient patient;

    public Doctor(Patient patient) {
        this.patient = patient;
    }
    HashMap<List<String>, String> clinic = new HashMap<>(3);

    public Patient check(Patient patient) {
        List<String> symptoms = patient.getSymptoms();
        String illnes = getillnessFromHash(symptoms);
        patient.setIllnes(illnes);
        return patient;
    }

    private String getillnessFromHash(List<String> symptoms) {
        List<String> symptoms1= Arrays.asList("Runny or stuffy nose", "Congestion");
        List<String> symptoms2= Arrays.asList("Tingling or itching in the mouth", "Hives, itching or eczema");
        List<String> symptoms3= Arrays.asList("vomiting", "sweats");
        clinic.put(symptoms1,"cold");
        clinic.put(symptoms2,"stomach allergy");
        clinic.put(symptoms3, "malaria");
        String illnes = "";
        for (Map.Entry<List<String>, String> entry : clinic.entrySet()) {
            List<String> key = entry.getKey();
            String value = entry.getValue();
            if (clinic.containsKey(key) && key.containsAll(symptoms) || symptoms.containsAll(key))
            {
                illnes = value;
                return illnes;
            }
            else
            {
                illnes = "lupus";
            }
            System.out.println("Key = " + key);
            System.out.println("Values = " + value);
            System.out.println(illnes);
        }

        return illnes;

    }
}
