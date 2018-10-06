import java.util.HashMap;

public class Offers {
    static int offers(HashMap<String, Integer> itemCounts, int totalDiscount) {
        if (itemCounts.containsKey("A") && itemCounts.get("A") >= 3) {
            totalDiscount += 20;
            Integer decrementedCount = itemCounts.get("A") - 3;
            itemCounts.put("A", decrementedCount);
        }
        if (itemCounts.containsKey("B") && itemCounts.get("B") >= 2) {
            totalDiscount += 15;
            Integer decrementedCount = itemCounts.get("B") - 2;
            itemCounts.put("B", decrementedCount);
        }
        return totalDiscount;
    }
}