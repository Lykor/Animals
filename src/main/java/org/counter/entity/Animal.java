package org.counter.entity;

import java.util.Map;

/**
 * Класс Animal (Животное) представляет собой абстрактное представление животного.
 * Он хранит свойства животного в форме пар ключ-значение.
 * @author Lykor
 * @version 1.0
 */
public class Animal {
    /**
     * Свойства животного в форме пар ключ-значение
     */
    private Map<String, String> properties;

    /**
     * Конструктор с заданными свойствами.
     * @param properties - Свойства животного
     */
    public Animal(Map<String, String> properties) {
        this.properties = properties;
    }

    /**
     * Возвращает свойства.
     * @return в форме пар ключ-значение
     */
    public Map<String, String> getProperties(){
        return properties;
    }

}
