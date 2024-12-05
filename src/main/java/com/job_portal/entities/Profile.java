package com.job_portal.entities;

import com.job_portal.dtos.Certification;
import com.job_portal.dtos.Experience;
import com.job_portal.dtos.ProfileDTO;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Base64;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "profile")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Profile {
    @Id
    Long id;
    String email;
    String jobTitle;
    String company;
    String location;
    String about;
    byte[] picture;
    Long totalExperience;
    List<String> skills;
    List<Experience> experience;
    List<Certification> certification;

    public ProfileDTO toDTO() {
        return new ProfileDTO(id, email, jobTitle, company, location, about,
                picture!=null? Base64.getEncoder().encodeToString(picture) : null,
                totalExperience, skills, experience, certification);
    }
}
