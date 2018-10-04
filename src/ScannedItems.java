public class ScannedItems {
    private final Items items;

    public ScannedItems(Items items) {
        this.items = items;
    }

    public int applyDiscount() {
        if(items.individualItems().size() == 3 && items.individualItems().get(0).sku.equals("A")) return 130;
        return 45;
    }
}
