package com.jaehyeong.cloudcomputing_1.contact.controller;

import com.jaehyeong.cloudcomputing_1.contact.dto.ContactDTO;
import com.jaehyeong.cloudcomputing_1.contact.model.ContactEntity;
import com.jaehyeong.cloudcomputing_1.contact.model.ContactRepository;
import com.jaehyeong.cloudcomputing_1.contact.service.ContactService;
import com.jaehyeong.cloudcomputing_1.user.controller.UserController;
import com.jaehyeong.cloudcomputing_1.user.model.UserEntity;
import com.jaehyeong.cloudcomputing_1.user.model.UserRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
@RequiredArgsConstructor
public class ContactController {

    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);
    private final ContactService contactService;

    @PostMapping("/add")
    public ResponseEntity<ContactEntity> addContact(@Valid @RequestBody ContactDTO contactDTO, HttpSession session) {
        UserEntity user = (UserEntity) session.getAttribute("user");
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        ContactEntity contactEntity = contactService.addContact(contactDTO, user);
        return ResponseEntity.ok(contactEntity);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ContactEntity> updateContact(@PathVariable Long id, @Valid @RequestBody ContactDTO contactDTO, HttpSession session) {
        UserEntity user = (UserEntity) session.getAttribute("user");
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        ContactEntity updatedContact = contactService.updateContact(id, contactDTO, user);
        return ResponseEntity.ok(updatedContact);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id, HttpSession session) {
        UserEntity user = (UserEntity) session.getAttribute("user");
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        contactService.deleteContact(id, user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<ContactEntity>> getAllContacts(HttpSession session) {
        UserEntity user = (UserEntity) session.getAttribute("user");
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        List<ContactEntity> contacts = contactService.getAllContacts(user);
        return ResponseEntity.ok(contacts);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ContactEntity>> searchContactsByName(@RequestParam String name, HttpSession session) {
        UserEntity user = (UserEntity) session.getAttribute("user");
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        List<ContactEntity> contacts = contactService.searchContactsByName(name, user);
        return ResponseEntity.ok(contacts);
    }
}
