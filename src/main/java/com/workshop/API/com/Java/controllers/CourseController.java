package com.workshop.API.com.Java.controllers;

import com.workshop.API.com.Java.dtos.CourseDto;
import com.workshop.API.com.Java.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto courseDto) {
        CourseDto dto = courseService.create(courseDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDto> updateCourse(@PathVariable Long id,
                                                  @RequestBody CourseDto courseDto) {
        return ResponseEntity.ok(courseService.update(id, courseDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getCourse(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.getCourse(id));
    }

    /*@GetMapping    ---*** para casa
    public ResponseEntity<List<CourseDto>> getAllCourse() {
        return ResponseEntity.of(courseService.getAll());
    }*/
}
