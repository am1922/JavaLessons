package Homeworks.HW_seminar_2.task_4;

// Реализовать простой калькулятор
// Добавить логирование

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             FileWriter logFile = new FileWriter("Homeworks/HW_seminar_2/task_4/log.txt", true);
             BufferedWriter writer = new BufferedWriter(logFile)) {
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
                    logOperation(writer, "+", num1, num2, result);
                    break;
                case 2:
                    result = num1 - num2;
                    logOperation(writer, "-", num1, num2, result);
                    break;
                case 3:
                    result = num1 * num2;
                    logOperation(writer, "*", num1, num2, result);
                    break;
                case 4:
                    if (num2 == 0) {
                        System.out.println("Ошибка: деление на ноль.");
                        logError(writer, "Ошибка: деление на ноль");
                        return;
                    }
                    result = num1 / num2;
                    logOperation(writer, "/", num1, num2, result);
                    break;
                default:
                    System.out.println("Недопустимый выбор операции.");
                    logError(writer, "Недопустимый выбор операции");
                    return;
            }
            
            System.out.println("Результат: " + result);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void logOperation(BufferedWriter writer, String operation, double num1, double num2, double result) throws IOException {
        String timestamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
        writer.write(timestamp + " - " + num1 + " " + operation + " " + num2 + " = " + result + "\n");
    }
    
    private static void logError(BufferedWriter writer, String error) throws IOException {
        String timestamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
        writer.write(timestamp + " - " + error + "\n");
    }
}
