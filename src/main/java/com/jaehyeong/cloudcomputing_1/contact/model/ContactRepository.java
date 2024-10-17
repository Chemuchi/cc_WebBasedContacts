package com.jaehyeong.cloudcomputing_1.contact.model;

import com.jaehyeong.cloudcomputing_1.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContactRepository extends JpaRepository<ContactEntity, Long> {
    List<ContactEntity> findAllByUser(UserEntity user);
    List<ContactEntity> findByNameAndUser(String name, UserEntity user);
}
