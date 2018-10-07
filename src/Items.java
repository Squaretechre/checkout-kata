import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Items implements Iterable<Item> {
    private List<Item> items;

    Items(String skuList) {
        this.items = buildItemsFrom(skuList);
    }

    private Items(List<Item> items) {
        this.items = items;
    }

    private List<Item> buildItemsFrom(String skuList) {
        List<Item> items = new ArrayList<>();
        for(Character sku : skuList.toCharArray()) {
           items.add(new Item(sku.toString()));
        }
        return items;
    }

    Items add(Items otherItems) {
        this.items.addAll(otherItems.items);
        return new Items(this.items);
    }

    @Override
    public Iterator<Item> iterator() {
        return items.iterator();
    }

    ItemTotals totals() {
        return new ItemTotals(this);
    }
}
