package com.devsuperior.dslearnbds.resources;

import com.devsuperior.dslearnbds.dtos.NotificationDTO;
import com.devsuperior.dslearnbds.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/notifications")
public class NotificationResource {
    @Autowired
    private NotificationService notificationService;
    
    @GetMapping
    public ResponseEntity<Page<NotificationDTO>> findAllNotificationsForCurrentUser(Pageable pageable) {
        var notifications = notificationService.findAllNotificationsForCurrentUser(pageable);
        return ResponseEntity.ok().body(notifications);
    }
}
