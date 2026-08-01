package com.workshop.API.com.Java.services.serviceImpl;

import com.workshop.API.com.Java.dtos.CourseDto;
import com.workshop.API.com.Java.models.Course;
import com.workshop.API.com.Java.repositories.CourseRepository;
import com.workshop.API.com.Java.services.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CouseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CouseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    @Override
    public CourseDto create(CourseDto courseDto) {
        boolean courseExists = courseRepository.existsByName(courseDto.name());
        if (courseExists)
            throw new RuntimeException("Curso existente!");

        System.out.println("Criando course " + courseDto);
        var course = new Course();
        course.setName(courseDto.name());
        course.setDescription(courseDto.description());
        course.setCourseStatus(courseDto.courseStatus());
        course.setCourseLevel(courseDto.courseLevel());
        course.setCreatedAt(LocalDateTime.now());
        var courseModel = courseRepository.save(course);

        var dto = new CourseDto(
                courseModel.getId(),
                courseModel.getName(),
                courseModel.getDescription(),
                courseModel.getCourseStatus(),
                courseModel.getCourseLevel(),
                null,
                courseModel.getCreatedAt());

        return dto;
    }

    @Override
    public CourseDto update(Long id, CourseDto courseDto) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isEmpty())
            throw new RuntimeException("Course not found");

        var model = course.get();
        BeanUtils.copyProperties(courseDto, model); // usar MapStruct
        var courseModel = courseRepository.save(model);

        return CourseDto.convertToDto(courseModel);
    }

    @Override
    public CourseDto getCourse(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isEmpty())
            throw new RuntimeException("Course not found");
        return CourseDto.convertToDto(course.get());
    }

}
