import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NoOffersAppliedTests {
    @Test
    public void checkout_total_cost_is_zero_when_no_items_scanned() {
        Checkout checkout = new Checkout();
        assertEquals(0, checkout.total());
    }
}
