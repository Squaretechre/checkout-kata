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
    public void checkout_total_is_item_total_minus_offer_discount_when_an_offer_is_available(int expectedTotal, String itemIds) {
        Checkout checkout = new Checkout(new Catalog());
        Items items = new Items(itemIds);
        checkout.scan(items);
        assertEquals(expectedTotal, checkout.total());
    }
}
