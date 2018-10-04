import java.util.HashMap;

public class Catalog {
    final HashMap<String, Integer> prices;

    public Catalog() {
        this.prices = new HashMap<String, Integer>() {{
            put("A", 50);
            put("B", 30);
            put("C", 20);
            put("D", 15);
        }};
    }

    Integer priceFor(Character c) {
        return prices.get(c.toString());
    }
}