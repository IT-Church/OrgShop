package kikos.org.colorgame;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.MotionEvent;
import android.view.View;


public class FullscreenActivity extends AppCompatActivity {

    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Mech.points = 100;
        Mech.score = 0;
        ctx = this;
        final StartActivity sa = new StartActivity(this);
        setContentView(sa);
        sa.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getX() > sa.xt && event.getX() < sa.xt + sa.src.getWidth() &&
                        event.getY() > sa.yt && event.getY() < sa.yt + sa.src.getWidth()) {
                    Intent intent = new Intent();
                    intent.setClass(ctx, MainActivity.class);
                    startActivity(intent);
                }
                if (event.getX() > sa.xq && event.getX() < sa.xq + sa.srcq.getWidth() &&
                        event.getY() > sa.yq && event.getY() < sa.yq + sa.srcq.getWidth()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                    builder.setMessage("This game is based on RGB code. \n" +
                            "After you start a game you'll see a color in the center of the screen\n" +
                            "Remember the color and tap on it, you'll see a black color in the center \n" +
                            "and Red, Green, Blue Buttons - each of them increments RGB of center color\n" +
                            "After you make your center color look like first Color, tap on the center\n" +
                            "And you'll see the difference.\n" +
                            "You have 100 points(lifes), and you'll loose one point for each RGB point\n" +
                            "NOTE: There is no undo button, it may be unfair, but it's my game and my rules ^^");
                    builder.setNegativeButton("ОК",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog ad = builder.create();
                    ad.show();
                }
                return false;
            }
        });
    }


}
