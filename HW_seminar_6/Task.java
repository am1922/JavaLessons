package Homeworks.HW_seminar_6;
// 1. Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.

// 2. Создать множество ноутбуков.

// 3. Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
//    отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:

// “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет …

// 4. Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.

// 5. Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        ArrayList<Notebook> listObject = new ArrayList<>();
        listObject.add(new Notebook("black", "Lenovo", 16, 60000));
        listObject.add(new Notebook("white", "hp", 8, 60000));
        listObject.add(new Notebook("grey", "Mac", 8, 80000));
        listObject.add(new Notebook("black", "dell", 4, 50000));
        listObject.add(new Notebook("red", "dell", 32, 150000));
        listObject.add(new Notebook("grey", "Lenovo", 16, 75000));

        seachVar(listObject, choseParametrs());
    }

    public static void seachVar(ArrayList<Notebook> listObj, Map<String, String> parametrsForSeach) {
        ArrayList<Notebook> result = new ArrayList<>();
        if (parametrsForSeach.isEmpty()) {
            System.out.println("Введите хотя бы один параметр поиска!\n");
            seachVar(listObj, choseParametrs());
        } else {
            var fields = parametrsForSeach.keySet();
            for (Object field : fields) {
                for (Notebook obj : listObj) {
                    if (obj.parametrsMap().get(field.toString()).toString()
                            .equals(parametrsForSeach.get(field.toString()))) {
                        if (!result.contains(obj)) {
                            result.add(obj);
                        }
                    }
                }
            }
            for (Object field : fields) {
                ArrayList<Notebook> temp = new ArrayList<>(result);
                for (Notebook obj : temp) {
                    if (!obj.parametrsMap().get(field.toString()).toString()
                            .equals(parametrsForSeach.get(field.toString()))) {
                        result.remove(obj);
                    }
                }
            }
            if (result.isEmpty()) {
                System.out.println("По вашему запросу ничего не найдено =(");
            } else {
                for (Notebook obj : result) {
                    System.out.println(obj);
                }
            }
        }
    }

    public static Map<String, String> choseParametrs() {
        Map<String, String> parametrs = new HashMap<>();
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите color или оставьте поле пустым:");
        String temp = scan.nextLine();
        if (!temp.equals(""))
            parametrs.put("color", temp.toLowerCase());

        System.out.println("Введите model или оставьте поле пустым:");
        temp = scan.nextLine();
        if (!temp.equals(""))
            parametrs.put("model", temp.toLowerCase());

        System.out.println("Введите ssd или оставьте поле пустым:");
        temp = scan.nextLine();
        if (!temp.equals(""))
            parametrs.put("ssd", temp);

        System.out.println("Введите price или оставьте поле пустым:");
        temp = scan.nextLine();
        if (!temp.equals(""))
            parametrs.put("price", temp);
        scan.close();
        return parametrs;
    }
}
