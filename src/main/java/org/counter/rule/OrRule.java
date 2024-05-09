package org.counter.rule;

import org.counter.entity.Animal;

/**
 * Класс, представляющий логическое правило "ИЛИ" для подсчета животных.
 * @author Lykor
 * @version 1.0
 */
public class OrRule implements Rule {
    private Rule rule1;
    private Rule rule2;

    public OrRule(Rule rule1, Rule rule2) {
        this.rule1 = rule1;
        this.rule2 = rule2;
    }

    @Override
    public boolean evaluate(Animal animal) {
        return rule1.evaluate(animal) || rule2.evaluate(animal);
    }

    @Override
    public String toString() {
        return rule1.toString() + " or " + rule2.toString();
    }
}
