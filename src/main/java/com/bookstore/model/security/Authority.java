package com.bookstore.model.security;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {

    private final String autority;

    public Authority(String autority){
        this.autority = autority;
    }

    @Override
    public String getAuthority() {
        return autority;
    }
}
