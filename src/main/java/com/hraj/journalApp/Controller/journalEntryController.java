package com.hraj.journalApp.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hraj.journalApp.Entity.journalEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


@RestController
@RequestMapping("/journal")
public class journalEntryController {
    private Map<Long, journalEntry> journalEntries = new HashMap<>();
    @GetMapping
    public List<journalEntry> getAll() {
        return new ArrayList<>(journalEntries.values());
    }
    @PostMapping
    public boolean createEntry(@RequestBody journalEntry myEntry){
        journalEntries.put(myEntry.getId(), myEntry);
        return true;
    }
    @GetMapping("id/{myId}")
    public journalEntry getJournalEntryById(@PathVariable Long myId){
        return journalEntries.get(myId);
    }
    
}
