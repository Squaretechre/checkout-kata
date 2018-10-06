import java.util.HashMap;

public class Catalog {
    private final HashMap<String, Integer> prices;

    public Catalog() {
        this.prices = new HashMap<String, Integer>() {{
            put("A", 50);
            put("B", 30);
            put("C", 20);
            put("D", 15);
        }};
    }

    int totalCostOf(ScannedItems items) {
        int total = 0;
        if (items == null) return total;
        for(Item item : items) {
            total += priceFor(item);
        }
        return total;
    }

    private Integer priceFor(Item item) {
        return prices.get(item.sku);
    }
}