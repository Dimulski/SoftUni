package com.securitydemo.service;

import com.securitydemo.model.RegistrationModel;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void register(RegistrationModel registrationModel);

    @PreAuthorize("hasRole('ADMIN')")
    void delete();
}