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
        HashMap<Item,Integer> newTotals = itemTotals;
        Integer decrementedCount = newTotals.get(item) - amountRequiredForReward;
        newTotals.put(item, decrementedCount);
        return newTotals;
    }
}
