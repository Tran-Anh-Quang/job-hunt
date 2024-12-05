package com.job_portal.dtos;

import com.job_portal.entities.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Base64;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDTO {
    Long id;
    String email;
    String jobTitle;
    String company;
    String location;
    String about;
    String picture;
    Long totalExperience;
    List<String> skills;
    List<Experience> experience;
    List<Certification> certification;

    public Profile toEntity() {
        return new Profile(id, email, jobTitle, company, location, about,
                picture!=null? Base64.getDecoder().decode(picture) : null,
                totalExperience,skills, experience, certification);
    }
}
