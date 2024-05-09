package org.counter.entity;

import org.junit.Before;
import org.junit.Test;


import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class AnimalTest {

    Map<String, String> properties;
    Animal animal;

    @Before
    public void setUp() {
        properties = new HashMap<>();
        properties.put("property1", "плотоядные");
        properties.put("property2", "маленькое");
        animal = new Animal(properties);
    }

    @Test
    public void getProperties() {
        assertEquals("плотоядные", animal.getProperties().get("property1"));
        assertEquals("маленькое", animal.getProperties().get("property2"));
    }
}