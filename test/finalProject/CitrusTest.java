package finalProject;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CitrusTest {
    Fruit fruit1 = new Fruit("banana", "yellow", 2);
    Fruit fruit2 = new Fruit("orange", "yellow", 1.5);
    Fruit fruit3 = new Fruit("strawberry", "red", 2);
    Fruit fruit4 = new Fruit("watermelon", "green", 3);
    Fruit fruit5 = new Fruit("plum", "black", 1);
    Citrus citrus1 = new Citrus("lemon", "yellow", 1.5);
    Citrus citrus2 = new Citrus("orange", "red", 2);
    Citrus citrus3 = new Citrus("orange", "orange", 1.5);
    Citrus citrus4 = new Citrus("lime", "green", 2);
    Citrus citrus5 = new Citrus("grapefruit", "red", 1.5);

    @Test
    void printCase1() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        citrus1.print();
        assertEquals("Citrus fruit name: LEMON, color: yellow, price: 1.5" + System.lineSeparator(), os.toString());
    }

    @Test
    void printCase2() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        citrus2.print();
        assertEquals("Citrus fruit name: ORANGE, color: red, price: 2.0" + System.lineSeparator(), os.toString());
    }

    @Test
    void printCase3() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        citrus3.print();
        assertEquals("Citrus fruit name: ORANGE, color: orange, price: 1.5" + System.lineSeparator(), os.toString());
    }

    @Test
    void printCase4() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        citrus4.print();
        assertEquals("Citrus fruit name: LIME, color: green, price: 2.0" + System.lineSeparator(), os.toString());
    }

    @Test
    void printCase5() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        citrus5.print();
        assertEquals("Citrus fruit name: GRAPEFRUIT, color: red, price: 1.5" + System.lineSeparator(), os.toString());
    }

    @Test
    void containsCitrus() {
        List<Fruit> noCitrus = List.of(fruit1, fruit2, fruit3, fruit4, fruit5);
        List<Fruit> oneCitrus = List.of(fruit1, fruit2, fruit3, citrus4, fruit5);
        List<Fruit> twoCitrus = List.of(fruit1, citrus2, fruit3, fruit4, citrus5);
        List<Fruit> allCitrus = List.of(citrus1, citrus2, citrus3, citrus4, citrus5);
        assertFalse(Citrus.containsCitrus(noCitrus));
        assertTrue(Citrus.containsCitrus(oneCitrus));
        assertTrue(Citrus.containsCitrus(twoCitrus));
        assertTrue(Citrus.containsCitrus(allCitrus));
        assertFalse(Citrus.containsCitrus(List.of(fruit1, fruit5, new Fruit("apple", "green", 1))));
    }
}