import java.util.HashMap;

public class ItemTotals {
    private final Items items;
    private HashMap<String, Integer> itemCounts;

    public ItemTotals(Items items) {
        this.items = items;
        itemCounts = itemCounts();
    }

    private HashMap<String, Integer> itemCounts() {
        HashMap<String, Integer> itemCounts = new HashMap<>();
        for (Item item : items) {
            if (itemCounts.containsKey(item.sku)) {
                int incrementedCount = itemCounts.get(item.sku) + 1;
                itemCounts.put(item.sku, incrementedCount);
            } else {
                itemCounts.put(item.sku, 1);
            }
        }
        return itemCounts;
    }

    public int calculateDiscount() {
        int totalDiscount = 0;
        for (Item item : items) {
            if (itemCounts.containsKey("A") && itemCounts.get("A") >= 3) {
                totalDiscount += 20;
                Integer decrementedCount = itemCounts.get("A") - 3;
                itemCounts.put("A", decrementedCount);
            }
            if (itemCounts.containsKey("B") && itemCounts.get("B") >= 2) {
                totalDiscount += 15;
                Integer decrementedCount = itemCounts.get("B") - 2;
                itemCounts.put("B", decrementedCount);
            }
        }
        return totalDiscount;
    }
}