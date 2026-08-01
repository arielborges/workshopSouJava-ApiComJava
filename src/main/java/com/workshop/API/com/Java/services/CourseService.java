package com.workshop.API.com.Java.services;

import com.workshop.API.com.Java.dtos.CourseDto;

public interface CourseService {
    
    CourseDto create(CourseDto courseDto);

    CourseDto update(Long id, CourseDto courseDto);

    CourseDto getCourse(Long id);
}
