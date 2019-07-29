package com.bookstore.model;

import com.bookstore.model.security.Authority;
import com.bookstore.model.security.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class User  implements UserDetails {

    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private Long id;

    private String username;
    private String password;
    private String firstname;
    private String lastname;

    @Column(nullable = false)
    private String email;
    private String phone;
    private Boolean enabled = true;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<UserRole> userRoles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        userRoles.forEach( ur ->{
            grantedAuthorities.add(new Authority(ur.getRole().getName()));
        });
        return grantedAuthorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
