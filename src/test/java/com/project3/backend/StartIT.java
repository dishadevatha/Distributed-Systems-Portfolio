package com.project3.backend;

import com.project3.backend.model.Mod;
import com.project3.backend.model.Partner;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.project3.backend.frontend.Client;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class StartIT {

    @Autowired
    private Client client;

    // Partner tests
    @Test
    @Order(1)
    public void testCreatePartner() {
        Partner partner = new Partner();
        partner.setName("Test Partner");
        partner.setCountry("Test Country");
        partner.setDep("Test Department");
        partner.setUrl("http://Partner.com");
        partner.setContact("Test Contact");
        partner.setOutgoingStudents(10);
        partner.setIncomingStudents(10);
        partner.setSpringSem(LocalDate.of(2025, 1, 25));
        partner.setAutumnSem(LocalDate.of(2024, 9, 1));

        Partner createdPartner = client.createPartner(partner);
        assertNotNull(createdPartner.getId());
        assertEquals("Test Partner", createdPartner.getName());
    }

    @Test
    @Order(2)
    public void testGetPartner() {
        try {
            Partner partner = client.getPartner(1L);
            assertNotNull(partner);
            assertEquals("Test Partner", partner.getName());
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            System.out.println(e.getStatusCode());
            fail("Request failed: " + e.getStatusCode());
        }
    }

    // Module tests
    @Test
    @Order(3)
    public void testCreateMod() {
        try {
            Mod mod = new Mod();
            mod.setName("Fundamentals of Data Science");
            mod.setSem(1);
            mod.setCredits(5);
            mod.setUniversity(null);
            Mod createdMod = client.createMod(mod);
            assertNotNull(createdMod.getId());
            assertEquals("Fundamentals of Data Science", createdMod.getName());
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            fail("Request failed: " + e.getStatusCode());
        }
    }

    @Test
    @Order(4)
    public void testGetMod() {
        try {
            Mod mod = client.getMod(1L);
            assertNotNull(mod);
            assertEquals("Fundamentals of Data Science", mod.getName());
        } catch (HttpClientErrorException e) {
            assertEquals(404, e.getRawStatusCode());
        }
    }

    @Test
    @Order(5)
    public void testUpdateMod() {
        try {
            Mod mod = client.getMod(1L);
            mod.setName("Advanced Data Science");

            client.updateMod(1L, mod);
            Mod updatedMod = client.getMod(1L);
            assertEquals("Advanced Data Science", updatedMod.getName());
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            fail("Request failed: " + e.getStatusCode());
        }
    }

    @Test
    @Order(6)
    public void testDeleteMod() {
        try {
            client.deleteMod(1L);
            Mod mod = client.getMod(1L);
            assertNull(mod);
        } catch (HttpClientErrorException e) {
            assertEquals(404, e.getRawStatusCode());
        }
    }

    @Test
    @Order(7)
    public void testUpdatePartner() {
        try {
            Partner partner = client.getPartner(1L);
            partner.setName("Updated University");

            client.updatePartner(1L, partner);
            Partner updatedPartner = client.getPartner(1L);
            assertEquals("Updated University", updatedPartner.getName());
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            fail("Request failed: " + e.getStatusCode());
        }
    }

    @Test
    @Order(8)
    public void testDeletePartner() {
        try {
            client.deletePartner(1L);
            Partner partner = client.getPartner(1L);
            assertNull(partner);
        } catch (HttpClientErrorException e) {
            assertEquals(404, e.getRawStatusCode());
        }
    }

}

