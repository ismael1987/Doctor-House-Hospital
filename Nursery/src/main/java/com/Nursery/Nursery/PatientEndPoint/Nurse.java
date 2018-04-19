package com.Nursery.Nursery.PatientEndPoint;

import com.Nursery.Nursery.model.Patient;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Nurse {
    Patient patient;

    public Nurse(Patient patient) {
        this.patient = patient;
    }
    HashMap<String,String> nurse =new HashMap<>(3);

    public Patient treatment(Patient patient) {
        String illnes = patient.getIllness();
        String treatment = gettreatmentfromHash(illnes);
        patient.setTreatment(treatment);
        return patient;
    }

    private String gettreatmentfromHash(String illnes) {

        nurse.put("cold","Vitamin C");
        nurse.put("stomach allergy"," Cetirizine");
        nurse.put("malaria","Chloroquine");
        String treatment ="" ;
        for (Map.Entry<String, String> entry : nurse.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            if (nurse.containsKey(key) && key.equals(illnes))
            {
                treatment = value;
                return treatment;
            }
            else
            {
                treatment = "Water";
            }
            System.out.println("Key = " + key);
            System.out.println("Values = " + value);
            System.out.println(treatment);
        }
        return treatment;
    }

}
