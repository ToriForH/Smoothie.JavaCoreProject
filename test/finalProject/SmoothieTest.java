package finalProject;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class SmoothieTest {
    Fruit[] fruits1 = new Fruit[] {new Fruit("banana", "yellow", 1.5),
            new Fruit("strawberry", "red", 1.5),
            new Fruit("plum", "black", 1.5),
            new Citrus("orange", "red", 1.5),
            new Fruit("dragonfruit", "pink", 2.5)};
    Fruit[] fruits2 = new Fruit[] {new Fruit("melon", "yellow", 2),
            new Fruit("cherry", "red", 2),
            new Fruit("blueberry", "blue", 2),
            new Fruit("banana", "red", 1.5),
            new Fruit("kiwi", "green", 1.5)};
    Fruit[] fruits3 = new Fruit[] {new Fruit("apple", "green", 1),
            new Fruit("mango", "orange", 2),
            new Fruit("watermelon", "red", 2),
            new Fruit("peach", "orange", 1.5),
            new Fruit("grape", "white", 1.5)};
    Fruit[] fruits4 = new Fruit[] {new Fruit("apricot", "orange", 1.5),
            new Citrus("grapefruit", "red", 1.5),
            new Citrus("lemon", "yellow", 1),
            new Citrus("lime", "green", 1),
            new Fruit("papaya", "orange", 2.5)};
    Fruit[] fruits5 = new Fruit[] {new Fruit("pear", "yellow", 1),
            new Fruit("strawberry", "red", 1.5),
            new Fruit("pineapple", "yellow", 2),
            new Citrus("orange", "red", 1.5),
            new Fruit("kiwi", "yellow", 1.5)};
    Smoothie smoothie1 = new Smoothie(fruits1, Milk.ALMOND); //cost 10.5
    Smoothie smoothie2 = new Smoothie(fruits2, Milk.REGULAR); //cost 10
    Smoothie smoothie3 = new Smoothie(fruits3, Milk.SOY); //cost 10
    Smoothie smoothie4 = new Smoothie(fruits4, Milk.RISE); //cost 9
    Smoothie smoothie5 = new Smoothie(fruits5, null); //cost 7.5

    @Test
    void cost() {
        assertEquals(10.5, smoothie1.cost());
        assertEquals(10, smoothie2.cost());
        assertEquals(10, smoothie3.cost());
        assertEquals(9, smoothie4.cost());
        assertEquals(7.5, smoothie5.cost());
    }

    @Test
    void printCase1() {
        String test = "Smoothie{ " +
                "\nFruits: " + System.lineSeparator() +
                "Fruit name: BANANA, color: yellow, price: 1.5" + System.lineSeparator() +
                "Fruit name: STRAWBERRY, color: red, price: 1.5" + System.lineSeparator() +
                "Fruit name: PLUM, color: black, price: 1.5" + System.lineSeparator() +
                "Citrus fruit name: ORANGE, color: red, price: 1.5" + System.lineSeparator() +
                "Fruit name: DRAGONFRUIT, color: pink, price: 2.5" + System.lineSeparator() +
                "Milk: ALMOND}" + System.lineSeparator();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        smoothie1.print();
        assertEquals(test, os.toString());
    }

    @Test
    void printCase2() {
        String test = "Smoothie{ " +
                "\nFruits: " + System.lineSeparator() +
                "Fruit name: MELON, color: yellow, price: 2.0" + System.lineSeparator() +
                "Fruit name: CHERRY, color: red, price: 2.0" + System.lineSeparator() +
                "Fruit name: BLUEBERRY, color: blue, price: 2.0" + System.lineSeparator() +
                "Fruit name: BANANA, color: red, price: 1.5" + System.lineSeparator() +
                "Fruit name: KIWI, color: green, price: 1.5" + System.lineSeparator() +
                "Milk: REGULAR}" + System.lineSeparator();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        smoothie2.print();
        assertEquals(test, os.toString());
    }

    @Test
    void printCase3() {
        String test = "Smoothie{ " +
                "\nFruits: " + System.lineSeparator() +
                "Fruit name: APPLE, color: green, price: 1.0" + System.lineSeparator() +
                "Fruit name: MANGO, color: orange, price: 2.0" + System.lineSeparator() +
                "Fruit name: WATERMELON, color: red, price: 2.0" + System.lineSeparator() +
                "Fruit name: PEACH, color: orange, price: 1.5" + System.lineSeparator() +
                "Fruit name: GRAPE, color: white, price: 1.5" + System.lineSeparator() +
                "Milk: SOY}" + System.lineSeparator();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        smoothie3.print();
        assertEquals(test, os.toString());
    }

    @Test
    void printCase4() {
        String test = "Smoothie{ " +
                "\nFruits: " + System.lineSeparator() +
                "Fruit name: APRICOT, color: orange, price: 1.5" + System.lineSeparator() +
                "Citrus fruit name: GRAPEFRUIT, color: red, price: 1.5" + System.lineSeparator() +
                "Citrus fruit name: LEMON, color: yellow, price: 1.0" + System.lineSeparator() +
                "Citrus fruit name: LIME, color: green, price: 1.0" + System.lineSeparator() +
                "Fruit name: PAPAYA, color: orange, price: 2.5" + System.lineSeparator() +
                "Milk: RISE}" +  System.lineSeparator();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        smoothie4.print();
        assertEquals(test, os.toString());
    }

    @Test
    void printCase5() {
        String test = "Smoothie{ " +
                "\nFruits: " + System.lineSeparator() +
                "Fruit name: PEAR, color: yellow, price: 1.0" + System.lineSeparator() +
                "Fruit name: STRAWBERRY, color: red, price: 1.5" + System.lineSeparator() +
                "Fruit name: PINEAPPLE, color: yellow, price: 2.0" + System.lineSeparator() +
                "Citrus fruit name: ORANGE, color: red, price: 1.5" + System.lineSeparator() +
                "Fruit name: KIWI, color: yellow, price: 1.5" + System.lineSeparator() +
                "Milk: null}" + System.lineSeparator();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        smoothie5.print();
        assertEquals(test, os.toString());
    }

    @Test
    void testToString() {
        String sm1 = "smoothie with yellow banana, strawberry, black plum, red orange, pink dragonfruit and almond milk";
        String sm2 = "smoothie with melon, cherry, blueberry, red banana, green kiwi and regular milk";
        String sm3 = "smoothie with green apple, mango, red watermelon, peach, white grape and soy milk";
        String sm4 = "smoothie with apricot, grapefruit, lemon, lime, papaya and rise milk";
        String sm5 = "smoothie with yellow pear, strawberry, pineapple, red orange, yellow kiwi";
        assertEquals(sm1, smoothie1.toString());
        assertEquals(sm2, smoothie2.toString());
        assertEquals(sm3, smoothie3.toString());
        assertEquals(sm4, smoothie4.toString());
        assertEquals(sm5, smoothie5.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        Fruit[] fr1 = new Fruit[] {new Fruit("banana", "yellow", 1.5),
                new Fruit("strawberry", "red", 1.5),
                new Fruit("plum", "black", 1.5),
                new Citrus("orange", "red", 1.5),
                new Fruit("dragonfruit", "pink", 2.5)};
        Fruit[] fr2 = new Fruit[] {new Fruit("melon", "yellow", 2),
                new Fruit("cherry", "red", 2),
                new Fruit("blueberry", "blue", 2),
                new Fruit("banana", "red", 1.5),
                new Fruit("kiwi", "green", 1.5)};
        Fruit[] fr3 = new Fruit[] {new Fruit("apple", "green", 1),
                new Fruit("mango", "orange", 2),
                new Fruit("watermelon", "red", 2),
                new Fruit("peach", "orange", 1.5),
                new Fruit("grape", "white", 1.5)};
        Fruit[] fr4 = new Fruit[] {new Fruit("apricot", "orange", 1.5),
                new Citrus("grapefruit", "red", 1.5),
                new Citrus("lemon", "yellow", 1),
                new Citrus("lime", "green", 1),
                new Fruit("papaya", "orange", 2.5)};
        //work with differ order of same fruits
        Fruit[] fr5 = new Fruit[] {new Citrus("orange", "red", 1.5),
                new Fruit("pear", "yellow", 1),
                new Fruit("strawberry", "red", 1.5),
                new Fruit("kiwi", "yellow", 1.5),
                new Fruit("pineapple", "yellow", 2)};
        Smoothie sm1 = new Smoothie(fruits1, Milk.ALMOND);
        Smoothie sm2 = new Smoothie(fruits2, Milk.REGULAR);
        Smoothie sm3 = new Smoothie(fruits3, Milk.SOY);
        Smoothie sm4 = new Smoothie(fruits4, Milk.RISE);
        Smoothie sm5 = new Smoothie(fruits5, null);
        assertEquals(sm1.hashCode(), smoothie1.hashCode());
        assertEquals(sm1, smoothie1);
        assertEquals(sm2.hashCode(), smoothie2.hashCode());
        assertEquals(sm2, smoothie2);
        assertEquals(sm3.hashCode(), smoothie3.hashCode());
        assertEquals(sm3, smoothie3);
        assertEquals(sm4.hashCode(), smoothie4.hashCode());
        assertEquals(sm4, smoothie4);
        assertEquals(sm5.hashCode(), smoothie5.hashCode());
        assertEquals(sm5, smoothie5);
    }

    @Test
    void saveAndReadFile() {
        List<Smoothie> smoothieList = List.of(smoothie1, smoothie2, smoothie3, smoothie4, smoothie5);
        List<Smoothie> noSmoothies = new ArrayList<>();
        List<Smoothie> nullList = null;
        String currentPath = new File("").getAbsolutePath();
        File test1 = new File(currentPath, "\\main\\finalProject\\smoothieHistory\\testfile1.xml");
        File test2 = new File(currentPath, "\\main\\finalProject\\smoothieHistory\\testfile2.xml");
        File test3 = new File(currentPath, "\\main\\finalProject\\smoothieHistory\\testfile3.xml");
        File test4 = new File(currentPath, "\\main\\finalProject\\smoothieHistory\\testfile4.xml");
        try {
            Files.createFile(test4.toPath());
        } catch (IOException e) {
            assertTrue(test4.exists());
            System.out.println("Error in test");
        }
        Smoothie.saveToFile(test1, smoothieList);
        Smoothie.saveToFile(test2, noSmoothies);
        Smoothie.saveToFile(test3, nullList);
        assertEquals(smoothieList, Smoothie.readFromFile(test1));
        assertEquals(noSmoothies, Smoothie.readFromFile(test2));
        assertNull(Smoothie.readFromFile(test3));
        assertNull(Smoothie.readFromFile(test4));
        Path p = Path.of(currentPath, "\\main\\finalProject\\smoothieHistory\\fileNotExist.xml");
        assertNull(Smoothie.readFromFile(p.toFile()));
    }

    @Test
    void saveAndReadFromFileAndWriteSimpleCase() {
        List<Smoothie> smoothieList = List.of(smoothie1, smoothie2, smoothie3, smoothie4, smoothie5);
        String currentPath = new File("").getAbsolutePath();
        File test1 = new File(currentPath, "\\main\\finalProject\\smoothieHistory\\testfile1.xml");
        Smoothie.saveToFile(test1, smoothieList);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        Smoothie.readFromFileAndWrite(test1);
        String result = "Saved smoothie history: " + System.lineSeparator()
                + "smoothie with yellow banana, strawberry, black plum, red orange, pink dragonfruit and almond milk" + System.lineSeparator()
                + "smoothie with melon, cherry, blueberry, red banana, green kiwi and regular milk" + System.lineSeparator()
                + "smoothie with green apple, mango, red watermelon, peach, white grape and soy milk" + System.lineSeparator()
                + "smoothie with apricot, grapefruit, lemon, lime, papaya and rise milk" + System.lineSeparator()
                + "smoothie with yellow pear, strawberry, pineapple, red orange, yellow kiwi" + System.lineSeparator();
        assertEquals(result, os.toString());
    }

    @Test
    void saveAndReadFromFileAndWriteEmptyListCase() {
        List<Smoothie> noSmoothies = new ArrayList<>();
        String currentPath = new File("").getAbsolutePath();
        File test2 = new File(currentPath, "\\main\\finalProject\\smoothieHistory\\testfile2.xml");
        Smoothie.saveToFile(test2, noSmoothies);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        Smoothie.readFromFileAndWrite(test2);
        String result = "Smoothie was not made" + System.lineSeparator();
        assertEquals(result, os.toString());
    }

    @Test
    void saveAndReadFromFileAndWriteNullListCase() {
        List<Smoothie> nullList = null;
        String currentPath = new File("").getAbsolutePath();
        File test3 = new File(currentPath, "\\main\\finalProject\\smoothieHistory\\testfile3.xml");
        Smoothie.saveToFile(test3, nullList);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        Smoothie.readFromFileAndWrite(test3);
        String result = "File can not be read" + System.lineSeparator();
        assertEquals(result, os.toString());
    }

    @Test
    void saveAndReadFromFileAndWriteEmptyFile() {
        String currentPath = new File("").getAbsolutePath();
        File test4 = new File(currentPath, "\\main\\finalProject\\smoothieHistory\\testfile4.xml");
        if (!test4.exists()) {
            try {
                Files.createFile(test4.toPath());
            } catch (IOException e) {
                assertTrue(test4.exists());
                System.out.println("Error in test");
            }
        }
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        Smoothie.readFromFileAndWrite(test4);
        String result = "File can not be read" + System.lineSeparator();
        assertEquals(result, os.toString());
    }

    @Test
    void saveAndReadFromFileAndWriteFileNotExist() {
        String currentPath = new File("").getAbsolutePath();
        Path p = Path.of(currentPath, "\\main\\finalProject\\smoothieHistory\\fileNotExist.xml");
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        Smoothie.readFromFileAndWrite(p.toFile());
        String result = "File is not exist" + System.lineSeparator();
        assertEquals(result, os.toString());
    }
    @AfterAll
    static void setOutput() {
        System.setOut(System.out);
    }
}