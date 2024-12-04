package com.job_portal.entities;

import com.job_portal.dtos.UserDTO;
import com.job_portal.enums.AccountType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "users")
public class User {

    @Id
    Long id;

    String name;

    @Indexed(unique = true)
    String email;

    String password;
    AccountType accountType;

    public User(Long id, String name, String email, String password, AccountType accountType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.accountType = accountType;
    }

    public UserDTO toDTO() {
        return new UserDTO(id, name, email, password, accountType);
    }
}
