package Homeworks.HW_seminar_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class task_1 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(100));
        }

        System.out.println("Список до удаления четных чисел: " + numbers);

        removeEvenNumbers(numbers);

        if (!numbers.isEmpty()) {
            
            int minValue = findMinValue(numbers);

            int maxValue = findMaxValue(numbers);

            double averageValue = findAverageValue(numbers);

            System.out.println("Список после удаления четных чисел: " + numbers);
            System.out.println("Минимальное значение: " + minValue);
            System.out.println("Максимальное значение: " + maxValue);
            System.out.println("Среднее значение: " + averageValue);
        } else {
            System.out.println("Список пуст.");
        }
    }

    private static double findAverageValue(List<Integer> numbers) {
        return 0;
    }

    public static void removeEvenNumbers(List<Integer> numbers) {
        numbers.removeIf(num -> num % 2 == 0);
    }

    public static int findMinValue(List<Integer> numbers) {
        int minValue = numbers.get(0);
        for (int num : numbers) {
            if (num < minValue) {
                minValue = num;
            }
        }
        return minValue;
    }

    public static int findMaxValue(List<Integer> numbers) {
        int maxValue = numbers.get(0);
        for (int num : numbers) {
            if (num > maxValue) {
                maxValue = num;
            }
        }
        return maxValue;
       
    }
}
