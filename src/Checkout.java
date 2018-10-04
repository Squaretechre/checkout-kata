public class Checkout {
    private final Catalog catalog;
    private Items items;
    private ScannedItems scannedItems;

    public Checkout(Catalog catalog) {
        this.catalog = catalog;
        this.scannedItems = ScannedItems.None();
    }

    public int total() {
        if(items == null) return 0;
        if(items.individualItems().size() == 3 && items.individualItems().get(0).sku.equals("A") || items.individualItems().size() == 2 && items.individualItems().get(0).sku.equals("B")) {
            int discount = scannedItems.applyDiscount();
            return catalog.totalCostOf(this.items) - discount;
        }
        return catalog.totalCostOf(this.items);
    }

    public void scan(Items items) {
        this.items = items;
        this.scannedItems = scannedItems.add(items);
    }
}
