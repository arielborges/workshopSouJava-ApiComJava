package com.workshop.API.com.Java.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.workshop.API.com.Java.enums.CourseLevel;
import com.workshop.API.com.Java.enums.CourseStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "tb_course")
public class Course /*implements Serializable*/ {
/*  @Serial
    private static final long serialVersionUID = 1L;*/
    // evitamos Serializable porque preferimos JSON

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // 'Long' pode ser NULL(como vem no json do dto) e o 'long' não pode.

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CourseStatus courseStatus;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private CourseLevel courseLevel;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private Set<Module> modules;

    @Column(updatable = false) // não permite atualizar
    private LocalDateTime createdAt;

/*  Para casa

    @Column(nullable = false)
    private UUID userInstructor;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<UserModel> users;   */

    public Course(Long id, String name, String description, CourseStatus courseStatus, CourseLevel courseLevel, Set<Module> modules, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.courseStatus = courseStatus;
        this.courseLevel = courseLevel;
        this.modules = modules;
        this.createdAt = createdAt;
    }

    public Course(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CourseStatus getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(CourseStatus courseStatus) {
        this.courseStatus = courseStatus;
    }

    public CourseLevel getCourseLevel() {
        return courseLevel;
    }

    public void setCourseLevel(CourseLevel courseLevel) {
        this.courseLevel = courseLevel;
    }

    public Set<Module> getModules() {
        return modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
