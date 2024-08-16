package com.muruna.apirest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.muruna.apirest.constants.AppConstants;
import com.muruna.apirest.model.User;
import com.muruna.apirest.repository.UserRepository;
import com.muruna.apirest.service.UserService;

import java.util.Date;
import java.util.regex.Pattern;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Value("${muruna.password-validator}")
    private String passwordRegEx;

    @Override
    public User create(User user) {

        if(!Pattern.compile(passwordRegEx).matcher(user.getPassword()).matches()) {
            throw new IllegalArgumentException(AppConstants.INVALID_PASSWORD_MSG);
        }

        user.setCreated(new Date());
        user.setModified(new Date());
        user.setIsActive(Boolean.TRUE);
        return repository.save(user);
    }
}
