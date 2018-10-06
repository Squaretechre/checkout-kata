import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class OffersAppliedTests {

    private Checkout buildCheckout() {
        Offers offers = new Offers(new ArrayList<Offer>() {{
            add(new Offer(new Item("A"), 3, 20));
            add(new Offer(new Item("B"), 2, 15));
        }});
        return new Checkout(new Catalog(), offers);
    }

    @Test
    @Parameters({
            "130, AAA",
            "45, BB",
    })
    public void checkout_total_is_item_total_minus_offer_discount_when_only_offer_items_scanned(int expectedTotal, String itemIds) {
        Checkout checkout = buildCheckout();
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
        Checkout checkout = buildCheckout();
        Items items = new Items(itemIds);
        checkout.scan(items);
        assertEquals(expectedTotal, checkout.total());
    }

    @Test
    @Parameters({
            "260, AAAAAA",
            "135, BBBBBB",
    })
    public void checkout_total_is_item_total_minus_offer_discount_when_an_offer_can_be_applied_more_than_once_the_items(int expectedTotal, String itemIds) {
        Checkout checkout = buildCheckout();
        Items items = new Items(itemIds);
        checkout.scan(items);
        assertEquals(expectedTotal, checkout.total());
    }
}
