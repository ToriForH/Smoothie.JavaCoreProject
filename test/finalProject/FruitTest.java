package finalProject;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FruitTest {
    Fruit fruit1 = new Fruit("banana", "yellow", 1.5);
    Fruit fruit2 = new Fruit("pear", "yellow", 1);
    Fruit fruit3 = new Fruit("strawberry", "red", 1.5);
    Fruit fruit4 = new Fruit("watermelon", "red", 2);
    Fruit fruit5 = new Fruit("plum", "black", 1.5);

    //must work for child class Citrus too
    Fruit citrus1 = new Citrus("lemon", "yellow", 1);
    Citrus citrus2 = new Citrus("orange", "red", 1.5);

    //for test setters
    Fruit testSetter1 = new Fruit("apple", "green", 2);
    Fruit testSetter2 = new Fruit("melon", "white", 4);
    Fruit testSetter3 = new Citrus("grapefruit", "red", 3);

    @Test
    void getAndSetColor() {
        assertEquals("yellow", fruit2.getColor());
        assertEquals("red", fruit3.getColor());
        assertEquals("black", fruit5.getColor());
        assertEquals("yellow", citrus1.getColor());
        assertEquals("red", citrus2.getColor());
        testSetter1.setColor("pink");
        testSetter2.setColor(fruit5.getColor()); //black
        testSetter3.setColor(testSetter1.getColor()); //pink
        assertEquals("pink", testSetter1.getColor());
        assertEquals("black", testSetter2.getColor());
        assertEquals("pink", testSetter3.getColor());
        testSetter1.setColor("blue");
        assertEquals("blue", testSetter1.getColor());
    }

    @Test
    void getAndSetPrice() {
        assertEquals(1.5, fruit1.getPrice());
        assertEquals(1, fruit2.getPrice());
        assertEquals(2, fruit4.getPrice());
        assertEquals(1, citrus1.getPrice());
        assertEquals(1.5, citrus2.getPrice());
        testSetter1.setPrice(4);
        testSetter2.setPrice(fruit4.getPrice());  //2
        testSetter3.setPrice(testSetter2.getPrice());  //2
        assertEquals(4, testSetter1.getPrice());
        assertEquals(fruit4.getPrice(), testSetter2.getPrice());
        assertEquals(2, testSetter3.getPrice());
        testSetter1.setPrice(2.5);
        assertEquals(2.5, testSetter1.getPrice());
    }

    @Test
    void printCase1() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        fruit1.print();
        assertEquals("Fruit name: BANANA, color: yellow, price: 1.5" + System.lineSeparator(), os.toString());
    }

    @Test
    void printCase2() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        fruit2.print();
        assertEquals("Fruit name: PEAR, color: yellow, price: 1.0" + System.lineSeparator(), os.toString());
    }

    @Test
    void printCase3() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        fruit3.print();
        assertEquals("Fruit name: STRAWBERRY, color: red, price: 1.5" + System.lineSeparator(), os.toString());
    }

    @Test
    void printCase4() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        fruit4.print();
        assertEquals("Fruit name: WATERMELON, color: red, price: 2.0" + System.lineSeparator(), os.toString());
    }

    @Test
    void printCase5() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        fruit5.print();
        assertEquals("Fruit name: PLUM, color: black, price: 1.5" + System.lineSeparator(), os.toString());
    }

    @Test
    void printFruitCaseCitrus() {
        ByteArrayOutputStream os1 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os1));
        citrus1.print();
        assertEquals("Citrus fruit name: LEMON, color: yellow, price: 1.0" + System.lineSeparator(), os1.toString());
        ByteArrayOutputStream os2 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os2));
        citrus2.print();
        assertEquals("Citrus fruit name: ORANGE, color: red, price: 1.5" + System.lineSeparator(), os2.toString());
    }

    @Test
    void testToString() {
        assertEquals("yellow banana", fruit1.toString());
        assertEquals("yellow pear", fruit2.toString());
        assertEquals("strawberry", fruit3.toString());
        assertEquals("red watermelon", fruit4.toString());
        assertEquals("black plum", fruit5.toString());
        assertEquals("lemon", citrus1.toString());
        assertEquals("red orange", citrus2.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        Fruit fr1 = new Fruit("banana", "yellow", 1.5);
        Fruit fr2 = new Fruit("pear", "yellow", 1);
        Fruit fr3 = new Fruit("strawberry", "red", 1.5);
        Fruit fr4 = new Fruit("watermelon", "red", 2);
        Fruit fr5 = new Fruit("plum", "black", 1.5);

        //must work for child class Citrus too
        Fruit c1 = new Citrus("lemon", "yellow", 1);
        Citrus c2 = new Citrus("orange", "red", 1.5);
        assertEquals(fr1.hashCode(), fruit1.hashCode());
        assertEquals(fr1, fruit1);
        assertEquals(fr2.hashCode(), fruit2.hashCode());
        assertEquals(fr2, fruit2);
        assertEquals(fr3.hashCode(), fruit3.hashCode());
        assertEquals(fr3, fruit3);
        assertEquals(fr4.hashCode(), fruit4.hashCode());
        assertEquals(fr4, fruit4);
        assertEquals(fr5.hashCode(), fruit5.hashCode());
        assertEquals(fr5, fruit5);
        assertEquals(c1.hashCode(), citrus1.hashCode());
        assertEquals(c1, citrus1);
        assertEquals(c2.hashCode(), citrus2.hashCode());
        assertEquals(c2, citrus2);
    }
}