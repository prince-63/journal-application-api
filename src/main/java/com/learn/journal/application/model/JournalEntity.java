package com.learn.journal.application.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection="journalData")
@Data
@NoArgsConstructor
public class JournalEntity {
    private ObjectId id;
    private String journalTitle;
    private String journalDesc;
    private LocalDateTime journalDate;
}
