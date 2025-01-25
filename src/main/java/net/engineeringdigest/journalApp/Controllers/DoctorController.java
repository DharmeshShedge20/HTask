package net.engineeringdigest.journalApp.Controllers;
import net.engineeringdigest.journalApp.Service.DoctorService;
import net.engineeringdigest.journalApp.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/signup")
    public ResponseEntity<Doctor> signUp(@RequestBody Doctor doctor) {
        Doctor savedDoctor = doctorService.signUp(doctor);
        return ResponseEntity.ok(savedDoctor);
    }

    @PostMapping("/signin")
    public ResponseEntity<Doctor> signIn(@RequestBody Doctor signInRequest) {
        try {
            Doctor doctor = doctorService.signIn(signInRequest.getEmail(), signInRequest.getPhoneNumber());
            return ResponseEntity.ok(doctor);  // If found, return doctor
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);  // Return 401 if not found
        }
    }

    @GetMapping("/{name}/profile")
    public ResponseEntity<Doctor> doctorProfile(@PathVariable String name) {
        Optional<Doctor> doctorInfo = doctorService.findByName(name);
        if (doctorInfo.isPresent()) {
            return ResponseEntity.ok(doctorInfo.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
