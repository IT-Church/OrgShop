package paramonod.kikos.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
/**
 * Created by Vadim on 24.09.2016.
 */
public class MapActivity extends View{
    public static Context ctx;

    public MapActivity(Context context) {
        super(context);
        ctx = context;
        requestLayout();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap b = BitmapFactory.decodeResource(getResources(),R.drawable.shop);
        canvas.drawBitmap(b,100,100,new Paint());
    }
// public static void go(Context c, MapView mp,Resources res){
 //       MapController mc = mp.getMapController();
 //       OverlayManager om = mc.getOverlayManager();
  //      Overlay overlay = new Overlay(mc);
// /       if(res!=null){
 //       OverlayItem oi = new OverlayItem(new GeoPoint(new Adress().getP(), new Adress().getM()),res.getDrawable(R.drawable.ymk_balloon_black));
    //    BalloonItem bi = new BalloonItem(ctx,new GeoPoint(new Adress().getP(),new Adress().getM()));
 //       bi.setText("228ВОВАНЫЧКЕК");
  //      oi.setBalloonItem(bi);
 //       overlay.addOverlayItem(oi);
  //      om.addOverlay(overlay);}
  //  }
}
