import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NoOffersAppliedTests {
    @Test
    public void checkout_total_cost_is_zero_when_no_items_scanned() {
        Checkout checkout = new Checkout();
        assertEquals(0, checkout.total());
    }

    @Test
    public void checkout_total_is_equal_to_item_price_when_no_offer_for_that_item() {
        Checkout checkout = new Checkout();
        Sku sku = new Sku("A");
        checkout.scan(sku);
        assertEquals(50, checkout.total());
    }
}
