package com;

import com.model.Greenhouse;
import com.repository.GreenhouseRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class DBTests {

    @Autowired
    private GreenhouseRepository greenhouseRepository;

    @Test
    void insertGreenhouse() {
        // Create a new Greenhouse object
        Greenhouse greenhouse = new Greenhouse();
        greenhouse.setName("Test Greenhouse");
        greenhouse.setLocation("Test Location");

        // Save the Greenhouse object to the database
        Greenhouse savedGreenhouse = this.greenhouseRepository.save(greenhouse);

        // Check if the ID of the saved Greenhouse is not null
        Assertions.assertNotNull(savedGreenhouse.getId());
    }
}
