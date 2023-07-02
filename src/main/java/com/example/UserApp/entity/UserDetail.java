package com.example.UserApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String name;
    String className;
    String fatherName;
    String motherName;
    String email;
    String whatsAppNumber;
    String dob;
    String zipCode;

}
