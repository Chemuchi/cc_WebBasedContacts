package com.jaehyeong.cloudcomputing_1.contact.service;

import com.jaehyeong.cloudcomputing_1.contact.dto.ContactDTO;
import com.jaehyeong.cloudcomputing_1.contact.model.ContactEntity;
import com.jaehyeong.cloudcomputing_1.contact.model.ContactRepository;
import com.jaehyeong.cloudcomputing_1.user.model.UserEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.beans.Transient;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private static final Logger logger = LoggerFactory.getLogger(ContactServiceImpl.class);
    private final ContactRepository contactRepository;

    @Override
    @Transactional
    public ContactEntity addContact(ContactDTO contactDTO, UserEntity user) {
        ContactEntity contact = ContactEntity.builder()
                .name(contactDTO.getName())
                .email(contactDTO.getEmail())
                .phoneNumber(contactDTO.getPhoneNumber())
                .user(user)
                .build();
        return contactRepository.save(contact);
    }

    @Override
    @Transactional
    public ContactEntity updateContact(Long id, ContactDTO contactDTO, UserEntity user) {
        ContactEntity contact = contactRepository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException("연락처를 찾을 수 없습니다."));
        if (!contact.getUser().getId().equals(user.getId())) {
            throw new UnauthorizedAccessException("본인의 연락처만 수정할 수 있습니다.");
        }
        contact.setName(contactDTO.getName());
        contact.setEmail(contactDTO.getEmail());
        contact.setPhoneNumber(contactDTO.getPhoneNumber());
        return contactRepository.save(contact);
    }

    @Override
    @Transactional
    public void deleteContact(Long id, UserEntity user) {
        ContactEntity contact = contactRepository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException("연락처를 찾을 수 없습니다."));
        if (!contact.getUser().getId().equals(user.getId())) {
            throw new UnauthorizedAccessException("본인의 연락처만 삭제할 수 있습니다.");
        }
        contactRepository.delete(contact);
    }

    @Override
    public List<ContactEntity> getAllContacts(UserEntity user) {
        return contactRepository.findAllByUser(user);
    }

    @Override
    public List<ContactEntity> searchContactsByName(String name, UserEntity user){
        return contactRepository.findByNameAndUser(name, user);
    }

}