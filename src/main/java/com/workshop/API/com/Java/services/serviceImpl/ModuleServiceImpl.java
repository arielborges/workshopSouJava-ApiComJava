package com.workshop.API.com.Java.services.serviceImpl;

import com.workshop.API.com.Java.repositories.ModuleRepository;
import com.workshop.API.com.Java.services.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ModuleServiceImpl implements ModuleService {

    private final ModuleRepository moduleRepository;
}
