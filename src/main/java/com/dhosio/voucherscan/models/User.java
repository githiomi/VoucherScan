package com.dhosio.voucherscan.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {

    private static int idCounter = 1;

    @Id
    private String empId;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private LocalDate dateOfBirth;
    private String branch;

    public User(String firstName, String lastName, String email, String password, LocalDate dob, String branch) {
        this.empId = "IE00" + idCounter;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = generateName(firstName, lastName);
        this.email = email;
        this.password = password;
        this.dateOfBirth = dob;
        this.branch = branch;
    }

    private String generateName(String fName, String lName) {

        if (fName.length() < 3 || lName.length() < 3) return (fName + lName).toUpperCase();

        return (fName.substring(0, 3) + lName.substring(0, 3)).toUpperCase();
    }

}
