package com.bookstore.service;

import com.bookstore.dao.UserDao;
import com.bookstore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.findByUsername(s);
        if (user == null){
            throw new UsernameNotFoundException("'"+s+"' not found!");
        }
        return user;
    }
}
