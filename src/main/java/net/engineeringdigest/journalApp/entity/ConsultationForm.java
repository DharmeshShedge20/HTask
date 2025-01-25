package net.engineeringdigest.journalApp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsultationForm {

    @Id
    private ObjectId id;

    private String currentIllnessHistory;
    private String recentSurgery;
    private String surgeryTimeSpan;

    private boolean isDiabetic;
    private String allergies;
    private String otherFamilyConditions;
}
