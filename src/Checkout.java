public class Checkout {
    private Items items;
    private ScannedItems scannedItems;
    private final Catalog catalog;

    public Checkout(Catalog catalog) {
        this.catalog = catalog;
        this.items = Items.None();
        this.scannedItems = ScannedItems.None();
    }

    public int total() {
        return catalog.totalCostOf(items) - scannedItems.discount();
    }

    public void scan(Items scannedItems) {
        items = items.add(scannedItems);
        this.scannedItems = new ScannedItems(items);
    }
}
