package net.engineeringdigest.journalApp.Service;

import net.engineeringdigest.journalApp.Repository.ConsultationFormRepository;
import net.engineeringdigest.journalApp.entity.ConsultationForm;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultationFormService {

    @Autowired
    private ConsultationFormRepository consultationFormRepository;

    public ConsultationForm createConsultationForm(ConsultationForm consultationForm) {
        return consultationFormRepository.save(consultationForm);
    }

    public Optional<ConsultationForm> getConsultationFormById(String id) {
        return consultationFormRepository.findById(new ObjectId(id));
    }

    public List<ConsultationForm> getAllConsultationForms() {
        return consultationFormRepository.findAll();
    }
}
