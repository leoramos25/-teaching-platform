package com.devsuperior.dslearnbds.services;

import com.devsuperior.dslearnbds.entities.User;
import com.devsuperior.dslearnbds.repositories.UserRepository;
import com.devsuperior.dslearnbds.services.exceptions.ForbiddenException;
import com.devsuperior.dslearnbds.services.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    
    @Transactional(readOnly = true)
    public User authenticated() {
        try {
            var email = SecurityContextHolder.getContext().getAuthentication().getName();
            return userRepository.findByEmail(email);
        } catch (Exception error) {
            throw new UnauthorizedException("Invalid user");
        }
    }
    
    public void validateSelfOrAdmin(Long userId) {
        var authenticatedUser = authenticated();
        
        if (!authenticatedUser.getId().equals(userId) && !authenticatedUser.hasRole("ROLE_ADMIN")) {
            throw new ForbiddenException("Denied access");
        }
    }
}
