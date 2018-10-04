import java.util.ArrayList;
import java.util.List;

public class Items {
    public final String id;

    public Items(String id) {
        this.id = id;
    }

    public List<Item> individualItems() {
        List<Item> items = new ArrayList<>();
        for(Character sku : id.toCharArray()) {
           items.add(new Item(sku.toString()));
        }
        return items;
    }
}
