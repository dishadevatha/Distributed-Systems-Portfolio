package com.project3.backend.service;

import com.project3.backend.model.Mod;
import com.project3.backend.repository.ModulesRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModService {

    @Autowired
    private ModulesRep modulesRep;

    public Mod createMod(Mod data) {
        return modulesRep.save(data);
    }

    public Optional<Mod> getMod(Long id) {
        return modulesRep.findById(id);
    }

    public Mod updateMod(Long id, Mod mod) {
        mod.setId(id);
        return modulesRep.save(mod);
    }

    public void deleteMod(Long id) {
        modulesRep.deleteById(id);
    }
}
