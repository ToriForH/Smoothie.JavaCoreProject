package finalProject;

public enum FruitType {
    //all fruit types written in alphabet order
    APPLE( new String [] {"red", "green"}, false, 1),
    APRICOT(new String [] {"orange"}, false, 1.5),
    BANANA(new String [] {"green", "yellow", "red"}, false, 1.5),
    BLUEBERRY(new String [] {"blue"}, false, 2),
    CHERRY(new String [] {"red"}, false, 2),
    DRAGONFRUIT(new String[] {"white", "pink"}, false, 2.5),
    GRAPE(new String [] {"black", "white"}, false, 1.5),
    GRAPEFRUIT(new String [] {"red"}, true, 1.5),
    KIWI(new String [] {"green", "yellow"}, false, 1.5),
    MANGO(new String [] {"orange"}, false, 2),
    MELON(new String [] {"yellow"}, false, 2),
    LIME(new String [] {"green"}, true, 1),
    LEMON(new String [] {"yellow"}, true, 1),
    ORANGE(new String [] {"orange", "red"}, true, 1.5),
    PAPAYA(new String [] {"orange"}, false, 2.5),
    PEACH(new String [] {"orange"}, false, 1.5),
    PEAR(new String [] {"green", "yellow"}, false, 1),
    PINEAPPLE(new String [] {"yellow"}, false, 2),
    PLUM(new String [] {"black", "red"}, false, 1.5),
    STRAWBERRY(new String [] {"red"}, false, 1.5),
    WATERMELON(new String [] {"red", "yellow"}, false, 2);
    private String[] colors;
    private final boolean isCitrus;
    private double price;

    FruitType(String[] colors, boolean isCitrus, double price) {
        this.colors = colors;
        this.isCitrus = isCitrus;
        this.price = price;
    }

    public String[] getColors() {
        return colors;
    }

    public void setColors(String[] colors) {
        this.colors = colors;
    }

    public boolean isCitrus() {
        return isCitrus;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    String availableColors() {
        return String.join(", ", this.colors);
    }
    public static String availableFruitTypes() {
        FruitType[] availableTypes = FruitType.values();
        String[] types = new String[availableTypes.length];
        for (int i = 0; i < availableTypes.length; i++) {
            types[i] = availableTypes[i].name().toLowerCase();
        }
        return String.join(", ", types);
    }
}
