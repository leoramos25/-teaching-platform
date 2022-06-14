package com.devsuperior.dslearnbds.entities.repositories;

import com.devsuperior.dslearnbds.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
