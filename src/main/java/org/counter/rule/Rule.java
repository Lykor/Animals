package org.counter.rule;

import org.counter.entity.Animal;

/**
 * Интерфейс, представляющий правило для подсчета животных.
 * Для создания новых правил необходимо реализовать данный интерфейс и переопределить метод {@link #evaluate(Animal)}.
 * @see Animal
 * @see AndRule
 * @see OrRule
 * @see NotRule
 * @see PropertyRule
 * @author Lykor
 * @version 1.0
 */
public interface Rule {
    /**
     * Проверяет, соответствует ли конкретное животное данному правилу.
     *
     * @param animal животное, для которого необходимо проверить соответствие правилу
     * @return true, если животное соответствует правилу, иначе false
     */
    boolean evaluate(Animal animal);
}
