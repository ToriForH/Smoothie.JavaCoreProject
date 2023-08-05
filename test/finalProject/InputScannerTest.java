package finalProject;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InputScannerTest {
    static ByteArrayInputStream input = new ByteArrayInputStream(("2" + System.lineSeparator() //simple case inputDouble
            + "1.5" + System.lineSeparator() //simple point case inputDouble
            + "two" + System.lineSeparator() + "  1" + System.lineSeparator() //incorrect than correct inputDouble
            + "one" + System.lineSeparator() + "nine" + System.lineSeparator()
            + "five" + System.lineSeparator() + "3.65  " + System.lineSeparator() //several incorrect than correct inputDouble
            + "3  " + System.lineSeparator()  //simple case inputInt
            + "5.6" + System.lineSeparator() + "  5  " + System.lineSeparator() //point number case inputInteger
            + "one" + System.lineSeparator() + "first" + System.lineSeparator()
            + "integer" + System.lineSeparator() + "10" + System.lineSeparator() //several string case inputInteger
            + "yes" + System.lineSeparator() + "no" + System.lineSeparator() //simple yes and no case
            + "YES  " + System.lineSeparator() + "  YeS" + System.lineSeparator() + "  yeS  " + System.lineSeparator()
            + "No" + System.lineSeparator() + " nO  " + System.lineSeparator() + "NO " + System.lineSeparator() //yes and no case
            + "yeap" + System.lineSeparator() + "of course" + System.lineSeparator()
            + "may be" + System.lineSeparator() + "yes" + System.lineSeparator() //several incorrect than yes
            + "-1" + System.lineSeparator() + "No" + System.lineSeparator() //incorrect than no
            + "string" + System.lineSeparator() + "String One" + System.lineSeparator()
            + "  space" + System.lineSeparator() + "   doubleSpace      " + System.lineSeparator()
            + "space in the end   " + System.lineSeparator()).getBytes()); //inputStringTest

    @BeforeAll
    static void setInput() {
        System.setIn(input);
    }

    @Test
    @Order(1)
    void inputDoubleSimple() {
        double test = InputScanner.inputDouble();
        assertEquals(2, test);
    }

    @Test
    @Order(2)
    void inputDoubleSimplePointCase() {
        double test = InputScanner.inputDouble();
        assertEquals(1.5, test);
    }

    @Test
    @Order(3)
    void inputDoubleIncorrectCase() {
        double test = InputScanner.inputDouble();
        assertEquals(1, test);
    }

    @Test
    @Order(4)
    void inputDoubleSeveralIncorrectCase() {
        double test = InputScanner.inputDouble();
        assertEquals(3.65, test);
    }

    @Test
    @Order(5)
    void inputIntSimpleCase() {
        double test = InputScanner.inputInt();
        assertEquals(3, test);
    }

    @Test
    @Order(6)
    void inputIntPointNumberCase() {
        double test = InputScanner.inputInt();
        assertEquals(5, test);
    }

    @Test
    @Order(7)
    void inputIntSeveralIncorrectCase() {
        double test = InputScanner.inputInt();
        assertEquals(10, test);
    }

    @Test
    @Order(8)
    void isAnswerYesSimpleYesNoCase() {
        assertTrue(InputScanner.isAnswerYes());
        assertFalse(InputScanner.isAnswerYes());
    }

    @Test
    @Order(9)
    void isAnswerYesYesNoCase() {
        assertTrue(InputScanner.isAnswerYes());
        assertTrue(InputScanner.isAnswerYes());
        assertTrue(InputScanner.isAnswerYes());
        assertFalse(InputScanner.isAnswerYes());
        assertFalse(InputScanner.isAnswerYes());
        assertFalse(InputScanner.isAnswerYes());
    }

    @Test
    @Order(10)
    void isAnswerYesSeveralIncorrectThanYesCase() {
        assertTrue(InputScanner.isAnswerYes());
    }

    @Test
    @Order(11)
    void isAnswerIncorrectThanNoCase() {
        assertFalse(InputScanner.isAnswerYes());
    }

    @Test
    @Order(12)
    void inputStringTest() {
        assertEquals("string", InputScanner.inputString());
        assertEquals("String One", InputScanner.inputString());
        assertEquals("space", InputScanner.inputString());
        assertEquals("doubleSpace", InputScanner.inputString());
        assertEquals("space in the end", InputScanner.inputString());
    }

    @AfterAll
    static void setSystemIn() {
        System.setIn(System.in);
    }
}