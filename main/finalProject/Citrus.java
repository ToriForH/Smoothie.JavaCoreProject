package finalProject;

import java.io.Serializable;
import java.util.List;

public class Citrus extends Fruit implements Serializable {

    public Citrus(String stringName, String color, double price) {
        super(stringName, color, price);
    }

    public void print() {
        System.out.println("Citrus fruit name: " + this.name + ", color: " + this.color + ", price: " + this.price);
    }

    static boolean containsCitrus(List<Fruit> fruits) {
        for (Fruit fruit: fruits) {
            if (fruit instanceof Citrus) {
                return true;
            }
        }
        return false;
    }
}
