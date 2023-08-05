package finalProject;
import java.io.Serializable;

public class Fruit implements Serializable {
    protected FruitType name;
    protected String color;
    protected double price;

    public Fruit(String stringName, String color, double price) {
        this.name = FruitType.valueOf(stringName.toUpperCase());
        this.color = color;
        this.price = price;
    }

    public FruitType getName() {
        return name;
    }

    public void setName(String stringName) {
        this.name = FruitType.valueOf(stringName.toUpperCase());
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    static Fruit input() {
        System.out.println("Please, input fruit name");
        String fruitName = InputScanner.inputString().toUpperCase();
        FruitType type;
        while (true) {
            try {
                type = FruitType.valueOf(fruitName);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Sorry, we have not such fruit. " +
                        "\nPlease, choose one of follows: " +
                        "\n" + FruitType.availableFruitTypes());
                fruitName = InputScanner.inputString().toUpperCase();
            }
        }
        String fruitColor;
        if (type.getColors().length > 1) {
            System.out.println("We have several types of this fruit. " +
                    "\nIt differ in color. " +
                    "\nChoose one of follow: " +
                    "\n" + type.availableColors());
            fruitColor = InputScanner.inputString().toLowerCase();
            while (!(type.availableColors()).contains(fruitColor)) {
                System.out.println("Sorry we have not " + fruitName.toLowerCase() + " of " + fruitColor + " color" +
                        "\nPlease, choose one of follow: " +
                        "\n" + type.availableColors());
                fruitColor = InputScanner.inputString().toLowerCase();
            }
        } else {
            fruitColor = type.getColors()[0];
        }
        if (type.isCitrus()) {
            return new Citrus(fruitName, fruitColor, type.getPrice());
        } else {
            return new Fruit(fruitName, fruitColor, type.getPrice());
        }
    }

    public void print() {
        System.out.println("Fruit name: " + this.name + ", color: " + this.color + ", price: " + this.price);
    }

    @Override
    public String toString() {
        if (name.getColors().length > 1) {
            return color + " " + name.name().toLowerCase();
        } else {
            return name.name().toLowerCase();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fruit fruit)) return false;

        if (Double.compare(fruit.getPrice(), getPrice()) != 0) return false;
        if (getName() != null ? !getName().equals(fruit.getName()) : fruit.getName() != null) return false;
        return getColor() != null ? getColor().equals(fruit.getColor()) : fruit.getColor() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getColor() != null ? getColor().hashCode() : 0);
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
