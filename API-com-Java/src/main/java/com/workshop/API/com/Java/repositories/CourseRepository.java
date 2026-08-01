package com.workshop.API.com.Java.repositories;

import com.workshop.API.com.Java.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

    boolean existsByName(String name);
}
