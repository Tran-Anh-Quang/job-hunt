package com.job_portal.apis;

import com.job_portal.dtos.ProfileDTO;
import com.job_portal.services.ProfileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1/profile")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProfileAPI {
    ProfileService profileService;

    @GetMapping("/{profileId}")
    public ResponseEntity<ProfileDTO> getProfile(@PathVariable Long profileId) throws Exception {
        return new ResponseEntity<>(profileService.getProfile(profileId), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ProfileDTO> updateProfile(@RequestBody ProfileDTO profileDTO) throws Exception {
        return new ResponseEntity<>(profileService.updateProfile(profileDTO), HttpStatus.OK);
    }
}
