package com.apexion.model;

import java.util.HashSet;
import java.util.Set;

import com.apexion.domain.USER_ROLE;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String email;

    private String firstName;

    private String lastName;

    private String mobile;

    private USER_ROLE role = USER_ROLE.ROLE_CUSTOMER;

    private Set<Address> addresses = new HashSet<>();

    private Set<Couupon> usedCouupons = new HashSet<>();

}
