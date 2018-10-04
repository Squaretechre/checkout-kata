public class Checkout {
    private final Catalog catalog;
    private Items items;

    public Checkout() {
        this.catalog = new Catalog();
    }

    public int total() {
        if(items == null) {
            return 0;
        }
        else {
            int total = 0;
            total = totalCostOf(total, catalog);
            return total;
        }
    }

    private int totalCostOf(int total, Catalog catalog) {
        for(Item item : items.individualItems()) {
            total += catalog.priceFor(item);
        }
        return total;
    }

    public void scan(Items items) {
        this.items = items;
    }
}
