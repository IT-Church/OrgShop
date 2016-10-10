package kikos.org.colorgame;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    public AsyncTask asyncTask;
    public static Context ctx;
    public static Malevich m1;
    public static int[] play;
    public static int[] start;
    MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ctx = this;
        start = Mech.randomizeColor();
        play = new int[]{1, 1, 1};
        mainActivity = this;
        Malevich m = new Malevich(this, start);
        setContentView(m);



        m.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                m1 = new Malevich(ctx, new int[]{1, 1, 1});
                setContentView(MainActivity.m1);
                m1.setOnTouchListener(new MyListener(mainActivity));
                return false;
            }
        });

    }


    public void changeColorRed() {
        if (play[0] < 16) {
            Malevich m2 = new Malevich(ctx, new int[]{++play[0], play[1], play[2]});
            setContentView(m2);
            m2.setOnTouchListener(new MyListener(this));
        }
    }

    public void changeColorGreen() {
        if (play[1] < 16) {
            Malevich m2 = new Malevich(ctx, new int[]{play[0], ++play[1], play[2]});
            setContentView(m2);
            m2.setOnTouchListener(new MyListener(this));
        }
    }

    public void changeColorBlue() {
        if (play[2] < 16) {
            Malevich m2 = new Malevich(ctx, new int[]{play[0], play[1], ++play[2]});
            setContentView(m2);
            m2.setOnTouchListener(new MyListener(this));
        }
    }

    public void endGame() {
        Mech.points -=  Math.abs(play[0] - start[0]) + Math.abs(play[1] - start[1])+ Math.abs(play[2] - start[2]);
        CheckView cv = new CheckView(ctx, start, play);
        setContentView(cv);
        cv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (Mech.points > 0) {
                    Intent intent = new Intent();
                    intent.setClass(ctx,MainActivity.class);
                    startActivity(intent);
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                    builder.setTitle("EndGame");
                    builder.setMessage("You score " + Integer.toString(Mech.score));
                    builder.setCancelable(false);
                    builder.setNegativeButton("ОК",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    Intent intent = new Intent();
                                    intent.setClass(ctx, FullscreenActivity.class);
                                    startActivity(intent);
                                }
                            });
                    AlertDialog ad = builder.create();
                    ad.show();
                }
                return false;
            }
        });
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setTitle("Result")
                .setMessage("First color was " + Integer.toString(start[0] - 1) + " " +
                        Integer.toString(start[1] - 1) + " " +
                        Integer.toString(start[2] - 1) +
                        "\n" +
                        "Second color was " +
                        Integer.toString(play[0] - 1) + " " +
                        Integer.toString(play[1] - 1) + " " +
                        Integer.toString(play[2] - 1) + "\n" +
                        "You loose " + Integer.toString(
                        Math.abs(play[0] - start[0]) + Math.abs(play[1] - start[1]) + Math.abs(play[2] - start[2])) + " points\n" +
                        "Now you have " + Integer.toString(Mech.points))
                .setNegativeButton("ОК",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });


        Mech.score++;
        AlertDialog alert = builder.create();
        alert.show();
    }
}
