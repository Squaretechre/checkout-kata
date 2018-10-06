import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class AcceptanceTests {

    @Test
    @Parameters({
            "0, ",
            "50, A",
            "80, AB",
            "115, CDBA",
            "100, AA",
            "130, AAA",
            "180, AAAA",
            "230, AAAAA",
            "260, AAAAAA",
            "160, AAAB",
            "175, AAABB",
            "190, AAABBD",
            "190, DABABA",
    })
    public void checkout_bulk_scan_acceptance(int expectedTotal, String itemIds) {
        Checkout checkout = buildCheckout();
        Items items = new Items(itemIds);
        checkout.scan(items);
        assertEquals(expectedTotal, checkout.total());
    }

    private Checkout buildCheckout() {
        Offers offers = new Offers(new ArrayList<Offer>() {{
            add(new Offer(new Item("A"), 3, 20));
            add(new Offer(new Item("B"), 2, 15));
        }});
        return new Checkout(new Catalog(), offers);
    }

    @Test
    public void checkout_incremental_scan_acceptance() {
        Checkout checkout = buildCheckout();
        checkout.scan(new Items("A"));
        assertEquals(50, checkout.total());

        checkout.scan(new Items("B"));
        assertEquals(80, checkout.total());

        checkout.scan(new Items("A"));
        assertEquals(130, checkout.total());

        checkout.scan(new Items("A"));
        assertEquals(160, checkout.total());
    }
}
