import java.util.HashMap;

class Offer {
    private final Item item;
    private final int amountRequiredForReward;
    final int discountAwarded;

    Offer(Item item, int amountRequiredForReward, int reward) {
        this.item = item;
        this.amountRequiredForReward = amountRequiredForReward;
        this.discountAwarded = reward;
    }

    boolean canBeAppliedTo(HashMap<Item, Integer> itemTotals) {
        return itemTotals.containsKey(item) && itemTotals.get(item) >= amountRequiredForReward;
    }

    HashMap<Item,Integer> deductFrom(HashMap<Item, Integer> itemTotals) {
        Integer decrementedCount = itemTotals.get(item) - amountRequiredForReward;
        itemTotals.put(item, decrementedCount);
        return itemTotals;
    }
}
