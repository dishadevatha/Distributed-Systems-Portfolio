package com.project3.backend.specification;
import com.project3.backend.model.Partner;
import org.springframework.data.jpa.domain.Specification;

public class partnerSpec {
    public static Specification<Partner> getPartnerSpec(String name, String country, String department) {
        return (root, query, criteriaBuilder) -> {
            if (name != null && !name.isEmpty()) {
                return criteriaBuilder.like(root.get("name"), "%" + name + "%");
            }
            if (country != null && !country.isEmpty()) {
                return criteriaBuilder.like(root.get("country"), "%" + country + "%");
            }
            if (department != null && !department.isEmpty()) {
                return criteriaBuilder.like(root.get("department"), "%" + department + "%");
            }
            return criteriaBuilder.conjunction();
        };
    }
}