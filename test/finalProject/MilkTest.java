package finalProject;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MilkTest {
    @Test
    void getAndSetPrice() {
        Milk test1 = Milk.REGULAR;  // price 1
        Milk test2 = Milk.HAZELNUT;  // price 2
        Milk test3 = Milk.COCONUT;  // price 2
        Milk test4 = Milk.ALMOND;  // price 2
        Milk test5 = Milk.RISE;  // price 1.5
        Milk test6 = Milk.OAT;  // price 1.5
        Milk test7 = Milk.SOY;  // price 2
        assertEquals(1, test1.getPrice());
        assertEquals(2, test2.getPrice());
        assertEquals(2, test3.getPrice());
        assertEquals(2, test4.getPrice());
        assertEquals(1.5, test5.getPrice());
        assertEquals(1.5, test6.getPrice());
        assertEquals(2, test7.getPrice());

        test1.setPrice(5);
        assertEquals(5, test1.getPrice());
        test6.setPrice(0);
        assertEquals(0, test6.getPrice());
        test3.setPrice(test1.getPrice());
        assertEquals(test1.getPrice(), test3.getPrice());
    }

    @Test
    void printCaseRegular() {
        Milk test = Milk.REGULAR;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        test.print();
        assertEquals(("Milk: regular, price: 1.0" + System.lineSeparator()), os.toString());
    }
    @Test
    void printCaseHazelnut(){
        Milk test = Milk.HAZELNUT;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        test.print();
        assertEquals(("Milk: hazelnut, price: 2.0" + System.lineSeparator()), os.toString());
    }
    @Test
    void printCaseCoconut(){
        Milk test = Milk.COCONUT;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        test.print();
        assertEquals(("Milk: coconut, price: 2.0" + System.lineSeparator()), os.toString());
    }
    @Test
    void printCaseAlmond(){
        Milk test = Milk.ALMOND;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        test.print();
        assertEquals(("Milk: almond, price: 2.0" + System.lineSeparator()), os.toString());
    }
    @Test
    void printCaseRise(){
        Milk test = Milk.RISE;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        test.print();
        assertEquals(("Milk: rise, price: 1.5" + System.lineSeparator()), os.toString());
    }
    @Test
    void printCaseOat(){
        Milk test = Milk.OAT;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        test.print();
        assertEquals(("Milk: oat, price: 1.5" + System.lineSeparator()), os.toString());
    }
    @Test
    void printCaseSoy(){
        Milk test = Milk.SOY;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        test.print();
        assertEquals(("Milk: soy, price: 2.0" + System.lineSeparator()), os.toString());
    }

    @Test
    void testToString() {
        Milk test1 = Milk.REGULAR;
        Milk test2 = Milk.HAZELNUT;
        Milk test3 = Milk.COCONUT;
        Milk test4 = Milk.ALMOND;
        Milk test5 = Milk.RISE;
        Milk test6 = Milk.OAT;
        Milk test7 = Milk.SOY;
        assertEquals("regular milk", test1.toString());
        assertEquals("hazelnut milk", test2.toString());
        assertEquals("coconut milk", test3.toString());
        assertEquals("almond milk", test4.toString());
        assertEquals("rise milk", test5.toString());
        assertEquals("oat milk", test6.toString());
        assertEquals("soy milk", test7.toString());
    }

    @Test
    void availablePlantMilk() {
        Milk[] allMilks = Milk.values();
        if (allMilks[0].equals(Milk.REGULAR)) {
            for (int i = 1; i < allMilks.length; i++) {
                assertTrue(Milk.availablePlantMilk().contains(allMilks[i].name().toLowerCase()));
            }
        } else {
            assertEquals(Milk.REGULAR, allMilks[0]);
            System.out.println("Regular milk should be placed first");
        }
    }

    @Test
    void isRegular() {
        Milk test1 = Milk.REGULAR;
        Milk test2 = Milk.HAZELNUT;
        Milk test3 = Milk.COCONUT;
        Milk test4 = Milk.ALMOND;
        Milk test5 = Milk.RISE;
        Milk test6 = Milk.OAT;
        Milk test7 = Milk.SOY;
        assertTrue(test1.isRegular());
        assertFalse(test2.isRegular());
        assertFalse(test3.isRegular());
        assertFalse(test4.isRegular());
        assertFalse(test5.isRegular());
        assertFalse(test6.isRegular());
        assertFalse(test7.isRegular());
    }
}