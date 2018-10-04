import java.util.HashMap;

public class Checkout {
    private final HashMap<String, Integer> prices;
    private Sku sku;

    public Checkout() {
        this.prices = new HashMap<String, Integer>() {{
            put("A", 50);
            put("B", 30);
            put("C", 20);
            put("D", 15);
        }};
    }

    public int total() {
        return sku == null ? 0 : prices.get(sku.id);
    }

    public void scan(Sku sku) {
        this.sku = sku;
    }
}
