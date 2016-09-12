package pack;

/**
 * Created by Vadim on 09.09.2016.
 */
public class Item {
    private String name;
    private Image photo;
    private int price;
    private Sale currentItemSale;

    public Item(String a, int b) {
        this.name = a;
        this.setPrice(b);
    }

    public void setCurrentItemSale(Sale s) {
       this.currentItemSale = s;
    }

    public void deleteCurrentItemsale() {
        this.currentItemSale = null;
    }
    public Sale getCurrentItemSale(){
        return this.currentItemSale;
    }

    public void setPhoto(Image i){
        this.photo = i;
    }
    public Image getPhoto(){
        return this.photo;
    }
    public int getPrice(){
        return this.price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
