package kikos.org.colorgame;

import android.graphics.Color;
import android.util.Log;

import java.util.*;

/**
 * Created by Vadim on 29.08.2016.
 */
public class Mech {

    public static int points;
    public static int score;


    public static int[] randomizeColor(){
        int[] res = new int[3];
        for (int i = 0; i < 3; i++) {
            res[i] = (int) (Math.random()*16+1);
        }
        return res;
    }

}
