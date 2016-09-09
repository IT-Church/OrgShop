package pack;

import java.util.ArrayList;


import pack.Certificate;
import pack.Image;
import pack.Item;
import pack.Sale;

/**
 * Created by Vadim on 09.09.2016.
 */
public class ShopInterface {
    String adress;
    ArrayList<Item> products;
    ArrayList<Sale> sales;
    Certificate certificate;
    Image photo;

    public ShopInterface() {
        products = new ArrayList<Item>(100);
        sales = new ArrayList<Sale>(100);
    }

    private void pop(ArrayList<?> arrayList, Object whatToDelete) {
        arrayList.remove(whatToDelete);
    }

    public void deleteSale(Sale o) {
        this.pop(sales, o);
        //TODO : menu.update();
    }

    public void deleteItem(Item i) {
        this.pop(products, i);
    }

    public void addSale(Sale o) {
        sales.add(o);
    }

    public void addItem(Item i) {
        products.add(i);
    }




}
