package com.devsuperior.dslearnbds.entities.repositories;

import com.devsuperior.dslearnbds.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
