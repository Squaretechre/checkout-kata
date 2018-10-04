public class Checkout {
    private final Catalog catalog;
    private Items items;

    public Checkout() {
        this.catalog = new Catalog();
    }

    public int total() {
        return catalog.totalCostOf(items);
    }

    public void scan(Items items) {
        this.items = items;
    }
}
