package my.example.mayank.alphabets;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Point;

import android.media.MediaPlayer;
import android.os.Environment;
import android.os.Handler;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mayank.alphabets.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Stack;

public class Alphabets extends Activity {
    EditText et;
    Button b;
    MediaPlayer mp;
    ImageView iv,iv1,iv2,heart;
    TextView tv;
    int count=0;
    int n1=0,n2=0,n3=0;
    int delay1=1,delay2=1,delay3=1;
    int id1,id2,id3;
    int count1=0;
    int n=0;
    int height,width;
    Boolean check;
    AlertDialog.Builder adb;
    AlertDialog ad;
    int []a={
            R.drawable.a,R.drawable.b,R.drawable.c,
            R.drawable.d,R.drawable.e,R.drawable.f,
            R.drawable.g,
            R.drawable.h,R.drawable.i,R.drawable.j,
            R.drawable.k,R.drawable.l,R.drawable.m,
            R.drawable.n,
            R.drawable.o,R.drawable.p,R.drawable.q,
            R.drawable.r,R.drawable.s,R.drawable.t,
            R.drawable.u,
            R.drawable.v,R.drawable.w,R.drawable.x,
            R.drawable.y,R.drawable.z
    };
    Stack<Integer> st=new Stack<>();
    Handler h1,h2,h3;
    Random ran=new Random();
    RelativeLayout rl;
    Runnable r=new Runnable() {
        @Override
        public void run() {
            iv.setY(iv.getY()+3+n1);
            if(iv.getY()>=-100){
                delay1=1;
            }
            h1.postDelayed(this, delay1);
            if(iv.getY()>=height){
                count1++;
                heart.setVisibility(View.GONE);
                if(!st.isEmpty())
                    heart=(ImageView)findViewById(st.pop());
                if(count1>=5){
                    h1.removeCallbacks(this);
                    h2.removeCallbacks(r1);
                    h3.removeCallbacks(r2);
                    gameover();
                }
                id1=a[ran.nextInt(26)];
                iv.setImageResource(id1);
                n1=ran.nextInt(5)+n;
                iv.setY(-150);
                iv.setX(ran.nextInt(width) + 50);
                delay1=ran.nextInt(200);
            }
        }
    };
    Runnable r1=new Runnable() {
        @Override
        public void run() {
            iv1.setY(iv1.getY()+3+n2);
            if(iv1.getY()>=-100){
                delay2=1;
            }
            h2.postDelayed(this, delay2);
            if(iv1.getY()>=height){
                count1++;
                heart.setVisibility(View.GONE);
                if(!st.isEmpty())
                    heart=(ImageView)findViewById(st.pop());
                if(count1>=5){
                    h2.removeCallbacks(this);
                    h1.removeCallbacks(r);
                    h3.removeCallbacks(r2);
                    gameover();
                }
                id2=a[ran.nextInt(26)];
                iv1.setImageResource(id2);
                iv1.setY(-150);
                n2=ran.nextInt(5)+n;
                iv1.setX(ran.nextInt(width)+50);
                delay2=ran.nextInt(100);
            }
        }
    };

    Runnable r2=new Runnable() {
        @Override
        public void run() {
            iv2.setY(iv2.getY()+3+n3);
            if(iv2.getY()>=-100){
                delay3=1;
            }
            h3.postDelayed(this, delay3);
            if(iv2.getY()>=height){
                count1++;
                heart.setVisibility(View.GONE);
                if(!st.isEmpty())
                    heart=(ImageView)findViewById(st.pop());
                if(count1>=5){
                    h3.removeCallbacks(this);
                    h1.removeCallbacks(r);
                    h2.removeCallbacks(r1);
                    gameover();
                }
                id3=a[ran.nextInt(26)];
                iv2.setImageResource(id3);
                iv2.setY(-150);
                n3=ran.nextInt(5)+n;
                iv2.setX(ran.nextInt(width)+50);
                delay3=ran.nextInt(100);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabets);
        et=(EditText)findViewById(R.id.et1);
        RelativeLayout.LayoutParams ll=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams ll1=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        tv=(TextView)findViewById(R.id.tv1);
        st.push(R.id.h1);
        st.push(R.id.h2);
        st.push(R.id.h3);
        st.push(R.id.h4);
        heart=(ImageView)findViewById(R.id.h5);
        Display d=getWindowManager().getDefaultDisplay();
        Point p=new Point();
        d.getSize(p);
        width=(int)(p.x*((double)7/10));
        height=(int)((p.y)*((double)12/19));
        ll.setMargins(0,(int)(height*((double)5/9)),0,0);
        et.setLayoutParams(ll);
        ll1.setMargins((int) (width), 0, 0, 0);
        tv.setLayoutParams(ll1);

        iv=new ImageView(getApplicationContext());
        rl=(RelativeLayout)findViewById(R.id.rl);
        iv.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        id1=a[ran.nextInt(26)];
        iv.setImageResource(id1);
        rl.addView(iv);
        iv.setX(ran.nextInt(width) + 50);
        iv.setY(-200);
        h1=new Handler();
        h1.post(r);

        iv1=new ImageView(getApplicationContext());
        iv1.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        id2=a[ran.nextInt(26)];
        iv1.setImageResource(id2);
        rl.addView(iv1);
        iv1.setX(ran.nextInt(width)+ 50);
        iv1.setY(-200);
        h2=new Handler();
        h2.postDelayed(r1, 4000);

        iv2=new ImageView(getApplicationContext());
        iv2.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        id3=a[ran.nextInt(26)];
        iv2.setImageResource(id3);
        rl.addView(iv2);
        iv2.setX(ran.nextInt(width)+ 50);
        iv2.setY(-200);
        h3=new Handler();
        h3.postDelayed(r2, 7000);

 /*       et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i==EditorInfo.IME_ACTION_DONE){
                    actionPerformed();
                    return true;
                }
                return false;
            }
        });*/

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                actionPerformed(s.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                editable.clear();
            }
        });

    /*    b=(Button)findViewById(R.id.b1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionPerformed();
            }
        });*/
    }

    public void gameover(){
        LayoutInflater lf=LayoutInflater.from(Alphabets.this);
        View v=lf.inflate(R.layout.dialog,null);
        adb=new AlertDialog.Builder(this);
        adb.setView(v);
        final EditText et1=(EditText)v.findViewById(R.id.et);
        adb.setMessage("Your Score is "+count);
        adb.setTitle("GAME OVER");
        adb.setCancelable(false);
        adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String array[][] = new String[101][2];
                int index = 0;
                File f = new File("/sdcard/alphabet.txt");
                try {
                    FileInputStream fin = new FileInputStream(f);
                    BufferedReader br = new BufferedReader(new InputStreamReader(fin));
                    String s;
                    while ((s = br.readLine()) != null) {
                        String s1[] = s.split("     ");
                        array[index][1] = s1[0];
                        array[index][0] = s1[1];
                        index++;
                    }
                    br.close();
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
                array[index][1] = et1.getText().toString();
                array[index][0] = Integer.toString(count);
                index++;
                String arr[][]=new String[index][2];
                for(int l=0;l<index;l++){
                    arr[l][0]=array[l][0];
                    arr[l][1]=array[l][1];
                }
                Arrays.sort(arr, new Comparator<String[]>() {
                    @Override

                    public int compare(String[] a, String[] b) {
                        if (Integer.parseInt(a[0]) < Integer.parseInt(b[0])) {
                            return 1;
                        } else if (Integer.parseInt(a[0]) > Integer.parseInt(b[0])) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                });

                String storage = Environment.getExternalStorageState();
                if (storage.equals(Environment.MEDIA_MOUNTED)) {
                    try {
                        File ff = new File(Environment.getExternalStorageDirectory(), "alphabet.txt");
                        FileOutputStream fo = new FileOutputStream(ff);
                        for (int k = 0; k < 100 && k < index; k++) {
                            fo.write((arr[k][1] + "     " + arr[k][0]+"\n").getBytes());
                        }
                        fo.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                finish();
            }
        });
        ad=adb.create();
        ad.show();
    }

    @Override
    public void onBackPressed() {
        h1.removeCallbacks(r);
        h2.removeCallbacks(r1);
        h3.removeCallbacks(r2);
        finish();
    }

    public void actionPerformed(String s){
        if(s.length()==1 && s.charAt(0)>=65 && s.charAt(0)<=90){
            int id = a[(int)s.charAt(0)-65];
            if(id1==id && id2==id && id3==id){
                if(iv.getY()>=iv1.getY() && iv.getY()>=iv2.getY()){
                    setid1();
                }else if(iv1.getY()>=iv.getY() && iv1.getY()>=iv2.getY()){
                    setid2();
                }else{
                    setid3();
                }
            }else if(id1==id && id2==id){
                if(iv.getY()>=iv1.getY()){
                    setid1();
                }else{
                    setid2();
                }
            }else if(id1==id && id3==id){
                if(iv.getY()>=iv2.getY()){
                    setid1();
                }else{
                    setid3();
                }
            }else if(id2==id && id3==id){
                if(iv1.getY()>=iv2.getY()){
                    setid2();
                }else{
                    setid3();
                }
            }else if (id1 == id) {
                setid1();
            }else if(id2==id){
                setid2();
            }else if(id3==id){
                setid3();
            }
        }
        if(count%15==0 && count!=0 && check){
            check=false;
            n+=1;
        }
    }

    public void setid1(){
        mp=MediaPlayer.create(getApplicationContext(),R.raw.tap);
        mp.start();
        check=true;
        id1=a[ran.nextInt(26)];
        iv.setImageResource(id1);
        n1=ran.nextInt(5)+n;
        iv.setY(-150);
        iv.setX(ran.nextInt(width) + 50);
        delay1=ran.nextInt(200);
        count++;
        tv.setText(Integer.toString(count));
    }

    public void setid2(){
        mp=MediaPlayer.create(getApplicationContext(),R.raw.tap);
        mp.start();
        check=true;
        id2=a[ran.nextInt(26)];
        iv1.setImageResource(id2);
        iv1.setY(-150);
        n2=ran.nextInt(5)+n;
        iv1.setX(ran.nextInt(width) + 50);
        delay2=ran.nextInt(100);
        count++;
        tv.setText(Integer.toString(count));
    }

    public void setid3(){
        mp=MediaPlayer.create(getApplicationContext(),R.raw.tap);
        mp.start();
        check=true;
        id3=a[ran.nextInt(26)];
        iv2.setImageResource(id3);
        iv2.setY(-150);
        n3=ran.nextInt(5)+n;
        iv2.setX(ran.nextInt(width)+ 50);
        delay3=ran.nextInt(100);
        count++;
        tv.setText(Integer.toString(count));
    }
}
