package org.counter.rule;

import org.counter.entity.Animal;

/**
 * Класс, представляющий правило для подсчета животных по значению свойства.
 * @author Lykor
 * @version 1.0
 */
public class AndRule implements Rule {
    private Rule rule1;
    private Rule rule2;

    public AndRule(Rule rule1, Rule rule2) {
        this.rule1 = rule1;
        this.rule2 = rule2;
    }

    @Override
    public boolean evaluate(Animal animal) {
        return rule1.evaluate(animal) && rule2.evaluate(animal);
    }

    @Override
    public String toString() {
        return rule1.toString() + " and " + rule2.toString();
    }
}
