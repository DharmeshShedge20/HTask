package net.engineeringdigest.journalApp.Service;
import net.engineeringdigest.journalApp.Repository.DoctorRepository;
import net.engineeringdigest.journalApp.Repository.PatientRepository;
import net.engineeringdigest.journalApp.entity.Doctor;
import net.engineeringdigest.journalApp.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;


    public Patient signUp(Patient patient) {
        Optional<Patient> existingPatient = patientRepository.findByEmail(patient.getEmail());
        if (existingPatient.isPresent()) {
            throw new RuntimeException("Email already in use.");
        }

        Optional<Patient> existingPatientByPhone = patientRepository.findByPhoneNumber(patient.getPhoneNumber());
        if (existingPatientByPhone.isPresent()) {
            throw new RuntimeException("Phone number already in use.");
        }

        return patientRepository.save(patient);
    }

    public Patient signIn(String email, String phoneNumber) {
        Optional<Patient> patientOpt = patientRepository.findByEmail(email);

        if (patientOpt.isPresent()) {
            return patientOpt.get();
        } else {
            Optional<Patient> patientByPhoneOpt = patientRepository.findByPhoneNumber(phoneNumber);
            if (patientByPhoneOpt.isPresent()) {
                return patientByPhoneOpt.get();
            } else {
                throw new RuntimeException("Patient not found.");
            }
        }
    }
    @Autowired
    private DoctorRepository doctorRepository;

    public List<String> getAllDoctorNames() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream()
                .map(Doctor::getName)
                .collect(Collectors.toList());
    }
}
