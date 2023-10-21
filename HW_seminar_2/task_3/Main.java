// 3.** Дана json строка (можно сохранить в файл и читать из файла)
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4",
// "предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: 
// Студент [фамилия] получил [оценка] по предмету [предмет].

// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

package Homeworks.HW_seminar_2.task_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filePath = "Homeworks/HW_seminar_2/task_3/statement.json";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder jsonStringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonStringBuilder.append(line);
            }

            String jsonString = jsonStringBuilder.toString();
            jsonString = jsonString.substring(1, jsonString.length() - 1);

            String[] studentData = jsonString.split("},");

            for (String data : studentData) {
                data = data.replaceAll("[{}\"]", "");

                String[] parts = data.split(",");
                String фамилия = null;
                String оценка = null;
                String предмет = null;

                for (String part : parts) {
                    String[] keyValue = part.split(":");
                    if (keyValue.length == 2) {
                        String key = keyValue[0].trim().replaceAll("\"", "");
                        String value = keyValue[1].trim().replaceAll("\"", "");

                        if ("фамилия".equals(key)) {
                            фамилия = value;
                        } else if ("оценка".equals(key)) {
                            оценка = value;
                        } else if ("предмет".equals(key)) {
                            предмет = value;
                        }
                    }
                }

                String studentString = "Студент " + фамилия + " получил " + оценка + " по предмету " + предмет + ".";
                System.out.println(studentString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
