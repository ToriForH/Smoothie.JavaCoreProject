package finalProject;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MilkInputTest {
    static ByteArrayInputStream input = new ByteArrayInputStream((" rEgULar  " + System.lineSeparator()  //regular
            + "plant" + System.lineSeparator() + "Soy" + System.lineSeparator()  //plant
            + "no" + System.lineSeparator() + "regular" + System.lineSeparator()  //incorrect than regular
            + "no" + System.lineSeparator() + "PLANT  " + System.lineSeparator()
            + "almond" + System.lineSeparator()  //incorrect than plant
            + "no" + System.lineSeparator() + "yes" + System.lineSeparator()
            + "milk" + System.lineSeparator() + "regular" + System.lineSeparator() //several incorrect than regular
            +"no" + System.lineSeparator() + "almond" + System.lineSeparator() + "okay" + System.lineSeparator()
            + "plant" + System.lineSeparator() + "almond" + System.lineSeparator()).getBytes());  //several incorrect than plant

    @BeforeAll
    static void setInput() {
        System.setIn(input);
    }
    @Test
    @Order(1)
    void inputCaseRegular() {
        Milk test = Milk.input();
        assertTrue(test.isRegular());
        assertEquals(Milk.REGULAR, test);
    }

    @Test
    @Order(2)
    void inputCasePlant() {

        Milk test = Milk.input();
        assertFalse(test.isRegular());
        assertEquals(Milk.SOY, test);
    }

    @Test
    @Order(3)
    void inputCaseIncorrectAndRegular() {
        Milk test = Milk.input();
        assertTrue(test.isRegular());
        assertEquals(Milk.REGULAR, test);
    }

    @Test
    @Order(4)
    void inputCaseIncorrectAndPlant() {
        Milk test = Milk.input();
        assertFalse(test.isRegular());
        assertEquals(Milk.ALMOND, test);
    }

    @Test
    @Order(5)
    void inputCaseSeveralIncorrectAndRegular() {
        Milk test = Milk.input();
        assertTrue(test.isRegular());
        assertEquals(Milk.REGULAR, test);
    }

    @Test
    @Order(6)
    void inputCaseSeveralIncorrectAndPlant() {
        Milk test = Milk.input();
        assertFalse(test.isRegular());
        assertEquals(Milk.ALMOND, test);
    }

    @AfterAll
    static void setSystemIn() {
        System.setIn(System.in);
    }
}
