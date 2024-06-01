package com.portfolio3.api.controller;

import com.portfolio3.api.model.Modules;
import com.portfolio3.api.service.ModulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/modules")
public class ModulesController {

    @Autowired
    private ModulesService modulesService;

    @PostMapping
    public ResponseEntity<Modules> createModules(@RequestBody Modules modules) {
        Modules createdModules = modulesService.createModules(modules);
        return ResponseEntity.ok(createdModules);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modules> getModules(@PathVariable Long id) {
        Optional<Modules> module = modulesService.getModules(id);
        return module.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modules> updateModules(@PathVariable Long id, @RequestBody Modules modules) {
        Modules updatedModules = modulesService.updateModules(id, modules);
        return ResponseEntity.ok(updatedModules);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModules(@PathVariable Long id) {
        modulesService.deleteModules(id);
        return ResponseEntity.noContent().build();
    }
}
