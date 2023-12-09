package com.learn.journal.application.service;

import com.learn.journal.application.model.JournalEntity;
import com.learn.journal.application.model.User;
import com.learn.journal.application.repository.JournalRepository;
import com.learn.journal.application.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class JournalService {

    @Autowired
    private JournalRepository journalRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    private List<JournalEntity> journalEntities = new ArrayList<>();

    public void save(JournalEntity newJournal, ObjectId userId) {
        User user = userService.getUserById(userId).orElse(null);
        if (user != null) {
            newJournal.setJournalDate(LocalDateTime.now());
            newJournal.setId(ObjectId.get());
            user.getJournalEntities().add(newJournal);
            journalRepository.save(newJournal);
            userService.createUser(user);
        }
    }

    public void saveAll(List<JournalEntity> newJournalEntities, ObjectId userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            for (JournalEntity item : newJournalEntities) {
                item.setJournalDate(LocalDateTime.now());
                item.setId(ObjectId.get());
            }
            user.getJournalEntities().addAll(newJournalEntities);
            userRepository.save(user);
            journalRepository.saveAll(newJournalEntities);
        }
    }

    public List<JournalEntity> getAll(ObjectId userId) {
        journalEntities.clear();
        User user = userService.getUserById(userId).orElse(null);
        if (user != null) {
            journalEntities.addAll(user.getJournalEntities());
        }
        return journalEntities;
    }

    public Optional<JournalEntity> getById(ObjectId userId, ObjectId journalId) {
        Optional<JournalEntity> journalReturn = null;
        User user = userService.getUserById(userId).orElse(null);
        if (user != null) {
            JournalEntity journal = journalRepository.findById(journalId).orElse(null);
            if (journal != null) {
                boolean isTrue = user.getJournalEntities().contains(journal);
                if (isTrue) {
                    journalReturn = journalRepository.findById(journalId);
                }
            }
        }
        ;
        return journalReturn;
    }

    public boolean updateById(ObjectId userId, ObjectId journalId, JournalEntity newUpdatedJournal) {
        User user = userService.getUserById(userId).orElse(null);
        if (user != null) {
            JournalEntity oldJournal = journalRepository.findById(journalId).orElse(null);
            if (oldJournal != null) {
                boolean isTrue = user.getJournalEntities().contains(oldJournal);
                if (isTrue) {
                    oldJournal.setJournalTitle(oldJournal.getJournalTitle().equals(newUpdatedJournal.getJournalTitle()) ? oldJournal.getJournalTitle() : newUpdatedJournal.getJournalTitle());
                    oldJournal.setJournalDesc(oldJournal.getJournalDesc().equals(newUpdatedJournal.getJournalDesc()) ? oldJournal.getJournalDesc() : newUpdatedJournal.getJournalDesc());
                    journalRepository.save(oldJournal);
                    userService.createUser(user);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean deleteAll(ObjectId userId) {
        User user = userService.getUserById(userId).orElse(null);
        if (user != null) {
            for (JournalEntity journal : user.getJournalEntities()) {
                journalRepository.deleteById(journal.getId());
            }
            // get user journal list
            List<JournalEntity> journalEntities1 = user.getJournalEntities();
            journalEntities1.clear();
            userService.createUser(user);
            return true;
        }
        return false;
    }

    public boolean deleteById(ObjectId userId, ObjectId journalId) {
        User user = userService.getUserById(userId).orElse(null);
        if (user != null) {
            JournalEntity journal = journalRepository.findById(journalId).orElse(null);
            if (journal != null) {
                boolean isTrue = user.getJournalEntities().contains(journal);
                if (isTrue) {
                    journalRepository.deleteById(journalId);
                    user.getJournalEntities().remove(journal);
                    userService.createUser(user);
                    return true;
                }
            }
        }
        return false;
    }
}
