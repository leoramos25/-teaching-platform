package com.devsuperior.dslearnbds.services;

import com.devsuperior.dslearnbds.dtos.DeliverRevisionDTO;
import com.devsuperior.dslearnbds.repositories.DeliverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeliverService {
    @Autowired
    private DeliverRepository deliverRepository;
    
    @Transactional
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
    public void createRevision(Long deliverId, DeliverRevisionDTO deliverRevision) {
        var deliver = deliverRepository.getOne(deliverId);
        deliver.setStatus(deliver.getStatus());
        deliver.setFeedback(deliver.getFeedback());
        deliver.setCorrectCount(deliverRevision.getCorrectCount());
        deliverRepository.save(deliver);
    }
}
