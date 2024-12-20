# Опис програми

## Мета
Ознайомлення з методами класу `CompletableFuture` для виконання асинхронних операцій в Java.

## Завдання
Програма демонструє використання наступних методів класу `CompletableFuture`:
- `runAsync()`
- `supplyAsync()`
- `thenApplyAsync()`
- `thenAcceptAsync()`
- `thenRunAsync()`

Основна мета — реалізувати програму, яка:
1. Генерує послідовність із 20 випадкових натуральних чисел.
2. Формує новий масив із сум мінімальних пар чисел.
3. Виводить початкову послідовність, результуючий масив і час виконання.

## Опис реалізації

### Кроки програми
1. **Генерація чисел**:
   Використовується `supplyAsync()` для асинхронного створення списку з 20 випадкових чисел у діапазоні від 1 до 100.

2. **Обробка даних**:
   За допомогою `thenApplyAsync()` виконується обчислення нового масиву, де кожен елемент — це сума двох найменших чисел із залишкового списку.

3. **Виведення результатів**:
   Застосовується `thenAcceptAsync()` для відображення результуючого масиву на екрані.

4. **Завершення**:
   Метод `thenRunAsync()` використовується для виведення повідомлення про завершення всіх асинхронних операцій.

5. **Обрахунок часу**:
   Обчислюється загальний час виконання програми та виводиться у консоль.

## Очікуваний результат
Програма коректно реалізує усі кроки та демонструє роботу з `CompletableFuture`. Результати виводяться з інформаційними повідомленнями:
- Початкова послідовність чисел.
- Новий масив (суми мінімальних пар).
- Загальний час виконання.

## Приклад виводу
```
[Крок 1] Згенерована послідовність: [23, 45, 12, 67, 34, ...]
[Крок 2] Новий масив (суми мінімальних пар): [35, 57, ...]
[Крок 3] Результуючий масив: [35, 57, ...]
[Крок 4] Усі асинхронні завдання виконані.
[Результат] Загальний час виконання: 123 мс
```


