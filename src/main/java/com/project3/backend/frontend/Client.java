package com.project3.backend.frontend;

import com.project3.backend.model.Mod;
import com.project3.backend.model.Partner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Client {

    private static final String BASE_URL = "http://localhost:8080/project";

    @Autowired
    private RestTemplate restTemplate;

    // Partner methods
    public Partner createPartner(Partner partner) {
        return restTemplate.postForObject(BASE_URL + "/partners", partner, Partner.class);
    }

    public Partner getPartner(Long id) {
        return restTemplate.getForObject(BASE_URL + "/partners/{id}", Partner.class, id);
    }

    public void updatePartner(Long id, Partner partner) {
        restTemplate.put(BASE_URL + "/partners/{id}", partner, id);
    }

    public void deletePartner(Long id) {
        restTemplate.delete(BASE_URL + "/partners/{id}", id);
    }


    // Module methods
    public Mod createMod(Mod mod) {
        return restTemplate.postForObject(BASE_URL + "/module", mod, Mod.class);
    }

    public Mod getMod(Long id) {
        return restTemplate.getForObject(BASE_URL + "/module/{id}", Mod.class, id);
    }

    public void updateMod(Long id, Mod mod) {
        restTemplate.put(BASE_URL + "/module/{id}", mod, id);
    }

    public void deleteMod(Long id) {
        restTemplate.delete(BASE_URL + "/module/{id}", id);
    }
}