package com.learn.journal.application.repository;

import com.learn.journal.application.model.JournalEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalRepository extends MongoRepository<JournalEntity, ObjectId> {
}
