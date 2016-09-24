package pack;

import java.util.ArrayList;




/**
 * Created by Vadim on 09.09.2016.
 */
public class ShopInterface {
    private String name;
    private Adress adress;
    private ArrayList<Item> products;
    private ArrayList<Sale> sales;
    private Certificate certificate;
    private Image photo;

    public ShopInterface() {
        products = new ArrayList<Item>();
        sales = new ArrayList<Sale>();
        name = "helloOrgShop";
        adress = new Adress();
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

    @Override
    public String toString() {
        return name+adress;
    }

    public Adress getAdress() {
        return adress;
    }

    public ArrayList<Item> getProducts() {
        return products;
    }

    public ArrayList<Sale> getSales() {
        return sales;
    }

    public Certificate getCertificate() {
        return certificate;

    }

    public Image getPhoto() {
        return photo;
    }

    public String getName() {
        return name;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }
    public Item searchItemByName(String name){
       ArrayList<Item> p = getProducts();
        for(Item i:p){
            if (i.getName().equals( name)){
                return i;
            }
        }
        return null;
    }
}
