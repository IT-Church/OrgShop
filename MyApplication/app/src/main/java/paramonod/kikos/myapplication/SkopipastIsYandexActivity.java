package paramonod.kikos.myapplication;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import pack.Adress;
import ru.yandex.yandexmapkit.MapController;
import ru.yandex.yandexmapkit.MapView;
import ru.yandex.yandexmapkit.OverlayManager;
import ru.yandex.yandexmapkit.overlay.Overlay;
import ru.yandex.yandexmapkit.overlay.OverlayItem;
import ru.yandex.yandexmapkit.overlay.balloon.BalloonItem;
import ru.yandex.yandexmapkit.utils.GeoPoint;

/**
 * Created by Vadim on 01.10.2016.
 */

public class SkopipastIsYandexActivity extends Activity {

    public int counter = 0;
    public MapController mc;
    public static MapView mp;
    public static OverlayManager om;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        mp = (MapView) findViewById(R.id.map);
        mc = mp.getMapController();
        om = mc.getOverlayManager();
        GeoPoint first = new GeoPoint(new Adress().getP(), new Adress().getM());
        mc.setPositionAnimationTo(first); //ориентир на Новослободская 38
        showObject(first);
        mc.setZoomCurrent(20.0f);
        Button button = (Button) findViewById(R.id.b1);
        final EditText et1 = (EditText) findViewById(R.id.text);
        final EditText et2 = (EditText) findViewById(R.id.text2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GeoPoint gp = new GeoPoint(
                        Double.parseDouble(et1.getText().toString()),
                        Double.parseDouble(et2.getText().toString())
                );

                showObject(gp);
            }
        });
    }

    public void showObject(GeoPoint geoPoint) {
        Resources res = getResources();
        Overlay overlay = new Overlay(mc);
        final OverlayItem object = new OverlayItem(geoPoint, res.getDrawable(R.drawable.mshop));

        BalloonItem balloon = new BalloonItem(this, object.getGeoPoint());
        balloon.setText("Object No" + counter++);
        object.setBalloonItem(balloon);
        overlay.addOverlayItem(object);

        om.addOverlay(overlay);
        mc.setPositionAnimationTo(geoPoint);
    }
}
