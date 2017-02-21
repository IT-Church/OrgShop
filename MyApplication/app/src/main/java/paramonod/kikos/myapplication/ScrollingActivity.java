package paramonod.kikos.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class ScrollingActivity extends AppCompatActivity {
Context ctx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        ctx = this;

        ListView sw = (ListView) findViewById(R.id.scroll);
        String[] names = {"a", "aba", "abacaba", "abacabadaba"};
        MyAdapter adapter = new MyAdapter(ctx,names);

        // присваиваем адаптер списку
        sw.setAdapter(adapter);
sw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String s =(String ) parent.getItemAtPosition(position);
        Intent i = new Intent(ctx,Empty.class);
        i.putExtra("description",s);
        startActivity(i);
    }
});

    }
}
