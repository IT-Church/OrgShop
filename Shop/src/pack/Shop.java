package pack;

import java.util.ArrayList;
import java.sql.*;

/**
 * Created by Dmitry Paramonov on 9/12/2016.
 */
public class Shop {
    private String name;
    private Image photo;
    private MapPoint address;
    private int ID;
    private int ItemsValue;
    private ArrayList<Item> Products = new ArrayList<Item>();
    private static final String url = "jdbc:mysql://localhost:3306/";
    private static final String user = "root";
    private static final String password = "logan_16";
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public void Shop_update(){
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery("shops");

            while (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("Total number of books in the table : " + count);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }

   public Shop(int id) {
       this.ID = id;
    }

   /* public void setCurrentItemSale(Sale s) {
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
    public MapPoint getAddress(){
        return this.address;
    }
    public void setAddress(MapPoint place) {
        this.address = place;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }*/
}
