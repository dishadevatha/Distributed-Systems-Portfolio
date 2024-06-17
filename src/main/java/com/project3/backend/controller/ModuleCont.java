package com.project3.backend.controller;

import com.project3.backend.model.Mod;
import com.project3.backend.service.ModService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/module")
public class ModuleCont {

    @Autowired
    private ModService modService;

    @PostMapping
    public ResponseEntity<Mod> create(@RequestBody Mod mod) {
        Mod createdMod = modService.createMod(mod);
        return ResponseEntity.ok(createdMod);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Mod> get(@PathVariable Long id) {
        Optional<Mod> module = modService.getMod(id);
        return module.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mod> update(@PathVariable Long id, @RequestBody Mod mod) {
        Mod updatedMod = modService.updateMod(id, mod);
        return ResponseEntity.ok(updatedMod);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        modService.deleteMod(id);
        return ResponseEntity.noContent().build();
    }
}
