package finalProject;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

//test does not work correctly since there are 3 different scanner used

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SmoothieInputTest {
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
    Smoothie smoothie1 = new Smoothie(fruits1, Milk.ALMOND);
    Smoothie smoothie2 = new Smoothie(fruits2, Milk.REGULAR);
    Smoothie smoothie3 = new Smoothie(fruits3, Milk.SOY);
    Smoothie smoothie4 = new Smoothie(fruits4, Milk.RISE);
    Smoothie smoothie5 = new Smoothie(fruits5, null);
    static ByteArrayInputStream input = new ByteArrayInputStream(("banana" + System.lineSeparator()
            + "yellow" + System.lineSeparator() + "yes" + System.lineSeparator()
            + "strawberry" + System.lineSeparator() + "yes" + System.lineSeparator()
            + "plum" + System.lineSeparator() + "black" + System.lineSeparator() + "yes" + System.lineSeparator()
            + "orange" + System.lineSeparator() + "red" + System.lineSeparator() + "yes" + System.lineSeparator()
            + "dragonfruit" + System.lineSeparator()
            + "pink" + System.lineSeparator() + "no" + System.lineSeparator() //added fruits case1
            + "yes" + System.lineSeparator() + "almond" + System.lineSeparator() //added milk case1
            + "melon" + System.lineSeparator() + "yes" + System.lineSeparator()
            + "lemon" + System.lineSeparator() + "yes" + System.lineSeparator()
            + "blueberry" + System.lineSeparator() + "yes" + System.lineSeparator()
            + "banana" + System.lineSeparator() + "red" + System.lineSeparator() + "yes" + System.lineSeparator()
            + "kiwi" + System.lineSeparator() + "green" + System.lineSeparator() + "yes" + System.lineSeparator() //added fruits case2
            + "yes" + System.lineSeparator() + "2" + System.lineSeparator()
            + "cherry" + System.lineSeparator() + "no" + System.lineSeparator() //replace one fruit
            + "regular" + System.lineSeparator() //added milk case2
            + "apple" + System.lineSeparator() + "green" + System.lineSeparator() + "yes" + System.lineSeparator()
            + "mango" + System.lineSeparator() + "yes" + System.lineSeparator()
            + "watermelon" + System.lineSeparator() + "red" + System.lineSeparator() + "yes" + System.lineSeparator()
            + "banana" + System.lineSeparator() + "red" + System.lineSeparator() + "yes" + System.lineSeparator()
            + "grape" + System.lineSeparator() + "white" + System.lineSeparator() + "yes" + System.lineSeparator() //added fruits case3
            + "yes" + System.lineSeparator() + "-2" + System.lineSeparator() + "4" + System.lineSeparator()
            + "peach" + System.lineSeparator() + "no" + System.lineSeparator() //replace one fruit first input out of range
            + "plant" + System.lineSeparator() + "soy" + System.lineSeparator() //added milk case3
            + "plum" + System.lineSeparator() + "red" + System.lineSeparator() + "yes" + System.lineSeparator()
            + "grapefruit" + System.lineSeparator() + "yes" + System.lineSeparator()
            + "lemon" + System.lineSeparator() + "yes" + System.lineSeparator()
            + "lime" + System.lineSeparator() + "yes" + System.lineSeparator()
            + "watermelon" + System.lineSeparator() + "yellow" + System.lineSeparator() + "yes" + System.lineSeparator() //added fruits case4
            + "yes" + System.lineSeparator() + "one" + System.lineSeparator() + "1" + System.lineSeparator()
            + "apricot" + System.lineSeparator() + "yes" + System.lineSeparator()
            + "5" + System.lineSeparator() + "papaya" + System.lineSeparator()
            + "no" + System.lineSeparator()//replace two fruit first input not an integer
            + "yes" + System.lineSeparator() + "rise" + System.lineSeparator() //added milk case4
            + "pear" + System.lineSeparator() + "yellow" + System.lineSeparator()
            + "yes" + System.lineSeparator() + "cherry" + System.lineSeparator() + "yes" + System.lineSeparator()
            + "papaya" + System.lineSeparator() + "yes" + System.lineSeparator()
            + "orange" + System.lineSeparator() + "red" + System.lineSeparator() + "yes" + System.lineSeparator()
            + "kiwi" + System.lineSeparator() + "yellow" + System.lineSeparator() //added fruits case5
            + "yes" + System.lineSeparator() + "yes" + System.lineSeparator()
            + "cherry" + System.lineSeparator() + "second" + System.lineSeparator()
            + "12" + System.lineSeparator() + "2" + System.lineSeparator()
            + "strawberry" + System.lineSeparator() + "yes" + System.lineSeparator()
            + "3" + System.lineSeparator() + "pineapple" + System.lineSeparator()
            + "no" + System.lineSeparator() //replace 2 fruits first two incorrect input and out of range input
            + "no" + System.lineSeparator()).getBytes()); //not added milk

    @BeforeAll
    static void setInput() {
        System.setIn(input);
    }
    @Test
    @Order(1)
    void inputCase1() {
        Smoothie test = Smoothie.input();
        assertEquals(smoothie1, test);
    }

    @Test
    @Order(2)
    void inputCase2() {
        Smoothie test = Smoothie.input();
        assertEquals(smoothie2, test);
    }

    @Test
    @Order(3)
    void inputCase3() {
        Smoothie test = Smoothie.input();
        assertEquals(smoothie3, test);
    }

    @Test
    @Order(4)
    void inputCase4() {
        Smoothie test = Smoothie.input();
        assertEquals(smoothie4, test);
    }

    @Test
    @Order(5)
    void inputCase5() {
        Smoothie test = Smoothie.input();
        assertEquals(smoothie5, test);
    }

    @AfterAll
    static void setSystemIn() {
        System.setIn(System.in);
    }
}
