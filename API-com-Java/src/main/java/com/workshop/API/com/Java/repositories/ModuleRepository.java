package com.workshop.API.com.Java.repositories;

import com.workshop.API.com.Java.models.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ModuleRepository extends JpaRepository<Module, UUID> {
}
