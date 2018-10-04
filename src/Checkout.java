public class Checkout {
    private final Catalog catalog;
    private Items items;

    public Checkout(Catalog catalog) {
        this.catalog = catalog;
    }

    public int total() {
        return catalog.totalCostOf(items);
    }

    public void scan(Items items) {
        this.items = items;
    }
}
