package com.project3.backend.repository;

import com.project3.backend.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PartnerRep extends JpaRepository<Partner, Long>, JpaSpecificationExecutor<Partner> {

}
