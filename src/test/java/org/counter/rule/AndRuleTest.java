package org.counter.rule;

import org.counter.entity.Animal;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class AndRuleTest {

    Rule rule;
    Map<String, String> properties;
    Animal animal;

    @Before
    public void setUp(){
        rule = new AndRule(
                new PropertyRule("плотоядные"),
                new PropertyRule("маленькое")
        );
        properties = new HashMap<>();
        properties.put("property1", "плотоядные");
        properties.put("property2", "маленькое");
        animal = new Animal(properties);
    }

    @Test
    public void evaluate() {
        assertTrue(rule.evaluate(animal));
        properties.clear();
        assertFalse(rule.evaluate(animal));
    }
}