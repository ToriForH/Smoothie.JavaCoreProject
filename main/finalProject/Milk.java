package finalProject;

import java.util.Scanner;

public enum Milk {
    //regular milk should be written first to appropriate implementations of availablePlantMilk() method
    REGULAR(1), HAZELNUT(2), COCONUT(2), ALMOND(2), RISE(1.5), OAT(1.5), SOY(2);
    private double price;

    Milk(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    static Milk input(){
        System.out.println("Do you want add regular or plant milk?");
        String milkType = InputScanner.inputString();
        while (true) {
            if (milkType.equalsIgnoreCase("regular")) {
                return Milk.valueOf("REGULAR");
            } else if (milkType.equalsIgnoreCase("plant")) {
                return inputPlant();
            } else {
                System.out.println("Please, write correct answer(regular/plant). " +
                        "\nDo you want add regular or plant milk?");
                milkType = InputScanner.inputString();
            }
        }
    }

    public static Milk inputPlant() {
        System.out.println("We have follow variant of plant milk: " +
                "\n" + availablePlantMilk() +
                "\nChoose one of them");
        String milkType = InputScanner.inputString();
        while (true) {
            try {
                Milk milk = Milk.valueOf(milkType.toUpperCase());
                if (milk.isRegular()) {
                    System.out.println("Sorry, you can choose only plant milk" +
                            "\nPlease, choose one of follow:" +
                            "\n" + availablePlantMilk());
                    milkType = InputScanner.inputString();
                    continue;
                }
                return milk;
            } catch (IllegalArgumentException e) {
                System.out.println("Sorry, we have not " + milkType.toLowerCase() + " plant milk" +
                        "\nPlease, choose one of follow:" +
                        "\n" + availablePlantMilk());
                milkType = InputScanner.inputString();
            }
        }
    }

    public void print() {
        System.out.println("Milk: " + this.name().toLowerCase() + ", price: " + this.price);
    }

    @Override
    public String toString() {
        return this.name().toLowerCase() + " milk";
    }

    public static String availablePlantMilk() {
        Milk[] availableMilk = Milk.values();
        String[] milks = new String[availableMilk.length - 1];
        for (int i = 0; i < milks.length; i++) {
            milks[i] = availableMilk[i + 1].name().toLowerCase();
        }
        return String.join(", ", milks);
    }

    public boolean isRegular() {
        return this.equals(Milk.REGULAR);
    }
}
