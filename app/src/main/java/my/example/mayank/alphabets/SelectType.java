package my.example.mayank.alphabets;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mayank.alphabets.R;

public class SelectType extends Activity {
    Button b;
    ImageView iv,iv1;
    MediaPlayer mp;
    Boolean flag=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_type);
        mp=MediaPlayer.create(getApplicationContext(),R.raw.music);
        mp.setLooping(true);
        mp.start();
        b=(Button)findViewById(R.id.b1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SelectType.this, AlphabetStart.class);
                startActivity(i);
            }
        });

        b=(Button)findViewById(R.id.b2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SelectType.this,DigitStart.class);
                startActivity(i);
            }
        });
        iv=(ImageView)findViewById(R.id.iv2);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SelectType.this, Stats.class);
                startActivity(i);
            }
        });
        iv1=(ImageView)findViewById(R.id.iv4);
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag) {
                    mp.stop();
                    mp.release();
                    iv1.setImageResource(R.drawable.moff);
                    flag=false;
                }else{
                    mp=MediaPlayer.create(getApplicationContext(),R.raw.music);
                    mp.start();
                    mp.setLooping(true);
                    iv1.setImageResource(R.drawable.mon);
                    flag=true;
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(flag){
            mp.stop();
            mp.release();
        }
        finish();
    }
}
