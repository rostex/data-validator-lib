### Статус кода:
[![Actions Status](https://github.com/rostex/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/rostex/java-project-78/actions)
[![rostex check](https://github.com/rostex/java-project-78/actions/workflows/main.yml/badge.svg)](https://github.com/rostex/java-project-78/actions/workflows/main.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/b1079416027acb70e369/maintainability)](https://codeclimate.com/github/rostex/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/b1079416027acb70e369/test_coverage)](https://codeclimate.com/github/rostex/java-project-78/test_coverage)

## Валидатор данных
Валидатор данных – библиотека, которая помогает проверять правильность данных. Она предлагает простые правила для проверки, что делает интеграцию в проекты легкой и удобной. Библиотека поддерживает разные форматы и типы данных. При необходимости структра библиотеки позволяет добавлять собственные условия для проверки.

### Пример использования: 
```
Validator v = new Validator();

// Строки
StringSchema schema = v.string().required();

schema.isValid("what does the fox say"); // true
schema.isValid(""); // false

// Числа
NumberSchema schema = v.number().required().positive();

schema.isValid(-10); // false
schema.isValid(10); // true

// Объект Map с поддержкой проверки структуры
Map<String, BaseSchema<String>> schemas = new HashMap<>();
schemas.put("firstName", v.string().required());
schemas.put("lastName", v.string().required().minLength(2));

MapSchema schema = v.map().sizeof(2).shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("firstName", "John");
human1.put("lastName", "Smith");
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("firstName", "Anna");
human2.put("lastName", "B");
schema.isValid(human2); // false
```
