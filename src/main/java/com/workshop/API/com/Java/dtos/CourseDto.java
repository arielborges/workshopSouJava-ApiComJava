package com.workshop.API.com.Java.dtos;

import com.workshop.API.com.Java.enums.CourseLevel;
import com.workshop.API.com.Java.enums.CourseStatus;
import com.workshop.API.com.Java.models.Course;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public record CourseDto(
        Long id,
        String name,
        String description,
        CourseStatus courseStatus,
        CourseLevel courseLevel,
        Set<ModuleDto> modules,
        LocalDateTime createdAt
) {
    public static CourseDto convertToDto(Course courseModel) {
        return new CourseDto(
                courseModel.getId(),
                courseModel.getName(),
                courseModel.getDescription(),
                courseModel.getCourseStatus(),
                courseModel.getCourseLevel(),
                courseModel.getModules().stream() // processar item por item.
                        .map(ModuleDto::convertToDto) //transforma cada Module em ModuleDto
                        .collect(Collectors.toSet()), // junta tudo de volta em um Set
                courseModel.getCreatedAt()

                /*
                * Set<ModuleDto> dtos = new HashSet<>();
                *   for (Module module : courseModel.getModules()) {
                *       dtos.add(ModuleDto.convertToDto(module));
                *    }
                *
                * Stream é um for mais elegante
                * uma forma moderna de percorrer coleções e
                * transformar dados de forma mais declarativa.
                *
                *
                * Imperativo: Pegue um copo, abra a torneira, encha até metade, feche a torneira…
                * Declarativo: Me dá um copo com água.
                * */
        );
    }
}
