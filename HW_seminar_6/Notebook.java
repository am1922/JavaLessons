package Homeworks.HW_seminar_6;



import java.util.HashMap;
import java.util.Map;

public class Notebook {
    String color;
    String model;
    int ssd;
    int price;

    public Notebook(String color, String model, int ssd, int price) {
        this.color = color.toLowerCase();
        this.model = model.toLowerCase();
        this.ssd = ssd;
        this.price = price;
    }

    @Override
    public String toString() {
        return color + ", " + model + ", " + ssd + ", " + price;
    }

    public  Map<Object,Object> parametrsMap() {
        Map<Object,Object> parametrsNotebook = new HashMap<>();
        parametrsNotebook.put("color", color);
        parametrsNotebook.put("model", model);
        parametrsNotebook.put("ssd", ssd);
        parametrsNotebook.put("price", price);
        return parametrsNotebook;
    }

}
