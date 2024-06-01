package com.portfolio3.api.service;


import com.portfolio3.api.model.Partner;
import com.portfolio3.api.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PartnerService {

    @Autowired
    private PartnerRepository partnerRepository;

    public Partner createPartner(Partner partner) {
        return partnerRepository.save(partner);
    }

    public Optional<Partner> getPartner(Long id) {
        return partnerRepository.findById(id);
    }

    public Partner updatePartner(Long id, Partner partner) {
        partner.setId(id);
        return partnerRepository.save(partner);
    }

    public void deletePartner(Long id) {
        partnerRepository.deleteById(id);
    }

    public Page<Partner> searchPartners(Specification<Partner> spec, Pageable pageable) {
        return partnerRepository.findAll(spec, pageable);
    }
}
