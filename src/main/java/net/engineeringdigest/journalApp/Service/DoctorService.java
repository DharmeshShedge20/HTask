package net.engineeringdigest.journalApp.Service;
import net.engineeringdigest.journalApp.Repository.DoctorRepository;
import net.engineeringdigest.journalApp.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor signUp(Doctor doctor) {
        Optional<Doctor> existingDoctor = doctorRepository.findByEmail(doctor.getEmail());
        if (existingDoctor.isPresent()) {
            throw new RuntimeException("Email already in use.");
        }

        Optional<Doctor> existingDoctorByPhone = doctorRepository.findByPhoneNumber(doctor.getPhoneNumber());
        if (existingDoctorByPhone.isPresent()) {
            throw new RuntimeException("Phone number already in use.");
        }

        return doctorRepository.save(doctor);
    }

    public Doctor signIn(String email, String phoneNumber) {
        Optional<Doctor> doctorOpt = doctorRepository.findByEmailAndPhoneNumber(email, phoneNumber);

        if (doctorOpt.isPresent()) {
            return doctorOpt.get();
        } else {
            throw new RuntimeException("Doctor not found with the provided credentials.");
        }
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> findByName(String name) {
        return doctorRepository.findByName(name);
    }


}

