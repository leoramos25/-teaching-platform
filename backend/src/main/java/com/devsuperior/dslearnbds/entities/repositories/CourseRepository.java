package com.devsuperior.dslearnbds.entities.repositories;

import com.devsuperior.dslearnbds.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
