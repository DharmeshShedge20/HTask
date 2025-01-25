package net.engineeringdigest.journalApp.Controllers;

import net.engineeringdigest.journalApp.Repository.ConsultationFormRepository;
import net.engineeringdigest.journalApp.entity.ConsultationForm;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consultation")
public class ConsultationFormController {

    @Autowired
    private ConsultationFormRepository consultationFormRepository;

    @PostMapping
    public ResponseEntity<ConsultationForm> createConsultationForm(@RequestBody ConsultationForm consultationForm) {
        ConsultationForm savedForm = consultationFormRepository.save(consultationForm);
        return new ResponseEntity<>(savedForm, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultationForm> getConsultationForm(@PathVariable("id") String id) {
        Optional<ConsultationForm> consultationForm = consultationFormRepository.findById(new ObjectId(id));
        if (consultationForm.isPresent()) {
            return new ResponseEntity<>(consultationForm.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<ConsultationForm>> getAllConsultationForms() {
        List<ConsultationForm> allForms = consultationFormRepository.findAll();
        return new ResponseEntity<>(allForms, HttpStatus.OK);
    }
}
