package my.example.mayank.alphabets;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.mayank.alphabets.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayank on 13/9/15.
 */
public class Tab2 extends android.support.v4.app.Fragment {
    ListView list;
    ListAdapter adapter;
    List<String> data1=new ArrayList<>();
    List<String> data2=new ArrayList<>();
    int i=1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        File f=new File("/sdcard/digits.txt");
        try {
            FileInputStream fin=new FileInputStream(f);
            BufferedReader br=new BufferedReader(new InputStreamReader(fin));
            String s;
            while((s=br.readLine())!=null){
                String s1[]=s.split("     ");
                data1.add(s1[0]);
                data2.add(s1[1]);
            }
            br.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        adapter=new ListAdapter(getActivity().getApplicationContext(),data1,data2);
        View v=inflater.inflate(R.layout.tab_2,container,false);
        list=(ListView)v.findViewById(R.id.lv);
        list.setAdapter(adapter);
        return v;
    }
}
