import java.util.HashMap;

public class ScannedItems {
    private final Items items;
    private HashMap<String, Integer> itemCounts;

    public ScannedItems(Items items) {
        this.items = items;
        this.itemCounts = new HashMap<>();
    }

    public static ScannedItems None() {
        return new ScannedItems(new Items(""));
    }

    public int discount() {
        int totalDiscount = 0;

        for(Item item : items.individualItems()) {
            if(itemCounts.containsKey(item.sku)) {
                Integer incrementedCount = itemCounts.get(item.sku) + 1;
                itemCounts.put(item.sku, incrementedCount);
            }
            else {
                itemCounts.put(item.sku, 1);
            }

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
