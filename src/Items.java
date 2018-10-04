public class Items {
    public final String id;

    public Items(String id) {
        this.id = id;
    }

    public char[] individualItems() {
        return id.toCharArray();
    }
}
