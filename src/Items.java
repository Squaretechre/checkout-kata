import java.util.ArrayList;
import java.util.List;

public class Items {
    private final String items;

    public Items(String items) {
        this.items = items;
    }

    public static Items None() {
        return new Items("");
    }

    public List<Item> individualItems() {
        List<Item> items = new ArrayList<>();
        for(Character sku : this.items.toCharArray()) {
           items.add(new Item(sku.toString()));
        }
        return items;
    }

    public Items add(Items items) {
       return new Items(this.items + items.items);
    }
}
