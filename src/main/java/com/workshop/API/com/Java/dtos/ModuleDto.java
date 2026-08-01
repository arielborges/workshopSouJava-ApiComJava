package com.workshop.API.com.Java.dtos;

import com.workshop.API.com.Java.models.Course;
import com.workshop.API.com.Java.models.Module;

import java.time.LocalDateTime;
import java.util.UUID;

public record ModuleDto(
        UUID id,
        String title,
        String description,
        Course course,
        LocalDateTime createdAt
) {
    public static ModuleDto convertToDto(Module module) {
        return new ModuleDto(
                module.getId(),
                module.getTitle(),
                module.getDescription(),
                module.getCourse(),
                module.getCreatedAt()
        );
    }
}
