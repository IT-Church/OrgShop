package pack;

/**
 * Created by Vadim on 09.09.2016.
 */
public class Item {
    String name;

    public Item(String a) {
        this.name = a;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
