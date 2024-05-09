package org.counter.rule;

import org.counter.entity.Animal;

/**
 * Класс, представляющий логическое правило "НЕ" для подсчета животных.
 * @author Lykor
 * @version 1.0
 */
public class NotRule implements Rule {
    private Rule rule;

    public NotRule(Rule rule) {
        this.rule = rule;
    }

    @Override
    public boolean evaluate(Animal animal) {
        return !rule.evaluate(animal);
    }

    @Override
    public String toString() {
        return "not " + rule.toString();
    }
}
