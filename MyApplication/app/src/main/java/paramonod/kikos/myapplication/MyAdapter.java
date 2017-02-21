package paramonod.kikos.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Varvara on 27.12.2016.
 */

public class MyAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final String[] values;

    public MyAdapter(Context context, String[] values) {
        super(context, R.layout.mylistitem, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.mylistitem, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.qwe);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.qw);
        textView.setText(values[position]);
        String s = values[position];
        if (s.startsWith("abacaba")){
            imageView.setImageDrawable(MainActivity.createScaledIcon(context.getResources().getDrawable(R.drawable.shop),100,100,context.getResources())
            );
        } else {
            imageView.setImageDrawable(MainActivity.createScaledIcon(context.getResources().getDrawable(R.drawable.itkerk),100,100,context.getResources()));
        }

        return rowView;
    }
}

