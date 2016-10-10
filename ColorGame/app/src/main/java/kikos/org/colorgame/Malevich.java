package kikos.org.colorgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;

/**
 * Created by Vadim on 08.10.2016.
 */

public class Malevich extends View {
    Context ctx;
    static int[] color;


    public Malevich(Context context,int[] q) {
        super(context);
        ctx = context;
        color = q;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawButtons(canvas);
        drawField(canvas, color);


    }


    protected void drawButtons(Canvas zcanvas) {
        Drawable red = new Drawable() {
            @Override
            public void draw(Canvas canvas) {
                Paint paint = new Paint();
                paint.setColor(Color.RED);
                canvas.drawRect(0, canvas.getHeight() / 10 * 9, canvas.getWidth() / 3, canvas.getHeight(), paint);
            }

            @Override

            public void setAlpha(int alpha) {

            }

            @Override
            public void setColorFilter(ColorFilter colorFilter) {

            }

            @Override
            public int getOpacity() {
                return PixelFormat.UNKNOWN;
            }
        };
        Drawable green = new Drawable() {
            @Override
            public void draw(Canvas canvas) {
                Paint paint = new Paint();
                paint.setColor(Color.GREEN);
                canvas.drawRect(canvas.getWidth() / 3, canvas.getHeight() / 10 * 9, canvas.getWidth() / 3 * 2, canvas.getHeight(), paint);
            }

            @Override

            public void setAlpha(int alpha) {

            }

            @Override
            public void setColorFilter(ColorFilter colorFilter) {

            }

            @Override
            public int getOpacity() {
                return PixelFormat.UNKNOWN;
            }
        };
        Drawable blue = new Drawable() {
            @Override
            public void draw(Canvas canvas) {
                Paint paint = new Paint();
                paint.setColor(Color.BLUE);
                canvas.drawRect(canvas.getWidth() / 3 * 2, canvas.getHeight() / 10 * 9, canvas.getWidth(), canvas.getHeight(), paint);
            }

            @Override

            public void setAlpha(int alpha) {

            }

            @Override
            public void setColorFilter(ColorFilter colorFilter) {

            }

            @Override
            public int getOpacity() {
                return PixelFormat.UNKNOWN;
            }
        };

        red.draw(zcanvas);

        green.draw(zcanvas);

        blue.draw(zcanvas);
    }


    public  void drawField(Canvas canvas, int[] q) {
        Paint paint = new Paint();
        paint.setColor(Color.rgb(q[0]*16-1, q[1]*16-1, q[2]*16-1));
        canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight() / 10 * 9, paint);
    }
}
