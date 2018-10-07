import java.util.HashMap;

class Catalog {
    int totalCostOf(ScannedItems items) {
        int total = 0;
        if (items == null) return total;
        for(Item item : items) {
            total += priceFor(item);
        }
        return total;
    }

    private Integer priceFor(Item item) {
        HashMap<Item, Integer> prices = new HashMap<Item, Integer>() {{
            put(new Item("A"), 50);
            put(new Item("B"), 30);
            put(new Item("C"), 20);
            put(new Item("D"), 15);
        }};
        return prices.get(item);
    }
}