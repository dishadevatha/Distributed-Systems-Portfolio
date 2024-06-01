package com.portfolio3.api.frontend;

//import com.portfolio3.api.model.Modules;
//import com.portfolio3.api.model.Partner;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriComponentsBuilder;
//
//@Component
//public class Frontend {
//
//    private static final String BASE_URL = "http://localhost:8080/portfolio";
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    // University methods
//    public Partner createUniversity(Partner partner) {
//        return restTemplate.postForObject(BASE_URL + "/universities", partner, Partner.class);
//    }
//
//    public Partner getUniversity(Long id) {
//        return restTemplate.getForObject(BASE_URL + "/universities/{id}", Partner.class, id);
//    }
//
//    public void updateUniversity(Long id, Partner partner) {
//        restTemplate.put(BASE_URL + "/universities/{id}", partner, id);
//    }
//
//    public void deleteUniversity(Long id) {
//        restTemplate.delete(BASE_URL + "/universities/{id}", id);
//    }
//
//    public Partner[] searchUniversities(String query) {
//        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/universities")
//                .query(query)
//                .toUriString();
//        return restTemplate.getForObject(url, Partner[].class);
//    }
//
//    // Module methods
//    public Modules createModule(Modules modules) {
//        return restTemplate.postForObject(BASE_URL + "/modules", modules, Modules.class);
//    }
//
//    public Modules getModule(Long id) {
//        return restTemplate.getForObject(BASE_URL + "/modules/{id}", Modules.class, id);
//    }
//
//    public void updateModule(Long id, Modules modules) {
//        restTemplate.put(BASE_URL + "/modules/{id}", modules, id);
//    }

//    public void deleteModule(Long id) {
//        restTemplate.delete(BASE_URL + "/modules/{id}", id);
//    }
//}