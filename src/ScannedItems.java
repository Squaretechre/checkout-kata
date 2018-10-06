import java.util.Iterator;

public class ScannedItems implements Iterable<Item> {
    private final Items items;

    private ScannedItems(Items items) {
        this.items = items;
    }

    public static ScannedItems None() {
        return new ScannedItems(new Items(""));
    }

    public int discount() {
        ItemTotals totals = items.totals();
        return totals.calculateDiscount();
    }

    @Override
    public Iterator<Item> iterator() {
        return items.iterator();
    }

    public ScannedItems add(Items scannedItems) {
        return new ScannedItems(this.items.add(scannedItems));
    }
}
