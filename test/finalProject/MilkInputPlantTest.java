package finalProject;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MilkInputPlantTest {
    static ByteArrayInputStream input = new ByteArrayInputStream(("HAZELNUT" + System.lineSeparator() //case hazelnut
            + "cOconUT" + System.lineSeparator() //case coconut
            + "almond" + System.lineSeparator() //case almond
            + "rise    " + System.lineSeparator() //case rise
            + "    OAT" + System.lineSeparator() //case oat
            + "   soy    " + System.lineSeparator() //case soy
            + "cashew" + System.lineSeparator() + "Oat" + System.lineSeparator() //case unavailable or incorrect than oat(correct)
            + "cashew" + System.lineSeparator() + "Macadamia" + System.lineSeparator()
            + "banana" + System.lineSeparator() + "alMond " + System.lineSeparator() //case several unavailable or incorrect than almond(correct)
            + "regular" + System.lineSeparator() + "Oat" + System.lineSeparator() //case regular than correct
            + "regular" + System.lineSeparator() + "cashew" + System.lineSeparator()
            + "Oat" + System.lineSeparator() //case regular than incorrect than correct
            + "cashew" + System.lineSeparator() + "regular" + System.lineSeparator()
            + "Oat" + System.lineSeparator()).getBytes()); //case incorrect than regular than correct
    @BeforeAll
    static void setInput() {
        System.setIn(input);
    }
    @Test
    @Order(1)
    void inputPlantCaseHazelnut() {
        Milk test = Milk.inputPlant();
        assertFalse(test.isRegular());
        assertEquals(Milk.HAZELNUT, test);
    }

    @Test
    @Order(2)
    void inputPlantCaseCoconut() {
        Milk test = Milk.inputPlant();
        assertFalse(test.isRegular());
        assertEquals(Milk.COCONUT, test);
    }

    @Test
    @Order(3)
    void inputPlantCaseAlmond() {
        Milk test = Milk.inputPlant();
        assertFalse(test.isRegular());
        assertEquals(Milk.ALMOND, test);
    }

    @Test
    @Order(4)
    void inputPlantCaseRise() {
        Milk test = Milk.inputPlant();
        assertFalse(test.isRegular());
        assertEquals(Milk.RISE, test);
    }
    @Test
    @Order(5)
    void inputPlantCaseOat() {
        Milk test = Milk.inputPlant();
        assertFalse(test.isRegular());
        assertEquals(Milk.OAT, test);
    }

    @Test
    @Order(6)
    void inputPlantCaseSoy() {
        Milk test = Milk.inputPlant();
        assertFalse(test.isRegular());
        assertEquals(Milk.SOY, test);
    }

    @Test
    @Order(7)
    void inputPlantCaseUnavailable() {
        Milk test = Milk.inputPlant();
        assertFalse(test.isRegular());
        assertEquals(Milk.OAT, test);
    }

    @Test
    @Order(8)
    void inputPlantCaseSeveralUnavailable() {
        Milk test = Milk.inputPlant();
        assertFalse(test.isRegular());
        assertEquals(Milk.ALMOND, test);
    }

    @Test
    @Order(9)
    void inputPlantCaseRegular() {
        Milk test = Milk.inputPlant();
        assertFalse(test.isRegular());
        assertEquals(Milk.OAT, test);
    }

    @Test
    @Order(10)
    void inputPlantCaseRegularAndUnavailable() {
        Milk test = Milk.inputPlant();
        assertFalse(test.isRegular());
        assertEquals(Milk.OAT, test);
    }

    @Test
    @Order(11)
    void inputPlantCaseUnavailableAndRegular() {
        Milk test = Milk.inputPlant();
        assertFalse(test.isRegular());
        assertEquals(Milk.OAT, test);
    }
}
