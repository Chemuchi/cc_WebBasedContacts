package com.jaehyeong.cloudcomputing_1.contact.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jaehyeong.cloudcomputing_1.user.model.UserEntity;
import com.jaehyeong.cloudcomputing_1.validate.anotation.ValidPhoneNumber;
import jakarta.persistence.*;
import lombok.*;

import java.net.SocketOption;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contacts")
public class ContactEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @ValidPhoneNumber
    @Column(nullable = false)
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private UserEntity user;


    @PreUpdate
    @PrePersist
    public void formatPhoneNumber() {
        if (phoneNumber != null && phoneNumber.matches("^010\\d{8}$")) {
            this.phoneNumber = phoneNumber.replaceFirst("^(010)(\\d{4})(\\d{4})$", "$1-$2-$3");
        }
    }
}
