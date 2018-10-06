public class Checkout {
    private ScannedItems scannedItems;
    private final Catalog catalog;
    private final Offers offers;

    public Checkout(Catalog catalog, Offers offers) {
        this.catalog = catalog;
        this.offers = offers;
        this.scannedItems = ScannedItems.None();
    }

    public int total() {
        return catalog.totalCostOf(scannedItems) - scannedItems.totalDiscountFor(offers);
    }

    public void scan(Items items) {
        this.scannedItems = this.scannedItems.add(items);
    }
}
