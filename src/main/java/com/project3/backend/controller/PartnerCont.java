package com.project3.backend.controller;

import com.project3.backend.model.Partner;
import com.project3.backend.service.PartnerService;
import com.project3.backend.specification.partnerSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/partners")
public class PartnerCont {

    @Autowired
    private PartnerService partnerService;

    @PostMapping
    public ResponseEntity<Partner> createPartner(@RequestBody Partner partner) {
        Partner createdPartner = partnerService.createPartner(partner);
        return ResponseEntity.ok(createdPartner);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partner> getPartner(@PathVariable Long id) {
        Optional<Partner> university = partnerService.getPartner(id);
        return university.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Partner> updatePartner(@PathVariable Long id, @RequestBody Partner partner) {
        Partner updatedPartner = partnerService.updatePartner(id, partner);
        return ResponseEntity.ok(updatedPartner);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePartner(@PathVariable Long id) {
        partnerService.deletePartner(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<Partner>> searchPartner(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String department,
            Pageable pageable) {
        Specification<Partner> spec = partnerSpec.getPartnerSpec(name, country, department);
        Page<Partner> universities = partnerService.searchPartner(spec, pageable);
        return ResponseEntity.ok(universities);
    }
}
