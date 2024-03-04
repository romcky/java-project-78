### Hexlet tests and linter status:
[![Actions Status](https://github.com/romcky/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/romcky/java-project-78/actions)

### Build workflow status:
[![Actions Status](https://github.com/romcky/java-project-78/actions/workflows/build-workflow.yml/badge.svg)](https://github.com/romcky/java-project-78/actions/workflows/build-workflow.yml)

### Codeclimate maintainability:
[![Maintainability](https://api.codeclimate.com/v1/badges/7661ab86808af88c8619/maintainability)](https://codeclimate.com/github/romcky/java-project-78/maintainability)


### Валидатор данных

Валидатор данных - это библиотека, реализующая возможность проверки данных по заданным критериям. Поддерживаются 
проверки для трех типов данных - строк (String), целых чисел (Integer) и ассоциативых массивов (Map).

## Строки:
Создать валидатор для строк: \
var stringSchema = new Validator().string(); \
Задать проверку наличия непустой строки: \
stringSchema.required(); \
Задать проверку минимальной длины: \
stringSchema.minLength(length); \
Задать проверку наличия подстроки: \
stringSchema.contains(substring); \
Применить проверки к нужной строке: \
stringSchema.isValid(string);

## Числа:
Создать валидатор для чисел: \
var numberSchema = new Validator().number(); \
Задать проверку наличия числа: \
numberSchema.required(); \
Задать проверку на положительное число: \
numberSchema.positive(); \
Задать проверку вхождения числа в диапазон: \
numberSchema.range(min, max); \
Применить проверки к нужному числу: \
numberSchema.isValid(number);

## Ассоциативные массивы:
Создать валидатор для ассоциативного массива: \
var mapSchema = new Validator().map(); \
Задать проверку наличия ассоциативного массива: \
mapSchema.required(); \
Задать проверку нужного размера: \
mapSchema.sizeof(size); \
Задать проверку нужных полей нужными валидаторами: \
mapSchema.shape(mapOfSchemas); \
Применить проверки к нужному ассоциативному массиву: \
mapSchema.isValid(map);

