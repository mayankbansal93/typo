package my.example.mayank.alphabets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mayank.alphabets.R;

import java.util.List;

/**
 * Created by mayank on 13/9/15.
 */
public class ListAdapter extends BaseAdapter {
    List<String> data1,data2;
    Context context;
    public ListAdapter(Context context,List<String> data1,List<String> data2){
        this.context=context;
        this.data1=data1;
        this.data2=data2;
    }
    @Override
    public int getCount() {
        return data1.size();
    }

    @Override
    public Object getItem(int i) {
        return data1.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_item, viewGroup, false);
        } else{
            v = view;
        }

        TextView t1 = (TextView) v.findViewById(R.id.t1);
        TextView t2 = (TextView) v.findViewById(R.id.t2);

        t1.setText(data1.get(i));
        t2.setText(data2.get(i));
        return v;
    }
}
