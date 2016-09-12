package pack;

import java.math.BigDecimal;

/**
 * Created by Vadim on 10.09.2016.
 */
public class Adress {
    private String street;
    private int house;
    private double[] coords;
    public Adress(){
        this.street = "Novslobodskaya";
        this.house = 38;
        this.coords= new double[]{55.785226,37.596921};
    }

    public double[] getCoords() {
        return this.coords;
    }

    public int getHouse() {
        return this.house;
    }

    public String getStreet() {
        return this.street;
    }

    public void setCoords(double[] coords) {
        this.coords = coords;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return street+Integer.toString(house);
    }
}
