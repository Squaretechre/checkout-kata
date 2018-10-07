import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Items implements Iterable<Item> {
    private final String items;
    private List<Item> itemList;

    Items(String items) {
        this.items = items;
        this.itemList = individualItems();
    }

    private List<Item> individualItems() {
        List<Item> items = new ArrayList<>();
        for(Character sku : this.items.toCharArray()) {
           items.add(new Item(sku.toString()));
        }
        return items;
    }

    Items add(Items items) {
       return new Items(this.items + items.items);
    }

    @Override
    public Iterator<Item> iterator() {
        return itemList.iterator();
    }

    ItemTotals totals() {
        return new ItemTotals(this);
    }
}
