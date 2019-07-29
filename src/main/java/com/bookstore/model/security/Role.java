package com.bookstore.model.security;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue
    private Long roldId;
    private String name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<UserRole> userRoles = new HashSet<>();

}
