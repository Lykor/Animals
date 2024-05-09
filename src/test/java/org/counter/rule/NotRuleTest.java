package org.counter.rule;

import org.counter.entity.Animal;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class NotRuleTest {

    Rule rule;
    Map<String, String> properties;
    Animal animal;

    @Before
    public void setUp(){
        rule = new NotRule(
                new PropertyRule("плотоядные")
        );
        properties = new HashMap<>();
        properties.put("property2", "маленькое");
        animal = new Animal(properties);
    }

    @Test
    public void evaluate() {
        assertTrue(rule.evaluate(animal));
    }
}