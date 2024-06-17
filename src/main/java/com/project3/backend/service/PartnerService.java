package com.project3.backend.service;


import com.project3.backend.model.Partner;
import com.project3.backend.repository.PartnerRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PartnerService {

    @Autowired
    private PartnerRep partnerRep;

    public Partner createPartner(Partner partner) {
        return partnerRep.save(partner);
    }

    public Optional<Partner> getPartner(Long id) {
        return partnerRep.findById(id);
    }

    public Partner updatePartner(Long id, Partner partner) {
        partner.setId(id);
        return partnerRep.save(partner);
    }

    public void deletePartner(Long id) {
        partnerRep.deleteById(id);
    }

    public Page<Partner> searchPartner(Specification<Partner> spec, Pageable pageable) {
        return partnerRep.findAll(spec, pageable);
    }
}
