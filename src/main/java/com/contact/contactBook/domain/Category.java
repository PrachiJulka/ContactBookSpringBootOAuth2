package com.contact.contactBook.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"type", "user"})})
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String type;
    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @ManyToMany(mappedBy = "categories")
    private Set<Contact> contacts = new HashSet<>();

}
