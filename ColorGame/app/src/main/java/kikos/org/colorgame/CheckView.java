package kikos.org.colorgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;

/**
 * Created by Vadim on 09.10.2016.
 */

public class CheckView extends View{

    Context ctx;
    int[] color1;
    int[] color2;
    public CheckView(Context context,int[] f,int[] s) {
        super(context);
        ctx = context;
        color1 = f;
        color2 = s;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p1 = new Paint();
        p1.setColor(Color.rgb(color1[0]*16-1,color1[1]*16-1,color1[2]*16-1));
        Paint p2 = new Paint();
        p2.setColor(Color.rgb(color2[0]*16-1,color2[1]*16-1,color2[2]*16-1));
        canvas.drawRect(0,0,canvas.getWidth()/2,canvas.getHeight(),p1);
        canvas.drawRect(canvas.getWidth()/2,0,canvas.getWidth(),canvas.getHeight(),p2);
    }
}
