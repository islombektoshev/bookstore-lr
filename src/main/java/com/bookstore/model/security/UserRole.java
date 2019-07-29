package com.bookstore.model.security;

import com.bookstore.model.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UserRole {
    @Id
    @GeneratedValue
    private Long urserroleid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private final User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private final Role role;


    public UserRole(Role role, User user){
        this.role = role;
        this.user = user;
    }

}
