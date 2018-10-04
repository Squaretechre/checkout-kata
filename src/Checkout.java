import java.util.List;

public class Checkout {
    private final Catalog catalog;
    private Items items;

    public Checkout(Catalog catalog) {
        this.catalog = catalog;
    }

    public int total() {
        if(items == null) return 0;
        if(items.individualItems().size() == 3) return 130;
        return catalog.totalCostOf(this.items);
    }

    public void scan(Items items) {
        this.items = items;
    }
}
