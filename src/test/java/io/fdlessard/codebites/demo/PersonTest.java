package io.fdlessard.codebites.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person person;

    @BeforeEach
    void setup() {
        person = new Person("Lastname", "Firstname");
    }

    @Test
    void getLastName() {
        assertEquals("Lastname", person.getLastName());
    }

    @Test
    void getFirstName() {
        assertEquals("Firstname", person.getFirstName());
    }

}