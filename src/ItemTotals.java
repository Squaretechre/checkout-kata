import java.util.HashMap;

class ItemTotals {
    private final Items items;

    ItemTotals(Items items) {
        this.items = items;
    }

    private HashMap<Item, Integer> itemTotals() {
        HashMap<Item, Integer> counts = new HashMap<>();
        for (Item item : items) {
            if (counts.containsKey(item)) {
                int incrementedCount = counts.get(item) + 1;
                counts.put(item, incrementedCount);
            } else {
                counts.put(item, 1);
            }
        }
        return counts;
    }

    int calculateDiscountFor(Offers offers) {
        return offers.calculateDiscountFor(itemTotals());
    }
}