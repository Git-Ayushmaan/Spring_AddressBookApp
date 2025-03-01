package com.bridgelabz.springaddressbookapplication.controller;

import com.bridgelabz.springaddressbookapplication.dto.AddressBookDTO;
import com.bridgelabz.springaddressbookapplication.model.AddressBook;
import com.bridgelabz.springaddressbookapplication.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    private final AddressBookService service;

    @Autowired  // Ensure this is used for dependency injection
    public AddressBookController(AddressBookService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<AddressBook> addEntry(@RequestParam String name) {
        return ResponseEntity.ok(service.addEntry(name));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AddressBook>> getAllEntries() {
        return ResponseEntity.ok(service.getAllEntries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressBook> getEntryById(@PathVariable Long id) {
        AddressBook entry = service.getEntryById(id);
        return (entry != null) ? ResponseEntity.ok(entry) : ResponseEntity.notFound().build();
    }

}
