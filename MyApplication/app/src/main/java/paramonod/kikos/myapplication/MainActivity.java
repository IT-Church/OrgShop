package paramonod.kikos.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Map;

import ru.yandex.yandexmapkit.*;
import ru.yandex.yandexmapkit.overlay.Overlay;
import ru.yandex.yandexmapkit.overlay.OverlayItem;
import ru.yandex.yandexmapkit.utils.GeoPoint;
import pack.*;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView tw;
    public Context ctx;
    public MapController mc;
    public static Integer mutex =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ctx = this;
        tw = (TextView) findViewById(R.id.qwru);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.map);
                MapView mp = (MapView) findViewById(R.id.map);
                mc = mp.getMapController();
                mc.setPositionAnimationTo(new GeoPoint(new Adress().getP(), new Adress().getM()));
                mc.setZoomCurrent(15);
                Button button = (Button)findViewById(R.id.b1);
                final EditText et1 = (EditText) findViewById(R.id.text);
                final EditText et2 = (EditText) findViewById(R.id.text2);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        OverlayManager om = new OverlayManager(mc);
                        Overlay o = new Overlay(mc);
                        GeoPoint curG = new GeoPoint(Double.parseDouble(et1.getText().toString()), Double.parseDouble(et2.getText().toString()));
                        final Bitmap source = BitmapFactory.decodeResource(getResources(),R.drawable.ymk_balloon_black);
                        OverlayItem  oi= new OverlayItem(curG, new Drawable() {
                            @Override
                            public void draw(Canvas canvas) {
                                Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
                                canvas.drawARGB(80,102,204,255);
                                canvas.drawBitmap(source,360,250,paint);
                            }

                            @Override
                            public void setAlpha(int alpha) {

                            }

                            @Override
                            public void setColorFilter(ColorFilter colorFilter) {

                            }

                            @Override
                            public int getOpacity() {
                                return 0;
                            }
                        });
                        o.addOverlayItem(oi);
                        om.addOverlay(o);
                        oi.setVisible(true);
                        mc.setPositionAnimationTo(curG);
                    }
                });
            }
        });



    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.setDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);
}

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            tw.setText("Camera");
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}