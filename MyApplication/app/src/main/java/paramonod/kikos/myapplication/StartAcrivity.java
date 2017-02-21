package paramonod.kikos.myapplication;

import android.app.ActivityGroup;
import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;

public class StartAcrivity extends ActivityGroup{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_acrivity);
        TabHost th = (TabHost)findViewById(R.id.tabhost);
        Log.d("FUCKING IN DIMA'S HOME",th.toString());
        th.setup(this.getLocalActivityManager());
        TabHost.TabSpec tabSpec;
        tabSpec = th.newTabSpec("tag1");
        tabSpec.setIndicator("Вкладка 1");
        tabSpec.setContent(new Intent(this, MainActivity.class));
        th.addTab(tabSpec);

        tabSpec = th.newTabSpec("tag2");
        tabSpec.setIndicator("Вкладка 2");
        tabSpec.setContent(new Intent(this, ScrollingActivity.class));
        th.addTab(tabSpec);
    }
}
