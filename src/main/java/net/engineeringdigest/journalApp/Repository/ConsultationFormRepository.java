package net.engineeringdigest.journalApp.Repository;

import net.engineeringdigest.journalApp.entity.ConsultationForm;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConsultationFormRepository extends MongoRepository<ConsultationForm, ObjectId> {
}
