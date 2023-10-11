// Реализовать простой калькулятор

package Homeworks;

import java.util.Scanner;

public class task_3 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите первое число: ");
            double num1 = scanner.nextDouble();
            
            System.out.print("Введите второе число: ");
            double num2 = scanner.nextDouble();
            
            System.out.println("Выберите операцию:");
            System.out.println("1. Сложение");
            System.out.println("2. Вычитание");
            System.out.println("3. Умножение");
            System.out.println("4. Деление");
            
            int choice = scanner.nextInt();
            
            double result = 0.0;

            switch (choice) {
                case 1:
                    result = num1 + num2;
                    break;
                case 2:
                    result = num1 - num2;
                    break;
                case 3:
                    result = num1 * num2;
                    break;
                case 4:
                    if (num2 == 0) {
                        System.out.println("Ошибка: деление на ноль.");
                        return;
                    }
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("Недопустимый выбор операции.");
                    return;
            }
            
            System.out.println("Результат: " + result);
        }
    }
}
