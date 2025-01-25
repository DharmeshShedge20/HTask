package net.engineeringdigest.journalApp.Controllers;
import net.engineeringdigest.journalApp.Service.PatientService;
import net.engineeringdigest.journalApp.entity.Doctor;
import net.engineeringdigest.journalApp.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/signup")
    public ResponseEntity<Patient> signUp(@RequestBody Patient patient) {
        Patient savedPatient = patientService.signUp(patient);
        return ResponseEntity.ok(savedPatient);
    }

    @PostMapping("/signin")
    public ResponseEntity<Patient> signIn(@RequestParam String email, @RequestParam String phoneNumber) {
        Patient patient = patientService.signIn(email, phoneNumber);
        return ResponseEntity.ok(patient);
    }

    @GetMapping("/doctors")
    public ResponseEntity<List<String>> getDoctorNames() {
        List<String> doctorNames = patientService.getAllDoctorNames();
        return ResponseEntity.ok(doctorNames);
    }
}
