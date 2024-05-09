package org.counter.service;

import org.counter.entity.Animal;
import org.counter.rule.Rule;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс, реализующий систему учета животных.
 * Считывает данные из файла, создает объекты животных и выполняет подсчет животных по заданным правилам.
 */
public class AnimalCounter {
    private List<Animal> animals;
    private List<Rule> rules;

    public AnimalCounter() {
        animals = new ArrayList<>();
        rules = new ArrayList<>();
    }

    /**
     * Считывает данные о животных из указанного файла.
     * Формат файла: каждая строка представляет собой набор свойств животного, разделенных запятыми.
     * Каждое свойство представляет собой строку, которая может принимать одно из заданных значений.
     * Количество свойств может быть любым, их порядок не важен.
     * Например, файл может выглядеть следующим образом:
     * <pre>
     * легкое,маленькое,всеядные
     * тяжелое,маленькое,травоядные
     * тяжелое,невысокое,травоядные
     * </pre>
     * При считывании данных все строковые значения свойств конвертируются в нижний регистр.
     * @param path путь к файлу с данными о животных
     * @throws RuntimeException в случае ошибки чтения файла
     * @see Animal
     */
    public void readFile(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Map<String, String> properties = new HashMap<>();
                for (int i = 0; i < parts.length; i++) {
                    String propertyName = "property" + i;
                    String propertyValue = parts[i].trim().toLowerCase();
                    properties.put(propertyName, propertyValue);
                }
                Animal animal = new Animal(properties);
                animals.add(animal);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public String countAnimals() {
        StringBuilder sb = new StringBuilder();
        for (Rule rule : rules) {
            int count = 0;
            for (Animal animal : animals) {
                if (rule.evaluate(animal)) {
                    count++;
                }
            }
            sb.append(rule.toString()).append(": ").append(count).append("\n");
        }
        return sb.toString();
    }
}
