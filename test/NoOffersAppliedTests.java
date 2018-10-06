import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class NoOffersAppliedTests {

    private Checkout buildCheckout() {
        Offers offers = new Offers(new ArrayList<Offer>() {{
            add(new Offer(new Item("A"), 3, 20));
            add(new Offer(new Item("B"), 2, 15));
        }});
        return new Checkout(new Catalog(), offers);
    }

    @Test
    public void checkout_total_cost_is_zero_when_no_items_scanned() {
        Checkout checkout = buildCheckout();
        assertEquals(0, checkout.total());
    }

    @Test
    @Parameters({
            "50, A",
            "30, B",
            "20, C",
            "15, D",
    })
    public void checkout_total_is_equal_to_item_price_when_no_offer_for_that_item(int expectedTotal, String id) {
        Checkout checkout = buildCheckout();
        Items items = new Items(id);
        checkout.scan(items);
        assertEquals(expectedTotal, checkout.total());
    }

    @Test
    @Parameters({
            "100, AA",
            "40, CC",
            "30, DD",
    })
    public void checkout_total_is_equal_to_a_multiple_of_the_item_price_when_no_offer_for_that_item(int expectedTotal, String itemIds) {
        Checkout checkout = buildCheckout();
        Items items = new Items(itemIds);
        checkout.scan(items);
        assertEquals(expectedTotal, checkout.total());
    }
}
