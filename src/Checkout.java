public class Checkout {
    private final Catalog catalog;
    private Items items;
    private ScannedItems scannedItems;

    public Checkout(Catalog catalog) {
        this.catalog = catalog;
        this.scannedItems = ScannedItems.None();
    }

    public int total() {
        int discount = scannedItems.applyDiscount();
        return catalog.totalCostOf(this.items) - discount;
    }

    public void scan(Items items) {
        this.items = items;
        this.scannedItems = scannedItems.add(items);
    }
}
