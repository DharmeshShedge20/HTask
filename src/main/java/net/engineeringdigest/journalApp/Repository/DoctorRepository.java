package net.engineeringdigest.journalApp.Repository;

import net.engineeringdigest.journalApp.entity.Doctor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends MongoRepository<Doctor, ObjectId> {

    Optional<Doctor> findByEmail(String email);

    Optional<Doctor> findByPhoneNumber(String phoneNumber);

    Optional<Doctor> findByEmailAndPhoneNumber(String email, String phoneNumber);

    Optional<Doctor> findByName(String name);

    List<Doctor> findAll();
}
