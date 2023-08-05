package finalProject;

import java.io.*;
import java.util.*;

public class Smoothie implements Serializable {
    Fruit[] fruits;
    Milk milk;

    public Smoothie(Fruit[] fruits, Milk milk) {
        this.fruits = fruits;
        this.milk = milk;
    }

    public double cost() {
        double result = Arrays.stream(fruits).map(Fruit::getPrice).reduce((double) 0, Double::sum);
        if(milk != null) {
            result+= milk.getPrice();
        }
        return result;
    }

    static Smoothie input() {
        System.out.println("Choose fruits which you want to put to your smoothie");
        List<Fruit> fruitsList = new ArrayList<>();
        boolean addMoreFruit = true;
        int countFruits = 0;
        while (addMoreFruit && countFruits < 5) {
            fruitsList.add(Fruit.input());
            countFruits++;
            System.out.println("Do you want to add one more fruit?");
            addMoreFruit = InputScanner.isAnswerYes();
        }
        Fruit[] fruitsForSmoothie = fruitsList.toArray(Fruit[]::new);
        if (addMoreFruit) {
            System.out.println("Sorry, can contain no more than 5 fruits. " +
                    "\nDo you want to replace one of added?");
            boolean replaceFruit = InputScanner.isAnswerYes();
            while (replaceFruit) {
                System.out.println("Fruits you already added: ");
                for (int i = 0; i < fruitsForSmoothie.length; i++) {
                    System.out.println((i + 1) + ". " + fruitsForSmoothie[i]);
                }
                System.out.println("Write a number of fruit you want to be replaced: ");
                int toReplace = InputScanner.inputInt();
                while (toReplace < 1 || toReplace > 5) {
                    System.out.println("Number should be in range 1-5");
                    toReplace = InputScanner.inputInt();
                }
                fruitsForSmoothie[toReplace - 1] = Fruit.input();
                System.out.println("Do you want to replace one more fruit?");
                replaceFruit = InputScanner.isAnswerYes();
            }
        }
        Milk milkForSmoothie = null;
        if (!Citrus.containsCitrus(Arrays.asList(fruitsForSmoothie))) {
            System.out.println("You need to add some milk to your smoothie");
            milkForSmoothie = Milk.input();
        } else {
            System.out.println("Do you want to add some plant milk to your smoothie?");
            if (InputScanner.isAnswerYes()) {
                milkForSmoothie = Milk.inputPlant();
            }
        }
        return new Smoothie(fruitsForSmoothie, milkForSmoothie);
    }

    public void print() {
        System.out.println("Smoothie{ \nFruits: ");
        Arrays.stream(this.fruits).forEach(Fruit::print);
        if (milk != null) {
            System.out.println("Milk: " + this.milk.name() + "}");
        } else {
            System.out.println("Milk: null}");
        }
    }

    public void payForSmoothie() {
        System.out.println("It is " + this.cost() + "$" +
                "\nInput sum you give");
        double payment = InputScanner.inputDouble();
        while (payment < this.cost()) {
            double neededMore = this.cost() - payment;
            System.out.println("It is not enough." +
                    "\nPlease, input at least " + neededMore + "$ more");
            payment+= InputScanner.inputDouble();
        }
        System.out.println("Thank you!");
        if (payment > this.cost()) {
            System.out.println("Here is your change " + (payment - this.cost()) + "$");
        }
    }

    @Override
    public String toString() {
        StringBuilder smoothie = new StringBuilder("smoothie with ");
        String[] fruitsArray = Arrays.stream(fruits).map(Fruit::toString).toArray(String[]::new);
        String fruitsInSmoothie = String.join(", ", fruitsArray);
        smoothie.append(fruitsInSmoothie);
        if (milk != null) {
            smoothie.append(" and ").append(milk);
        }
        return smoothie.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Smoothie smoothie)) return false;
        Comparator<Fruit> comparator = new Comparator<Fruit>() {
            @Override
            public int compare(Fruit f1, Fruit f2) {
                if((f1.getName()).equals(f2.getName())) {
                    if ((f1.getColor()).equals(f2.getColor())) {
                        if (f1.getPrice() == f2.getPrice()) {
                            return 0;
                        }
                        return f1.getPrice() > f2.getPrice() ? 1 : -1;
                    } return (f1.getColor()).compareTo(f2.getColor());
                } else {
                    return f1.getName().compareTo(f2.getName());
                }
            }
        };
        Arrays.sort(this.fruits, comparator);
        Arrays.sort(((Smoothie) o).fruits, comparator);
        if (!Arrays.equals(fruits, smoothie.fruits)) return false;
        return milk == smoothie.milk;
    }

    @Override
    public int hashCode() {
        int result = fruits != null ? Arrays.hashCode(fruits) : 0;
        result = 31 * result + (milk != null ? milk.hashCode() : 0);
        return result;
    }

    public static void saveToFile(File file, List<Smoothie> smoothiesList) {
        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(file))){
            if (smoothiesList != null) {
                ous.writeObject(smoothiesList);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Smoothie was not saved correctly");
        }
    }
    public static void readFromFileAndWrite(File file) {
        List<Smoothie> history = new ArrayList<>();
        if (file.exists()){
            try (FileInputStream fis = new FileInputStream(file);
                 ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                if (fis.available() != 0) {
                    history = (List<Smoothie>) ois.readObject();
                }
                if (history.size() > 0) {
                    System.out.println("Saved smoothie history: ");
                    history.forEach(System.out::println);
                } else {
                    System.out.println("Smoothie was not made");
                }
            } catch (IOException | ClassNotFoundException | ClassCastException e) {
                System.out.println("File can not be read");
            }
        } else {
            System.out.println("File is not exist");
        }
    }
    public static List<Smoothie> readFromFile(File file) {
        List<Smoothie> history = new ArrayList<>();
        if (file.exists()){
            try (FileInputStream fis = new FileInputStream(file);
                 ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                if (fis.available() != 0) {
                    history = (List<Smoothie>) ois.readObject();
                }
            } catch (IOException | ClassNotFoundException | ClassCastException e) {
                history = null;
            }
        } else {
            history = null;
        }
        return history;
    }
}
