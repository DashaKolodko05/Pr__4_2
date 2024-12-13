import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo {

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        // Крок 1: Генерація випадкової послідовності натуральних чисел
        CompletableFuture<List<Integer>> generateSequence = CompletableFuture.supplyAsync(() -> {
            List<Integer> numbers = new ArrayList<>();
            Random random = new Random();
            for (int i = 0; i < 20; i++) {
                numbers.add(random.nextInt(100) + 1); // Генеруємо числа від 1 до 100
            }
            System.out.println("[Крок 1] Згенерована послідовність: " + numbers);
            return numbers;
        });

        // Крок 2: Формування нового масиву з сум мінімальних пар елементів
        CompletableFuture<List<Integer>> calculateReducedArray = generateSequence.thenApplyAsync(numbers -> {
            List<Integer> reducedArray = new ArrayList<>();
            List<Integer> tempNumbers = new ArrayList<>(numbers);

            System.out.println("[Крок 2] Початок обчислення нового масиву...");
            while (tempNumbers.size() > 1) {
                int min1 = tempNumbers.stream().min(Integer::compare).orElseThrow();
                tempNumbers.remove((Integer) min1);
                int min2 = tempNumbers.stream().min(Integer::compare).orElseThrow();
                tempNumbers.remove((Integer) min2);

                reducedArray.add(min1 + min2);
            }

            System.out.println("[Крок 2] Новий масив (суми мінімальних пар): " + reducedArray);
            return reducedArray;
        });

        // Крок 3: Виведення результату з повідомленням
        CompletableFuture<Void> displayResult = calculateReducedArray.thenAcceptAsync(reducedArray -> {
            System.out.println("[Крок 3] Результуючий масив: " + reducedArray);
        });

        // Крок 4: Завершення усіх завдань
        CompletableFuture<Void> finalTask = displayResult.thenRunAsync(() -> {
            System.out.println("[Крок 4] Усі асинхронні завдання виконані.");
        });

        // Очікування завершення всіх завдань
        try {
            finalTask.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();
        System.out.println("[Результат] Загальний час виконання: " + TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + " мс");
    }
}
