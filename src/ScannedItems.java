import java.util.HashMap;
import java.util.Iterator;

public class ScannedItems implements Iterable<Item> {
    private final Items items;
    private HashMap<String, Integer> itemCounts;

    private ScannedItems(Items items) {
        this.items = items;
        this.itemCounts = new HashMap<>();
    }

    public static ScannedItems None() {
        return new ScannedItems(new Items(""));
    }

    public int discount() {
        int totalDiscount = 0;

        for(Item item : items) {
            if(itemCounts.containsKey(item.sku)) {
                Integer incrementedCount = itemCounts.get(item.sku) + 1;
                itemCounts.put(item.sku, incrementedCount);
            }
            else {
                itemCounts.put(item.sku, 1);
            }

            totalDiscount = Offers.offers(itemCounts, totalDiscount);
        }

        return totalDiscount;
    }

    @Override
    public Iterator<Item> iterator() {
        return items.iterator();
    }

    public ScannedItems add(Items scannedItems) {
        return new ScannedItems(this.items.add(scannedItems));
    }
}
