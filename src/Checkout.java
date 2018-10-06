public class Checkout {
    private ScannedItems scannedItems;
    private final Catalog catalog;

    public Checkout(Catalog catalog) {
        this.catalog = catalog;
        this.scannedItems = ScannedItems.None();
    }

    public int total() {
        return catalog.totalCostOf(scannedItems) - scannedItems.discount();
    }

    public void scan(Items scannedItems) {
        this.scannedItems = this.scannedItems.add(scannedItems);
    }
}
