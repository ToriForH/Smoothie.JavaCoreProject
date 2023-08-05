package finalProject;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PayForSmoothieTest {
    static ByteArrayInputStream input = new ByteArrayInputStream(("10.5" + System.lineSeparator() //simple case payForSmoothie
            + "12" + System.lineSeparator() // simple with change case payForSmoothie
            + "twelve" + System.lineSeparator() + "10" + System.lineSeparator() //incorrect than simple case
            + "5" + System.lineSeparator() + "7" + System.lineSeparator() // not enough than with change case
            + "two" + System.lineSeparator() + "2" + System.lineSeparator()
            + "nine" + System.lineSeparator() + "seven" + System.lineSeparator()
            + "ten" + System.lineSeparator() + "20" + System.lineSeparator() //incorrect and not enough with change case
            + "1" + System.lineSeparator() + "2" + System.lineSeparator()
            + "5" + System.lineSeparator() + "1" + System.lineSeparator()).getBytes()); //several not enough case

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

    Fruit[] fruits3 = new Fruit[] {new Fruit("apricot", "orange", 1.5),
            new Citrus("grapefruit", "red", 1.5),
            new Citrus("lemon", "yellow", 1),
            new Citrus("lime", "green", 1),
            new Fruit("papaya", "orange", 2.5)};

    Smoothie smoothie1 = new Smoothie(fruits1, Milk.ALMOND); //cost 10.5
    Smoothie smoothie2 = new Smoothie(fruits2, Milk.REGULAR); //cost 10
    Smoothie smoothie3 = new Smoothie(fruits3, Milk.RISE); //cost 9

    @BeforeAll
    static void setInput() {
        System.setIn(input);
    }

    @Test
    @Order(1)
    void payForSmoothieSimpleCase() {
        String test = "It is 10.5$\nInput sum you give" + System.lineSeparator() + "Thank you!" + System.lineSeparator();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        smoothie1.payForSmoothie();
        assertEquals(test, os.toString());
    }

    @Test
    @Order(2)
    void payForSmoothieSimpleCaseWithChange() {
        String test = "It is 10.5$\nInput sum you give" + System.lineSeparator()
                + "Thank you!" + System.lineSeparator()
                + "Here is your change 1.5$" + System.lineSeparator();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        smoothie1.payForSmoothie();
        assertEquals(test, os.toString());
    }

    @Test
    @Order(3)
    void payForSmoothieIncorrectSimpleCase() {
        String test = "It is 10.0$\nInput sum you give" + System.lineSeparator()
                + "Incorrect input.\nPlease, write a number" + System.lineSeparator()
                + "Thank you!" + System.lineSeparator();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        smoothie2.payForSmoothie();
        assertEquals(test, os.toString());
    }

    @Test
    @Order(4)
    void payForSmoothieNotEnoughWithChangeCase() {
        String test = "It is 10.0$\nInput sum you give" + System.lineSeparator()
                + "It is not enough.\nPlease, input at least 5.0$ more" + System.lineSeparator()
                + "Thank you!" + System.lineSeparator()
                + "Here is your change 2.0$" + System.lineSeparator();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        smoothie2.payForSmoothie();
        assertEquals(test, os.toString());
    }

    @Test
    @Order(5)
    void payForSmoothieIncorrectNotEnoughWithChangeCase() {
        String test = "It is 9.0$\nInput sum you give" + System.lineSeparator()
                + "Incorrect input.\nPlease, write a number" + System.lineSeparator()
                + "It is not enough.\nPlease, input at least 7.0$ more" + System.lineSeparator()
                + "Incorrect input.\nPlease, write a number" + System.lineSeparator()
                + "Incorrect input.\nPlease, write a number" + System.lineSeparator()
                + "Incorrect input.\nPlease, write a number" + System.lineSeparator()
                + "Thank you!" + System.lineSeparator()
                + "Here is your change 13.0$" + System.lineSeparator();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        smoothie3.payForSmoothie();
        assertEquals(test, os.toString());
    }

    @Test
    @Order(6)
    void payForSmoothieSeveralNotEnoughCase() {
        String test = "It is 9.0$\nInput sum you give" + System.lineSeparator()
                + "It is not enough.\nPlease, input at least 8.0$ more" + System.lineSeparator()
                + "It is not enough.\nPlease, input at least 6.0$ more" + System.lineSeparator()
                + "It is not enough.\nPlease, input at least 1.0$ more" + System.lineSeparator()
                + "Thank you!" + System.lineSeparator();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        smoothie3.payForSmoothie();
        assertEquals(test, os.toString());
    }

    @AfterAll
    static void setSystemIn() {
        System.setIn(System.in);
        System.setOut(System.out);
    }
}