import java.util.Iterator;

public class ScannedItems implements Iterable<Item> {
    private final Items items;

    private ScannedItems(Items items) {
        this.items = items;
    }

    static ScannedItems None() {
        return new ScannedItems(new Items(""));
    }

    int totalDiscountFor(Offers offers) {
        ItemTotals totals = items.totals();
        return totals.calculateDiscountFor(offers);
    }

    @Override
    public Iterator<Item> iterator() {
        return items.iterator();
    }

    ScannedItems add(Items scannedItems) {
        return new ScannedItems(this.items.add(scannedItems));
    }
}
