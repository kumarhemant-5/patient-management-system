package com.pm.patientservice.service;

import com.pm.patientservice.dao.PatientRepository;
import com.pm.patientservice.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public ResponseEntity<String> getPatientById(UUID id){
        String str;
        if(patientRepository.findById(id).isEmpty()){
            str = "Patient with this id is not present";
        }else{
            str = "Patient is present";
        }

        // return new ResponseEntity<>(str,HttpStatus.OK);
        // return ResponseEntity.ok(str);
        return ResponseEntity.status(HttpStatus.OK).body(str);
    }
}
