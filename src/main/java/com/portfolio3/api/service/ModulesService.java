package com.portfolio3.api.service;

import com.portfolio3.api.model.Modules;
import com.portfolio3.api.repository.ModulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModulesService {

    @Autowired
    private ModulesRepository modulesRepository;

    public Modules createModules(Modules modules) {
        return modulesRepository.save(modules);
    }

    public Optional<Modules> getModules(Long id) {
        return modulesRepository.findById(id);
    }

    public Modules updateModules(Long id, Modules modules) {
        modules.setId(id);
        return modulesRepository.save(modules);
    }

    public void deleteModules(Long id) {
        modulesRepository.deleteById(id);
    }
}
