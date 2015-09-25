package my.example.mayank.alphabets;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.Handler;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
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

public class Digits extends Activity {
    EditText et;
    MediaPlayer mp;
    Button b;
    Boolean check=false,clear=false;
    ImageView iv,iv1,iv2,heart;
    TextView tv;
    int count=0;
    int n1=0,n2=0,n3=0;
    int delay1=1,delay2=1,delay3=1;
    int id1,id2,id3;
    int id11=0,id21=0,id31=0;
    int count1=0;
    int n=0;
    int height,width;
    AlertDialog.Builder adb;
    AlertDialog ad;
    int []a={
            R.drawable.zero,R.drawable.one,R.drawable.two, R.drawable.three, R.drawable.four,
            R.drawable.five,R.drawable.six,R.drawable.seven,R.drawable.eight,R.drawable.nine

    };
    Stack<Integer> st=new Stack<>();
    Handler h1,h2,h3;
    Random ran=new Random();
    RelativeLayout rl;
    Runnable r=new Runnable() {
        @Override
        public void run() {
            iv.setY(iv.getY() + 3 + n1);
            if(iv.getY()>=-200){
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
                if(count<=30) {
                    id1 = a[ran.nextInt(10)];
                    iv.setImageResource(id1);
                }else{
                    id1=a[ran.nextInt(9)+1];
                    id11=a[ran.nextInt(9)+1];
                    Bitmap i1= BitmapFactory.decodeResource(getResources(),id1);
                    Bitmap i2=BitmapFactory.decodeResource(getResources(),id11);
                    Bitmap i3=Bitmap.createBitmap(i1.getWidth()+i2.getWidth(), i1.getHeight(), i1.getConfig());
                    Canvas c=new Canvas(i3);
                    c.drawBitmap(i1, 0, 0, null);
                    c.drawBitmap(i2, i1.getWidth(), 0, null);
                    iv.setImageBitmap(i3);
                }
                n1=ran.nextInt(5)+n;
                iv.setY(-300);
                iv.setX(ran.nextInt(width) + 50);
                delay1=ran.nextInt(200);
            }
        }
    };
    Runnable r1=new Runnable() {
        @Override
        public void run() {
            iv1.setY(iv1.getY() + 3 + n2);
            if(iv1.getY()>=-200){
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
                if(count<=30) {
                    id2 = a[ran.nextInt(10)];
                    iv1.setImageResource(id2);
                }else{
                    id2=a[ran.nextInt(9)+1];
                    id21=a[ran.nextInt(9)+1];
                    Bitmap i1= BitmapFactory.decodeResource(getResources(),id2);
                    Bitmap i2=BitmapFactory.decodeResource(getResources(),id21);
                    Bitmap i3=Bitmap.createBitmap(i1.getWidth()+i2.getWidth(), i1.getHeight(), i1.getConfig());
                    Canvas c=new Canvas(i3);
                    c.drawBitmap(i1, 0, 0, null);
                    c.drawBitmap(i2, i1.getWidth(), 0, null);
                    iv1.setImageBitmap(i3);
                }
                iv1.setY(-300);
                n2=ran.nextInt(5)+n;
                iv1.setX(ran.nextInt(width)+50);
                delay2=ran.nextInt(100);
            }
        }
    };

    Runnable r2=new Runnable() {
        @Override
        public void run() {
            iv2.setY(iv2.getY() + 3 + n3);
            if(iv2.getY()>=-200){
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
                if(count<=30) {
                    id3 = a[ran.nextInt(10)];
                    iv2.setImageResource(id3);
                }else{
                    id3=a[ran.nextInt(9)+1];
                    id31=a[ran.nextInt(9)+1];
                    Bitmap i1= BitmapFactory.decodeResource(getResources(),id3);
                    Bitmap i2=BitmapFactory.decodeResource(getResources(),id31);
                    Bitmap i3=Bitmap.createBitmap(i1.getWidth()+i2.getWidth(), i1.getHeight(), i1.getConfig());
                    Canvas c=new Canvas(i3);
                    c.drawBitmap(i1, 0, 0, null);
                    c.drawBitmap(i2, i1.getWidth(), 0, null);
                    iv2.setImageBitmap(i3);
                }
                iv2.setY(-300);
                n3=ran.nextInt(5)+n;
                iv2.setX(ran.nextInt(width)+50);
                delay3=ran.nextInt(100);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digits);
        InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        im.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
        mp=MediaPlayer.create(getApplicationContext(),R.raw.tap);
        Display d=getWindowManager().getDefaultDisplay();
        Point p=new Point();
        d.getSize(p);
        width=(int)(p.x*((double)7/10));
        height=(int)((p.y)*((double)12/19));

        //    mp=MediaPlayer.create(getApplicationContext(),R.raw.music);
        //    mp.setLooping(true);
        //    mp.start();
        et = (EditText) findViewById(R.id.et1);
        tv = (TextView) findViewById(R.id.tv1);
        RelativeLayout.LayoutParams ll=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams ll1=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ll.setMargins(0,(int)(height*((double)5/9)),0,0);
        et.setLayoutParams(ll);
        ll1.setMargins((int) (width), 0, 0, 0);
        tv.setLayoutParams(ll1);
        st.push(R.id.h1);
        st.push(R.id.h2);
        st.push(R.id.h3);
        st.push(R.id.h4);
        heart = (ImageView) findViewById(R.id.h5);

        iv = new ImageView(getApplicationContext());
    //    iv.setAdjustViewBounds(true);
    //    iv.setMaxHeight(200);
    //    iv.setMaxWidth(200);
        rl = (RelativeLayout) findViewById(R.id.rl);
        iv.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        if (count <= 30) {
            id1 = a[ran.nextInt(10)];
            iv.setImageResource(id1);
        } else {
            id1 = a[ran.nextInt(9) + 1];
            id11 = a[ran.nextInt(9) + 1];
            Bitmap i1 = BitmapFactory.decodeResource(getResources(), id1);
            Bitmap i2 = BitmapFactory.decodeResource(getResources(), id11);
            Bitmap i3 = Bitmap.createBitmap(i1.getWidth() + i2.getWidth(), i1.getHeight(), i1.getConfig());
            Canvas c = new Canvas(i3);
            c.drawBitmap(i1, 0, 0, null);
            c.drawBitmap(i2, i1.getWidth(), 0, null);
            iv.setImageBitmap(i3);
        }
        rl.addView(iv);
        iv.setX(ran.nextInt(width) + 50);
        iv.setY(-300);
        h1 = new Handler();
        h1.post(r);

        iv1 = new ImageView(getApplicationContext());
    //    iv1.setAdjustViewBounds(true);
    //    iv1.setMaxHeight(200);
    //    iv1.setMaxWidth(200);
        iv1.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        if (count <= 30) {
            id2 = a[ran.nextInt(10)];
            iv1.setImageResource(id2);
        } else {
            id2 = a[ran.nextInt(9) + 1];
            id21 = a[ran.nextInt(9) + 1];
            Bitmap i1 = BitmapFactory.decodeResource(getResources(), id2);
            Bitmap i2 = BitmapFactory.decodeResource(getResources(), id21);
            Bitmap i3 = Bitmap.createBitmap(i1.getWidth() + i2.getWidth(), i1.getHeight(), i1.getConfig());
            Canvas c = new Canvas(i3);
            c.drawBitmap(i1, 0, 0, null);
            c.drawBitmap(i2, i1.getWidth(), 0, null);
            iv1.setImageBitmap(i3);
        }
        rl.addView(iv1);
        iv1.setX(ran.nextInt(width) + 50);
        iv1.setY(-300);
        h2 = new Handler();
        h2.postDelayed(r1, 4000);

        iv2 = new ImageView(getApplicationContext());
    //    iv2.setAdjustViewBounds(true);
    //    iv2.setMaxHeight(200);
    //    iv2.setMaxWidth(200);
        iv2.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        if (count <= 30) {
            id3 = a[ran.nextInt(10)];
            iv2.setImageResource(id3);
        } else {
            id3 = a[ran.nextInt(9) + 1];
            id31 = a[ran.nextInt(9) + 1];
            Bitmap i1 = BitmapFactory.decodeResource(getResources(), id3);
            Bitmap i2 = BitmapFactory.decodeResource(getResources(), id31);
            Bitmap i3 = Bitmap.createBitmap(i1.getWidth() + i2.getWidth(), i1.getHeight(), i1.getConfig());
            Canvas c = new Canvas(i3);
            c.drawBitmap(i1, 0, 0, null);
            c.drawBitmap(i2, i1.getWidth(), 0, null);
            iv2.setImageBitmap(i3);
        }
        rl.addView(iv2);
        iv2.setX(ran.nextInt(width) + 50);
        iv2.setY(-300);
        h3 = new Handler();
        h3.postDelayed(r2, 7000);

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
                if(count<=30) {
                    editable.clear();
                }else{
                    if(id11==0 || id21==0 || id31==0){
                            if(clear) {
                                editable.clear();
                                clear=false;
                            }else{
                                if(editable.length()>=2){
                                    editable.clear();
                                }
                            }
                    }else{
                        if(editable.length()==2){
                            editable.clear();
                        }
                    }
                }
            }
        });

    /*    et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i== EditorInfo.IME_ACTION_DONE){
                    actionPerformed();
                    return true;
                }
                return false;
            }
        });

        b=(Button)findViewById(R.id.b1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionPerformed();
            }
        });
        */
    }

    public void gameover(){
        LayoutInflater lf=LayoutInflater.from(Digits.this);
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
                File f = new File("/sdcard/digits.txt");
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
                String arr[][] = new String[index][2];
                for (int l = 0; l < index; l++) {
                    arr[l][0] = array[l][0];
                    arr[l][1] = array[l][1];

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
                        File ff = new File(Environment.getExternalStorageDirectory(), "digits.txt");
                        FileOutputStream fo = new FileOutputStream(ff);
                        for (int k = 0; k < 100 && k < index; k++) {
                            fo.write((arr[k][1] + "     " + arr[k][0] + "\n").getBytes());
                        }
                        fo.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            //    mp.stop();
            //    mp.release();
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
    //    mp.stop();
    //    mp.release();
        finish();
    }

    public void actionPerformed(String s){
        if(count<=30){
            if (s.length() == 1 && s.charAt(0)>=48 && s.charAt(0)<=57) {
                int id = a[(int)s.charAt(0)-48];
                if(id1==id && id2==id && id3==id){
                    check=true;
                    if(iv.getY()>=iv1.getY() && iv.getY()>=iv2.getY()){
                        setid1();
                    }else if(iv1.getY()>=iv2.getY() && iv1.getY()>=iv.getY()){
                        setid2();
                    }else{
                        setid3();
                    }
                }else if(id1==id && id2==id){
                    check=true;
                    if(iv.getY()>=iv1.getY()){
                        setid1();
                    }else{
                        setid2();
                    }
                }else if(id1==id && id3==id){
                    check=true;
                    if(iv.getY()>=iv2.getY()){
                        setid1();
                    }else{
                        setid3();
                    }
                }else if(id2==id && id3==id){
                    check=true;
                    if(iv1.getY()>=iv2.getY()){
                        setid2();
                    }else{
                        setid3();
                    }
                } else if (id1 == id) {
                    setid1();
                } else if (id2 == id) {
                    setid2();
                } else if (id3 == id) {
                    setid3();
                }
            }
        }if(count>30){
            if(s.length()==1 && s.charAt(0)>=48 && s.charAt(0)<=57){
                int id=a[(int)s.charAt(0)-48];
                if(id11==0 && id1==id){
                    setid11();
                    clear=true;
                }else if(id21==0 && id2==id){
                    setid21();
                    clear=true;
                }else if(id31==0 && id3==id){
                    setid31();
                    clear=true;
                }
            }
            if(s.length()==2 && s.charAt(0)>=48 && s.charAt(1)>=48 && s.charAt(0)<=57 && s.charAt(1)<=57){
                int ida=a[(int)s.charAt(0)-48];
                int idb=a[(int)s.charAt(1)-48];
                if(id1==ida && id11==idb){
                    setid11();
                }else if(id2==ida && id21==idb){
                    setid21();
                }else if(id3==ida && id31==idb){
                    setid31();
                }
            }
        }
        if(count%7==0 && count!=0 && check){
            check=false;
            n+=1;
        }
    }

    public void setid1(){
        mp=MediaPlayer.create(getApplicationContext(),R.raw.tap);
        mp.start();
        check=true;
        id1 = a[ran.nextInt(10)];
        iv.setImageResource(id1);
        n1 = ran.nextInt(5)+n;
        iv.setY(-300);
        iv.setX(ran.nextInt(width) + 50);
        delay1 = ran.nextInt(200);
        count++;
        tv.setText(Integer.toString(count));
    }

    public void setid2(){
        mp=MediaPlayer.create(getApplicationContext(),R.raw.tap);
        mp.start();
        check=true;
        id2 = a[ran.nextInt(10)];
        iv1.setImageResource(id2);
        iv1.setY(-300);
        n2 = ran.nextInt(5)+n;
        iv1.setX(ran.nextInt(width) + 50);
        delay2 = ran.nextInt(100);
        count++;
        tv.setText(Integer.toString(count));
    }

    public void setid3(){
        mp=MediaPlayer.create(getApplicationContext(),R.raw.tap);
        mp.start();
        check=true;
        id3 = a[ran.nextInt(10)];
        iv2.setImageResource(id3);
        iv2.setY(-300);
        n3 = ran.nextInt(5)+n;
        iv2.setX(ran.nextInt(width) + 50);
        delay3 = ran.nextInt(100);
        count++;
        tv.setText(Integer.toString(count));
    }

    public void setid11(){
        mp=MediaPlayer.create(getApplicationContext(),R.raw.tap);
        mp.start();
        check=true;
        id1=a[ran.nextInt(9)+1];
        id11=a[ran.nextInt(9)+1];
        Bitmap i1= BitmapFactory.decodeResource(getResources(),id1);
        Bitmap i2=BitmapFactory.decodeResource(getResources(),id11);
        Bitmap i3=Bitmap.createBitmap(i1.getWidth()+i2.getWidth(), i1.getHeight(), i1.getConfig());
        Canvas c=new Canvas(i3);
        c.drawBitmap(i1,0,0,null);
        c.drawBitmap(i2,i1.getWidth(),0,null);
        iv.setImageBitmap(i3);
        n1 = ran.nextInt(5)+n;
        iv.setY(-300);
        iv.setX(ran.nextInt(width) + 50);
        delay1 = ran.nextInt(200);
        count++;
        tv.setText(Integer.toString(count));
    }

    public void setid21(){
        mp=MediaPlayer.create(getApplicationContext(),R.raw.tap);
        mp.start();
        check=true;
        id2=a[ran.nextInt(9)+1];
        id21=a[ran.nextInt(9)+1];
        Bitmap i1= BitmapFactory.decodeResource(getResources(),id2);
        Bitmap i2=BitmapFactory.decodeResource(getResources(),id21);
        Bitmap i3=Bitmap.createBitmap(i1.getWidth()+i2.getWidth(), i1.getHeight(), i1.getConfig());
        Canvas c=new Canvas(i3);
        c.drawBitmap(i1,0,0,null);
        c.drawBitmap(i2,i1.getWidth(),0,null);
        iv1.setImageBitmap(i3);
        iv1.setY(-300);
        n2 = ran.nextInt(5)+n;
        iv1.setX(ran.nextInt(width) + 50);
        delay2 = ran.nextInt(100);
        count++;
        tv.setText(Integer.toString(count));
    }

    public void setid31(){
        mp=MediaPlayer.create(getApplicationContext(),R.raw.tap);
        mp.start();
        check=true;
        id3=a[ran.nextInt(9)+1];
        id31=a[ran.nextInt(9)+1];
        Bitmap i1= BitmapFactory.decodeResource(getResources(),id3);
        Bitmap i2=BitmapFactory.decodeResource(getResources(),id31);
        Bitmap i3=Bitmap.createBitmap(i1.getWidth()+i2.getWidth(), i1.getHeight(), i1.getConfig());
        Canvas c=new Canvas(i3);
        c.drawBitmap(i1,0,0,null);
        c.drawBitmap(i2,i1.getWidth(),0,null);
        iv2.setImageBitmap(i3);
        iv2.setY(-300);
        n3 = ran.nextInt(5)+n;
        iv2.setX(ran.nextInt(width) + 50);
        delay3 = ran.nextInt(100);
        count++;
        tv.setText(Integer.toString(count));
    }
}
