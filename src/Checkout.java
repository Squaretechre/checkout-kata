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
            for(Character c : items.id.toCharArray()) {
                total += catalog.priceFor(c);
            }
            return total;
        }
    }

    public void scan(Items items) {
        this.items = items;
    }
}
