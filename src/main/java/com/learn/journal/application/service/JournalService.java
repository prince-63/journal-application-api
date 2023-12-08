package com.learn.journal.application.service;

import com.learn.journal.application.model.JournalEntity;
import com.learn.journal.application.model.User;
import com.learn.journal.application.repository.JournalRepository;
import com.learn.journal.application.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalService {

    @Autowired
    private JournalRepository journalRepository;
    @Autowired
    private UserRepository userRepository;

    public void save(JournalEntity newJournal, ObjectId userId) {
        // finding user in database
        User user = userRepository.findById(userId).orElse(null);

        if (user != null) {
            newJournal.setJournalDate(LocalDateTime.now());
            user.getJournalEntities().add(newJournal);
            journalRepository.save(newJournal);
            userRepository.save(user);
        }
    }

    public void saveAll(List<JournalEntity> newJournalEntities) {
        for (JournalEntity item : newJournalEntities) {
            item.setJournalDate(LocalDateTime.now());
        }
        journalRepository.saveAll(newJournalEntities);
    }

    public List<JournalEntity> getAll() {
        return journalRepository.findAll();
    }

    public Optional<JournalEntity> getById(ObjectId id) {
        return journalRepository.findById(id);
    }

    public boolean updateById(ObjectId id, JournalEntity newUpdatedJournal) {
        JournalEntity oldJournal = journalRepository.findById(id).orElse(null);
        if (oldJournal != null) {
            oldJournal.setJournalTitle(oldJournal.getJournalTitle().equals(newUpdatedJournal.getJournalTitle()) ? oldJournal.getJournalTitle() : newUpdatedJournal.getJournalTitle());
            oldJournal.setJournalDesc(oldJournal.getJournalDesc().equals(newUpdatedJournal.getJournalDesc()) ? oldJournal.getJournalDesc() : newUpdatedJournal.getJournalDesc());
            journalRepository.save(oldJournal);
            return true;
        }
        return false;
    }

    public boolean deleteAll() {
        journalRepository.deleteAll();
        return true;
    }

    public boolean deleteById(ObjectId id) {
        journalRepository.deleteById(id);
        return true;
    }
}
