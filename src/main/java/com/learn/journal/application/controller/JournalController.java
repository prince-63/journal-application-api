package com.learn.journal.application.controller;

import com.learn.journal.application.model.JournalEntity;
import com.learn.journal.application.service.JournalService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class JournalController {

    @Autowired
    private JournalService journalService;

    @PostMapping("/{userId}")
    public void save(@RequestBody JournalEntity newJournal, @PathVariable ObjectId userId) {
        journalService.save(newJournal, userId);
    }

    @PostMapping("/all/{userId}")
    public void saveAll(@RequestBody List<JournalEntity> newJournalEntities, @PathVariable ObjectId userId) {
        journalService.saveAll(newJournalEntities, userId);
    }

    @GetMapping("/all/{userId}")
    public List<JournalEntity> getAll(@PathVariable ObjectId userId) {
        return journalService.getAll(userId);
    }

    @GetMapping("/{userId}/{journalId}")
    public Optional<JournalEntity> getById(@PathVariable ObjectId userId, @PathVariable ObjectId journalId) {
        return journalService.getById(userId, journalId);
    }

    @PutMapping("/{userId}/{journalId}")
    public boolean updateById(@PathVariable ObjectId userId, @PathVariable ObjectId journalId, @RequestBody JournalEntity newUpdatedJournal) {
        return journalService.updateById(userId, journalId, newUpdatedJournal);
    }

    @DeleteMapping("/all/{userId}")
    public boolean deleteAll(@PathVariable ObjectId userId) {
        return journalService.deleteAll(userId);
    }

    @DeleteMapping("/{userId}/{journalId}")
    public boolean deleteById(@PathVariable ObjectId userId, @PathVariable ObjectId journalId) {
        return journalService.deleteById(userId, journalId);
    }
}
