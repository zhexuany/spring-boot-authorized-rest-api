package edu.global.sgs.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private @ManyToOne Admin admin;

    private @Version @JsonIgnore Long version;

    public User(String firstName, String lastName, Admin admin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.admin = admin;
    }
}
