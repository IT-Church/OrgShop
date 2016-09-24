package pack;

/**
 * Created by Vadim on 09.09.2016.
 */
public class Sale {
    private int percent;
    private String condition;

    public Sale(String a, int b) {
        this.percent = b;
        this.condition = a;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public void setCondition(String condition){
        this.condition = condition;
    }
    public int getPercent(){
        return this.percent;
    }
    public String getCondition(){
        return this.condition;
    }
    @Override
    public String toString() {
        return Integer.toString(percent) + condition;
    }
}
