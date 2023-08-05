package finalProject;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FruitInputTest {
    //must work for child class Citrus too
    Fruit fruitCase1and3 = new Fruit("strawberry", "red", 1.5);
    Fruit citrusCase2 = new Citrus("lemon", "yellow", 1);
    Fruit fruitCase4and9 = new Fruit("banana", "yellow", 1.5);
    Fruit fruitCase5and10 = new Fruit("pear", "yellow", 1);
    Citrus citrusCase6and12 = new Citrus("orange", "red", 1.5);
    Fruit fruitCase7and11 = new Fruit("watermelon", "red", 2);
    Fruit fruitCase8 = new Fruit("plum", "black", 1.5);

    static ByteArrayInputStream input = new ByteArrayInputStream(("strawberry" + System.lineSeparator() //simple one color case
            + "carrot" + System.lineSeparator() + "lEmOn " + System.lineSeparator() //incorrect than correct one color case (is citrus)
            + "tomato" + System.lineSeparator() + "carrot" + System.lineSeparator()
            + "raspberry" + System.lineSeparator() + " STRAWBERRY   " + System.lineSeparator() //several incorrect than correct one color case
            + "banana" + System.lineSeparator() + "yellow" + System.lineSeparator() //simple case choose color
            + "pear" + System.lineSeparator() + "red" + System.lineSeparator()
            + "yellow" + System.lineSeparator() //simple case color incorrect than correct
            + "orange" + System.lineSeparator() + "yellow" + System.lineSeparator()
            + "green" + System.lineSeparator() + "black" + System.lineSeparator()
            + "red" + System.lineSeparator() //simple case color several incorrect than correct (is Citrus)
            + "coconut" + System.lineSeparator() + "watermelon" + System.lineSeparator()
            + "red" + System.lineSeparator() //incorrect than correct name simple color
            + "tomato" + System.lineSeparator() + "plum" + System.lineSeparator()
            + "white" + System.lineSeparator() + "black" + System.lineSeparator() //incorrect than correct name incorrect than correct color
            + "blackberry" + System.lineSeparator() + "banana" + System.lineSeparator()
            + "white" + System.lineSeparator() + "black" + System.lineSeparator()
            + "pink" + System.lineSeparator() + "yellow" + System.lineSeparator() //incorrect than correct name several incorrect than correct color
            + "pomelo" + System.lineSeparator() + "coconut" + System.lineSeparator()
            + "tomato" + System.lineSeparator() + "pear" + System.lineSeparator()
            + "yellow" + System.lineSeparator() //several incorrect than correct name simple color
            + "avocado" + System.lineSeparator() + "cucumber" + System.lineSeparator()
            + "raspberry" + System.lineSeparator() + "watermelon" + System.lineSeparator()
            + "black" + System.lineSeparator() + "red" + System.lineSeparator() //several incorrect than correct name incorrect than correct color
            + "sweetie" + System.lineSeparator() + "carrot" + System.lineSeparator()
            + "blackberry" + System.lineSeparator() + "orange" + System.lineSeparator()
            + "yellow" + System.lineSeparator() + "pink" + System.lineSeparator()
            + "green" + System.lineSeparator() + "red" + System.lineSeparator() //several incorrect than correct name several incorrect than correct color (is Citrus)
            + System.lineSeparator()).getBytes());
    @BeforeAll
    static void setInput() {
        System.setIn(input);
    }
    @Test
    @Order(1)
    void inputSimpleOneColorCase() {
        Fruit test = Fruit.input();
        assertFalse(test instanceof Citrus);
        assertEquals(fruitCase1and3, test);
    }

    @Test
    @Order(2)
    void inputIncorrectNameOneColorCase() {
        Fruit test = Fruit.input();
        assertTrue(test instanceof Citrus);
        assertEquals(citrusCase2, test);
    }

    @Test
    @Order(3)
    void inputSeveralIncorrectNameOneColorCase() {
        Fruit test = Fruit.input();
        assertFalse(test instanceof Citrus);
        assertEquals(fruitCase1and3, test);
    }

    @Test
    @Order(4)
    void inputSimpleChooseColorCase() {
        Fruit test = Fruit.input();
        assertFalse(test instanceof Citrus);
        assertEquals(fruitCase4and9, test);
    }

    @Test
    @Order(5)
    void inputSimpleIncorrectColorCase() {
        Fruit test = Fruit.input();
        assertFalse(test instanceof Citrus);
        assertEquals(fruitCase5and10, test);
    }

    @Test
    @Order(6)
    void inputSimpleSeveralIncorrectColorCase() {
        Fruit test = Fruit.input();
        assertTrue(test instanceof Citrus);
        assertEquals(citrusCase6and12, test);
    }

    @Test
    @Order(7)
    void inputIncorrectNameSimpleColorCase() {
        Fruit test = Fruit.input();
        assertFalse(test instanceof Citrus);
        assertEquals(fruitCase7and11, test);
    }

    @Test
    @Order(8)
    void inputIncorrectNameIncorrectColorCase() {
        Fruit test = Fruit.input();
        assertFalse(test instanceof Citrus);
        assertEquals(fruitCase8, test);
    }

    @Test
    @Order(9)
    void inputIncorrectNameSeveralIncorrectColorCase() {
        Fruit test = Fruit.input();
        assertFalse(test instanceof Citrus);
        assertEquals(fruitCase4and9, test);
    }

    @Test
    @Order(10)
    void inputSeveralIncorrectNameSimpleColorCase() {
        Fruit test = Fruit.input();
        assertFalse(test instanceof Citrus);
        assertEquals(fruitCase5and10, test);
    }

    @Test
    @Order(11)
    void inputSeveralIncorrectNameIncorrectColorCase() {
        Fruit test = Fruit.input();
        assertFalse(test instanceof Citrus);
        assertEquals(fruitCase7and11, test);
    }

    @Test
    @Order(12)
    void inputSeveralIncorrectNameSeveralIncorrectColorCase() {
        Fruit test = Fruit.input();
        assertTrue(test instanceof Citrus);
        assertEquals(citrusCase6and12, test);
    }

    @AfterAll
    static void setSystemIn() {
        System.setIn(System.in);
    }
}
