package com.job_portal.dtos;

import com.job_portal.entities.User;
import com.job_portal.enums.AccountType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    Long id;

    @NotBlank(message = "{user.name.absent}")
    String name;

    @NotBlank(message = "{user.email.absent}")
    @Email(message = "{user.email.invalid}")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    String email;

    @NotBlank(message = "{user.password.absent}")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$",
            message = "{user.password.invalid}")
    String password;

    AccountType accountType;
    Long profileId;

    public User toEntity() {
        return new User(id, name, email, password, accountType, profileId);
    }
}
