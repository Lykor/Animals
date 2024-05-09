package org.counter.rule;

import org.counter.entity.Animal;

import java.util.Map;

/**
 * Класс, представляющий правило для подсчета животных по значению свойства.
 * @author Lykor
 * @version 1.0
 */
public class PropertyRule implements Rule {
    private String propertyValue;

    public PropertyRule(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    /**
     * Проверка в функции происходит путем игнорирования параметра клуча и проверку по самому свойству.
     * @param animal животное, для которого необходимо проверить соответствие правилу
     * @return true/false в зависимости от совпадения свойств
     */
    @Override
    public boolean evaluate(Animal animal) {
        for (Map.Entry<String, String> entry : animal.getProperties().entrySet()) {
            if (entry.getValue().equals(propertyValue)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return propertyValue;
    }
}
