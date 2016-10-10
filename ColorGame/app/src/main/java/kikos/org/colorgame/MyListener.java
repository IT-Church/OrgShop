package kikos.org.colorgame;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Vadim on 09.10.2016.
 */

public class MyListener implements View.OnTouchListener{
    MainActivity m;
    public MyListener(MainActivity ma){
        m=ma;
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getX()<v.getWidth()/3&&event.getY()>v.getHeight()/10*9){
            m.changeColorRed();
        }
        else if(event.getX()<v.getWidth()/3*2&&event.getX()>v.getWidth()/3&&event.getY()>v.getHeight()/10*9){
            m.changeColorGreen();
        }else if(event.getX()>v.getWidth()/3*2&&event.getY()>v.getHeight()/10*9){
            m.changeColorBlue();
        }
        else{m.endGame();}
        return false;
    }
}
