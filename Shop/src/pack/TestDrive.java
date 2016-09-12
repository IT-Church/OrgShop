package pack;

/**
 * Created by Vadim on 10.09.2016.
 */
public class TestDrive {
    public static void main(String[] args) { //����� ��������� ����������������� �����������
        ShopInterface shopInterface = new ShopInterface();
        System.out.println(shopInterface);
        for (String i = "a";!i.equals("aaaaa");i+="a"){
            //shopInterface.addItem(new Item(i,200));
        }
/*        System.out.println(shopInterface.getProducts());
        shopInterface.addSale(new Sale("to every client",15));
        System.out.println(shopInterface.getSales());
        Item i = shopInterface.searchItemByName("aaa");
        i.setPrice(300);
        Sale s = new Sale("if U have our customer card",30);
        i.setCurrentItemSale(s);
        System.out.println(i.getCurrentItemSale());
        s.setPercent(12);
        System.out.println(i.getCurrentItemSale());
        i.deleteCurrentItemsale();
        System.out.println(i.getCurrentItemSale());
        System.out.println(i.getPrice());
        System.out.println(i);
        System.out.println(shopInterface.getProducts());*/
    }
}
