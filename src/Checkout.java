public class Checkout {
    private final Catalog catalog;
    private Sku sku;

    public Checkout() {
        this.catalog = new Catalog();
    }

    public int total() {
        if(sku == null) {
            return 0;
        }
        else {
            int total = 0;
            for(Character c : sku.id.toCharArray()) {
                total += catalog.priceFor(c);
            }
            return total;
        }
    }

    public void scan(Sku sku) {
        this.sku = sku;
    }
}
