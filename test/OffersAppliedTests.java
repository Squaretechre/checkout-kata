import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class OffersAppliedTests {

    @Test
    @Parameters({
            "130, AAA",
            "45, BB",
    })
    public void checkout_total_is_item_total_minus_offer_discount_when_only_offer_items_scanned(int expectedTotal, String itemIds) {
        Checkout checkout = new Checkout(new Catalog());
        Items items = new Items(itemIds);
        checkout.scan(items);
        assertEquals(expectedTotal, checkout.total());
    }

    @Test
    @Parameters({
            "180, AAAA",
            "75, BBB",
    })
    public void checkout_total_is_item_total_minus_offer_discount_when_offer_items_and_non_offer_items_are_scanned(int expectedTotal, String itemIds) {
        Checkout checkout = new Checkout(new Catalog());
        Items items = new Items(itemIds);
        checkout.scan(items);
        assertEquals(expectedTotal, checkout.total());
    }
}
