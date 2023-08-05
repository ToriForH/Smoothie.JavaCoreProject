package finalProject;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FruitTypeTest {
    FruitType[] types = FruitType.values();
    List<String> orange = List.of("orange");
    List<String> blue = List.of("blue");
    List<String> red = List.of("red");
    List<String> yellow = List.of("yellow");
    List<String> black = List.of("black");
    List<String> green = List.of("green");
    List<String> white = List.of("white");
    List<String> pink = List.of("pink");

    @Test
    void colorsGetSetAvailableTest() {
        List<String> appleColors = List.of(red.get(0), green.get(0));
        assertTrue(appleColors.stream()
                .map(color -> types[0].availableColors().contains(color))
                .reduce(true, (total, element) -> total && element));
        assertTrue(appleColors.stream()
                .map(color -> Arrays.toString(types[0].getColors()).contains(color))
                .reduce(true, (total, element) -> total && element));

        //apricot
        assertTrue(orange.stream()
                .map(color -> (types[1].availableColors().contains(color)))
                .reduce(true, (total, element) -> total && element));
        assertTrue(orange.stream()
                .map(color -> (Arrays.toString(types[1].getColors()).contains(color)))
                .reduce(true, (total, element) -> total && element));

        List<String> bananaColors = List.of(red.get(0), green.get(0), yellow.get(0));
        assertTrue(bananaColors.stream()
                .map(color -> (types[2].availableColors().contains(color)))
                .reduce(true, (total, element) -> total && element));
        assertTrue(bananaColors.stream()
                .map(color -> (Arrays.toString(types[2].getColors()).contains(color)))
                .reduce(true, (total, element) -> total && element));

        //blueberry
        assertTrue(blue.stream()
                .map(color -> (types[3].availableColors().contains(color)))
                .reduce(true, (total, element) -> total && element));
        assertTrue(blue.stream()
                .map(color -> (Arrays.toString(types[3].getColors()).contains(color)))
                .reduce(true, (total, element) -> total && element));

        //cherry
        assertTrue(red.stream()
                .map(color -> (types[4].availableColors().contains(color)))
                .reduce(true, (total, element) -> total && element));
        assertTrue(red.stream()
                .map(color -> (Arrays.toString(types[4].getColors()).contains(color)))
                .reduce(true, (total, element) -> total && element));

        List<String> dragonfruitColors = List.of(white.get(0), pink.get(0));
        assertTrue(dragonfruitColors.stream()
                .map(color -> (types[5].availableColors().contains(color)))
                .reduce(true, (total, element) -> total && element));
        assertTrue(dragonfruitColors.stream()
                .map(color -> (Arrays.toString(types[5].getColors()).contains(color)))
                .reduce(true, (total, element) -> total && element));

        List<String> grapeColors = List.of(white.get(0), black.get(0));
        assertTrue(grapeColors.stream()
                .map(color -> (types[6].availableColors().contains(color)))
                .reduce(true, (total, element) -> total && element));
        assertTrue(grapeColors.stream()
                .map(color -> (Arrays.toString(types[6].getColors()).contains(color)))
                .reduce(true, (total, element) -> total && element));

        //grapefruit
        assertTrue(red.stream()
                .map(color -> (types[7].availableColors().contains(color)))
                .reduce(true, (total, element) -> total && element));
        assertTrue(red.stream()
                .map(color -> (Arrays.toString(types[7].getColors()).contains(color)))
                .reduce(true, (total, element) -> total && element));

        List<String> kiwiColors = List.of(green.get(0), yellow.get(0));
        assertTrue(kiwiColors.stream()
                .map(color -> (types[8].availableColors().contains(color)))
                .reduce(true, (total, element) -> total && element));
        assertTrue(kiwiColors.stream()
                .map(color -> (Arrays.toString(types[8].getColors()).contains(color)))
                .reduce(true, (total, element) -> total && element));

        //mango
        assertTrue(orange.stream()
                .map(color -> (types[9].availableColors().contains(color)))
                .reduce(true, (total, element) -> total && element));
        assertTrue(orange.stream()
                .map(color -> (Arrays.toString(types[9].getColors()).contains(color)))
                .reduce(true, (total, element) -> total && element));

        //melon
        assertTrue(yellow.stream()
                .map(color -> (types[10].availableColors().contains(color)))
                .reduce(true, (total, element) -> total && element));
        assertTrue(yellow.stream()
                .map(color -> (Arrays.toString(types[10].getColors()).contains(color)))
                .reduce(true, (total, element) -> total && element));

        //lime
        assertTrue(green.stream()
                .map(color -> (types[11].availableColors().contains(color)))
                .reduce(true, (total, element) -> total && element));
        assertTrue(green.stream()
                .map(color -> (Arrays.toString(types[11].getColors()).contains(color)))
                .reduce(true, (total, element) -> total && element));

        //lemon
        assertTrue(yellow.stream()
                .map(color -> (types[12].availableColors().contains(color)))
                .reduce(true, (total, element) -> total && element));
        assertTrue(yellow.stream()
                .map(color -> (Arrays.toString(types[12].getColors()).contains(color)))
                .reduce(true, (total, element) -> total && element));

        //orange
        List<String> orangeColors = List.of(red.get(0), orange.get(0));
        assertTrue(orangeColors.stream()
                .map(color -> (types[13].availableColors().contains(color)))
                .reduce(true, (total, element) -> total && element));
        assertTrue(orangeColors.stream()
                .map(color -> (Arrays.toString(types[13].getColors()).contains(color)))
                .reduce(true, (total, element) -> total && element));

        //papaya
        assertTrue(orange.stream()
                .map(color -> (types[14].availableColors().contains(color)))
                .reduce(true, (total, element) -> total && element));
        assertTrue(orange.stream()
                .map(color -> (Arrays.toString(types[14].getColors()).contains(color)))
                .reduce(true, (total, element) -> total && element));

        //peach
        assertTrue(orange.stream()
                .map(color -> (types[15].availableColors().contains(color)))
                .reduce(true, (total, element) -> total && element));
        assertTrue(orange.stream()
                .map(color -> (Arrays.toString(types[15].getColors()).contains(color)))
                .reduce(true, (total, element) -> total && element));

        //pear
        List<String> pearColors = List.of(green.get(0), yellow.get(0));
        assertTrue(pearColors.stream()
                .map(color -> (types[16].availableColors().contains(color)))
                .reduce(true, (total, element) -> total && element));
        assertTrue(pearColors.stream()
                .map(color -> (Arrays.toString(types[16].getColors()).contains(color)))
                .reduce(true, (total, element) -> total && element));

        //pineapple
        assertTrue(yellow.stream()
                .map(color -> (types[17].availableColors().contains(color)))
                .reduce(true, (total, element) -> total && element));
        assertTrue(yellow.stream()
                .map(color -> (Arrays.toString(types[17].getColors()).contains(color)))
                .reduce(true, (total, element) -> total && element));

        //plum
        List<String> plumColors = List.of(red.get(0), black.get(0));
        assertTrue(plumColors.stream()
                .map(color -> (types[18].availableColors().contains(color)))
                .reduce(true, (total, element) -> total && element));
        assertTrue(plumColors.stream()
                .map(color -> (Arrays.toString(types[18].getColors()).contains(color)))
                .reduce(true, (total, element) -> total && element));

        //strawberry
        assertTrue(red.stream()
                .map(color -> (types[19].availableColors().contains(color)))
                .reduce(true, (total, element) -> total && element));
        assertTrue(red.stream()
                .map(color -> (Arrays.toString(types[19].getColors()).contains(color)))
                .reduce(true, (total, element) -> total && element));

        //watermelon
        List<String> watermelonColors = List.of(red.get(0), yellow.get(0));
        assertTrue(watermelonColors.stream()
                .map(color -> (types[20].availableColors().contains(color)))
                .reduce(true, (total, element) -> total && element));
        assertTrue(watermelonColors.stream()
                .map(color -> (Arrays.toString(types[20].getColors()).contains(color)))
                .reduce(true, (total, element) -> total && element));

        types[0].setColors(grapeColors.toArray(String[]::new));
        assertTrue(grapeColors.stream()
                .map(color -> (types[0].availableColors().contains(color)))
                .reduce(true, (total, element) -> total && element));
        assertTrue(grapeColors.stream()
                .map(color -> (Arrays.toString(types[0].getColors()).contains(color)))
                .reduce(true, (total, element) -> total && element));

        types[14].setColors(bananaColors.toArray(String[]::new));
        assertFalse(orange.stream()
                .map(color -> (types[14].availableColors().contains(color)))
                .reduce(true, (total, element) -> total && element));
        assertFalse(orange.stream()
                .map(color -> (Arrays.toString(types[14].getColors()).contains(color)))
                .reduce(true, (total, element) -> total && element));

        String[] colors = new String[] {"pink", "blue", "green"};
        types[20].setColors(colors);
        assertTrue(Arrays.stream(colors)
                .map(color -> (types[20].availableColors().contains(color)))
                .reduce(true, (total, element) -> total && element));
        assertTrue(Arrays.stream(colors)
                .map(color -> (Arrays.toString(types[20].getColors()).contains(color)))
                .reduce(true, (total, element) -> total && element));
    }

    @Test
    void isCitrus() {
        assertFalse( types[0].isCitrus()); //apple
        assertFalse( types[1].isCitrus()); //apricot
        assertFalse( types[2].isCitrus()); //banana
        assertFalse( types[3].isCitrus()); //blueberry
        assertFalse( types[4].isCitrus()); //cherry
        assertFalse( types[5].isCitrus()); //dragonfruit
        assertFalse( types[6].isCitrus()); //grape
        assertTrue( types[7].isCitrus()); //grapefruit
        assertFalse( types[8].isCitrus());  //kiwi
        assertFalse( types[9].isCitrus()); //mango
        assertFalse( types[10].isCitrus()); //melon
        assertTrue( types[11].isCitrus()); //lime
        assertTrue( types[12].isCitrus()); //lemon
        assertTrue( types[13].isCitrus()); //orange
        assertFalse( types[14].isCitrus()); //papaya
        assertFalse( types[15].isCitrus()); //peach
        assertFalse( types[16].isCitrus()); //pear
        assertFalse( types[17].isCitrus()); //pineapple
        assertFalse( types[18].isCitrus()); //plum
        assertFalse( types[19].isCitrus()); //strawberry
        assertFalse( types[20].isCitrus()); //watermelon
    }

    @Test
    void getAndSetPrice() {
        assertEquals(1, types[0].getPrice());  //apple
        assertEquals(1.5, types[1].getPrice()); //apricot
        assertEquals(1.5, types[2].getPrice()); //banana
        assertEquals(2, types[3].getPrice()); //blueberry
        assertEquals(2, types[4].getPrice()); //cherry
        assertEquals(2.5, types[5].getPrice()); //dragonfruit
        assertEquals(1.5, types[6].getPrice()); //grape
        assertEquals(1.5, types[7].getPrice()); //grapefruit
        assertEquals(1.5, types[8].getPrice()); //kiwi
        assertEquals(2, types[9].getPrice()); //mango
        assertEquals(2, types[10].getPrice()); //melon
        assertEquals(1, types[11].getPrice()); //lime
        assertEquals(1, types[12].getPrice()); //lemon
        assertEquals(1.5, types[13].getPrice()); //orange
        assertEquals(2.5, types[14].getPrice()); //papaya
        assertEquals(1.5, types[15].getPrice()); //peach
        assertEquals(1, types[16].getPrice()); //pear
        assertEquals(2, types[17].getPrice()); //pineapple
        assertEquals(1.5, types[18].getPrice()); //plum
        assertEquals(1.5, types[19].getPrice()); //strawberry
        assertEquals(2, types[20].getPrice()); //watermelon

        types[1].setPrice(3);
        assertEquals(3, types[1].getPrice());

        types[15].setPrice(1.8);
        assertEquals(1.8, types[15].getPrice());

        types[14].setPrice(types[15].getPrice());
        assertEquals(1.8, types[14].getPrice());
    }

    @Test
    void availableFruitTypes() {
        for (FruitType fruitType: types) {
            assertTrue(FruitType.availableFruitTypes().contains(fruitType.name().toLowerCase()));
        }
    }
}