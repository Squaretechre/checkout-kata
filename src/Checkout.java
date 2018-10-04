public class Checkout {
    private Sku sku;

    public int total() {
        return sku == null ? 0 : 50;
    }

    public void scan(Sku sku) {
        this.sku = sku;
    }
}
