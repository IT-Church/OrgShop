package kikos.org.colorgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;


/**
 * Created by Vadim on 09.10.2016.
 */

public class StartActivity extends View {
    Context ctx;
    public int xt;
    public int yt;
    public int xq;
    public int yq;
    Bitmap src;
    Bitmap srcq;
    public StartActivity(Context context) {
        super(context);
        ctx = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        p.setColor(Color.WHITE);
        canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), p);

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 4;
        src = BitmapFactory.decodeResource(getResources(),R.drawable.triangle,options);
        xt = canvas.getWidth()/2-src.getWidth()/2;
        yt = canvas.getHeight()/2-src.getHeight()/2;
        canvas.drawBitmap(src,xt,yt,p);

        BitmapFactory.Options options1 = new BitmapFactory.Options();
        options1.inSampleSize = 5;
        srcq = BitmapFactory.decodeResource(getResources(),R.drawable.question,options1);
        xq = canvas.getWidth()-srcq.getWidth();
        yq = 0;
        canvas.drawBitmap(srcq,xq,yq,p);
    }
}
