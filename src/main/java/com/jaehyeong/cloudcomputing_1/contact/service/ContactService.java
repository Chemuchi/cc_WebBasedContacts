package com.jaehyeong.cloudcomputing_1.contact.service;

import com.jaehyeong.cloudcomputing_1.contact.dto.ContactDTO;
import com.jaehyeong.cloudcomputing_1.contact.model.ContactEntity;
import com.jaehyeong.cloudcomputing_1.user.model.UserEntity;

import java.util.List;

public interface ContactService {
    ContactEntity addContact(ContactDTO contactDTO, UserEntity user);
    ContactEntity updateContact(Long id, ContactDTO contactDTO, UserEntity user);
    void deleteContact(Long id, UserEntity user);
    List<ContactEntity> getAllContacts(UserEntity user);
    List<ContactEntity> searchContactsByName(String name, UserEntity user);

}
