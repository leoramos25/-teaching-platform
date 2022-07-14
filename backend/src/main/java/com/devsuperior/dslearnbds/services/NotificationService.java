package com.devsuperior.dslearnbds.services;

import com.devsuperior.dslearnbds.dtos.NotificationDTO;
import com.devsuperior.dslearnbds.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;
    
    @Autowired
    private AuthService authService;
    
    @Transactional(readOnly = true)
    public Page<NotificationDTO> findAllNotificationsForCurrentUser(boolean unreadOnly, Pageable pageable) {
        var authenticatedUser = authService.authenticated();
        var pageableNotifications = notificationRepository.find(authenticatedUser, unreadOnly, pageable);
        return pageableNotifications.map(NotificationDTO::new);
    }
}
