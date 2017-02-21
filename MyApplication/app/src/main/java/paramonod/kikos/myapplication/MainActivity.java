package paramonod.kikos.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.SearchView;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import org.json.*;

import java.net.MalformedURLException;

import ru.yandex.yandexmapkit.*;
import ru.yandex.yandexmapkit.map.GeoCode;
import ru.yandex.yandexmapkit.map.GeoCodeListener;
import ru.yandex.yandexmapkit.overlay.Overlay;
import ru.yandex.yandexmapkit.overlay.OverlayItem;
import ru.yandex.yandexmapkit.overlay.balloon.BalloonItem;
import ru.yandex.yandexmapkit.overlay.balloon.OnBalloonListener;
import ru.yandex.yandexmapkit.utils.GeoPoint;
import pack.*;


public class MainActivity extends AppCompatActivity {
    public static Context ctx;
    public static MapController mc;
    public static MapView mp;
    public static Overlay o;
    public static OverlayManager om;
    public static JSONObject jsonObject;
    public static Drawable shop;
    public static Drawable itkerk;
    public static SearchView searchView;
    final static float STANDART_ZOOM = 20.0f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
       setContentView(R.layout.map);
        ctx = this;

        itkerk = createScaledIcon(getResources().getDrawable(R.drawable.itkerk),480,270,getResources());
                searchView = (SearchView) findViewById(R.id.search);
        final MainActivity m = this;
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                m.searchListener();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        mp = (MapView) findViewById(R.id.map);
        mp.showBuiltInScreenButtons(true);
        mc = mp.getMapController();
        mc.setPositionAnimationTo(new GeoPoint(new Adress().getP(), new Adress().getM()));
        mc.setZoomCurrent(STANDART_ZOOM);
        FloatingActionButton plus = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        FloatingActionButton minus = (FloatingActionButton) findViewById(R.id.floatingActionButton2);

        plus.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mc.setZoomCurrent(mc.getZoomCurrent() + 0.1f);

                return false;
            }
        });
        minus.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mc.setZoomCurrent(mc.getZoomCurrent() - 0.1f);
                return false;
            }
        });

        om = mc.getOverlayManager();
        o = new Overlay(mc);

        o.setVisible(true);
        om.addOverlay(o);
        OverlayItem oi = new OverlayItem(new GeoPoint(new Adress().getP(), new Adress().getM()),
                getResources().getDrawable(R.drawable.shop));

        mc.getDownloader().getGeoCode(new GeoCodeListener() {
            @Override
            public boolean onFinishGeoCode(final GeoCode geoCode) {
                if(geoCode!=null){
                    Log.d("Not so fucking","title"+geoCode.getTitle()+"\nsubtitle"+geoCode.getSubtitle()+"\ndisplayname"+geoCode.getDisplayName()+"\nkind"+geoCode.getKind());

                }
                else{
                    Log.e("OMFG","fail");
                }
                return true;
            }
        },oi.getGeoPoint());
        this.makingFullStackIcon(R.drawable.orpgshop,50,50,oi.getGeoPoint());
        OverlayItem oi2 = new OverlayItem(new GeoPoint(new Adress().getP() + 0.0001, new Adress().getM() + 0.0001), getResources().getDrawable(R.drawable.shop));
        o.addOverlayItem(oi);
        o.addOverlayItem(oi2);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void updatePins(GeoPoint[] overlayItems) {
       // List<Overlay> l = mc.getOverlayManager().getOverlays();
       // for (Overlay q : l) {
       //     q.setVisible(false);
       // }

        //o = new Overlay(mc);
        o.clearOverlayItems();
        if(overlayItems != null){
            for (int i = 0; i < overlayItems.length; i++) {
            this.makingFullStackIcon(R.drawable.orpgshop,55,55,overlayItems[i]);
        }}
        o.setVisible(true);

      //  om.addOverlay(o);
    }

    public  void searchListener() {
        try {
            Search s = new Search();
            s.doSearch(searchView.getQuery().toString(),this);
        } catch (MalformedURLException q) {
            q.printStackTrace();
        }
    }

    public static Drawable createScaledIcon(Drawable id, int width, int height, Resources res){
        Bitmap bitmap = ((BitmapDrawable)id ).getBitmap();
        // Scale it to 50 x 50
        shop = new BitmapDrawable(res, Bitmap.createScaledBitmap(bitmap, width, height, true));
        return shop;
    }
    public  void makingFullStackIcon(int id, int width, int height,GeoPoint geoPoint){
        this.makingFullStackIcon(id,width,height,geoPoint,getString(R.string.itch__kerk),"");
    }
    public  void makingFullStackIcon(int id, int width, int height, GeoPoint geoPoint,final String name, final String description){
        OverlayItem oi = new OverlayItem(geoPoint,this.createScaledIcon(getResources().getDrawable(id),width,height,getResources()));
        BalloonItem bi = new BalloonItem(ctx, oi.getGeoPoint());
        bi.setOnBalloonListener(
                new OnBalloonListener() {
                    @Override
                    public void onBalloonViewClick(BalloonItem balloonItem, View view) {
                    }

                    @Override
                    public void onBalloonShow(BalloonItem balloonItem) {
                        final Intent intent = new Intent(ctx,Empty.class);
                        mc.getDownloader().getGeoCode(new GeoCodeListener() {
                            @Override
                            public boolean onFinishGeoCode(GeoCode geoCode) {
                                if(geoCode!=null){
                                    intent.putExtra("geocode",geoCode.getDisplayName());
                                    intent.putExtra("description",new String(name+"\n\n"+description+"\n"));
                                    startActivity(intent);
                                }
                                return false;
                            }
                        },balloonItem.getGeoPoint());

                    }

                    @Override
                    public void onBalloonHide(BalloonItem balloonItem) {

                    }

                    @Override
                    public void onBalloonAnimationStart(BalloonItem balloonItem) {


                    }

                    @Override
                    public void onBalloonAnimationEnd(BalloonItem balloonItem) {

                    }
                }
        );
        oi.setBalloonItem(bi);
        o.addOverlayItem(oi);

    }
}