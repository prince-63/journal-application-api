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

    @PostMapping("/all")
    public void saveAll(@RequestBody List<JournalEntity> newJournalEntities) {
        journalService.saveAll(newJournalEntities);
    }

    @GetMapping
    public List<JournalEntity> getAll() {
        return journalService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<JournalEntity> getById(@PathVariable ObjectId id) {
        return journalService.getById(id);
    }

    @PutMapping("/{id}")
    public boolean updateById(@PathVariable ObjectId id, @RequestBody JournalEntity newUpdatedJournal) {
        return journalService.updateById(id, newUpdatedJournal);
    }

    @DeleteMapping
    public boolean deleteAll() {
        return journalService.deleteAll();
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable ObjectId id) {
        return journalService.deleteById(id);
    }
}
