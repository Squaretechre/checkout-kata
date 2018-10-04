import java.util.HashMap;
import java.util.Map;

public class ScannedItems {
    private final Items items;
    private HashMap<String, Integer> itemCounts;

    private ScannedItems(Items items) {
        this.items = items;
        this.itemCounts = new HashMap<String, Integer>();
    }

    public static ScannedItems None() {
        return new ScannedItems(new Items(""));
    }

    public int applyDiscount() {
        for(Item item : items.individualItems()) {
            if(itemCounts.containsKey(item.sku)) {
                Integer incrementedCount = itemCounts.get(item.sku) + 1;
                itemCounts.put(item.sku, incrementedCount);
            }
            else {
                itemCounts.put(item.sku, 1);
            }
        }

        int totalDiscount = 0;
        if (itemCounts.containsKey("A") && itemCounts.get("A") == 3) {
            totalDiscount += 20;
        }
        if (itemCounts.containsKey("B") && itemCounts.get("B") == 2) {
            totalDiscount += 15;
        }
        return totalDiscount;
    }

    public ScannedItems add(Items items) {
        return new ScannedItems(items);
    }
}
