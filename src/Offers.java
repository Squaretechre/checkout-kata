import java.util.HashMap;
import java.util.List;

public class Offers {
    private final List<Offer> offers;

    public Offers(List<Offer> offers) {
        this.offers = offers;
    }

    public int calculateDiscountFor(HashMap<Item, Integer> counts) {
        int totalDiscount = 0;
        HashMap<Item, Integer> itemTotals = counts;

        while (offersCanBeApplied(itemTotals)) {
            for (Offer offer : offers) {
                if (offer.canBeAppliedTo(itemTotals)) {
                    itemTotals = offer.deductFrom(itemTotals);
                    totalDiscount += offer.discountAwarded;
                }
            }
        }

        return totalDiscount;
    }

    private boolean offersCanBeApplied(HashMap<Item, Integer> workingCounts) {
        for (Offer offer : offers) {
            if (offer.canBeAppliedTo(workingCounts)) return true;
        }
        return false;
    }
}