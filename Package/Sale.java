package pack;

/**
 * Created by Vadim on 09.09.2016.
 */
public class Sale {
    int percent;
    String condition;

    public Sale(String a, int b) {
        this.percent = b;
        this.condition = a;
    }

    @Override
    public String toString() {
        return Integer.toString(percent) + condition;
    }
}
