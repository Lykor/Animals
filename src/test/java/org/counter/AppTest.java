package org.counter;

import org.counter.rule.AndRule;
import org.counter.rule.NotRule;
import org.counter.rule.OrRule;
import org.counter.rule.PropertyRule;
import org.counter.service.AnimalCounter;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void RunAppTest() {
        AnimalCounter counter = new AnimalCounter();
        counter.readFile(System.getProperty("user.dir") + "/src/main/resources/animals.txt");
        counter.addRule(new PropertyRule("травоядные"));
        counter.addRule(new OrRule(
                new PropertyRule("травоядные"),
                new AndRule(
                        new PropertyRule("плотоядные"),
                        new PropertyRule("маленькое")
                )
        ));
        counter.addRule(new AndRule(
                new PropertyRule("всеядные"),
                new NotRule(new PropertyRule("высокое"))
        ));
        assertNotEquals("",counter.countAnimals().length());
    }
}