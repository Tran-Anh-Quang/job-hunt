package com.job_portal.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "sequence")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Sequence {
    @Id
    String id;

    Long seq;

}
