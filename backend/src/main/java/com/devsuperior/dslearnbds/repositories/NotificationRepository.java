package com.devsuperior.dslearnbds.repositories;

import com.devsuperior.dslearnbds.entities.Notification;
import com.devsuperior.dslearnbds.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    @Query("SELECT notification FROM Notification notification WHERE "
            + "(notification.user = :user) AND "
            + "(:unreadOnly = false OR notification.read = false) "
            + "ORDER BY notification.moment DESC")
    Page<Notification> find(User user, boolean unreadOnly, Pageable pageable);
}
