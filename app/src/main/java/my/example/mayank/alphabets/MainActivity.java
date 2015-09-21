package my.example.mayank.alphabets;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import com.example.mayank.alphabets.R;

public class MainActivity extends Activity {
    Handler h;
    Runnable r=new Runnable() {
        @Override
        public void run() {
            Intent i=new Intent(MainActivity.this,SelectType.class);
            startActivity(i);
            finish();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        h=new Handler();
        h.postDelayed(r, 2000);
    }
}
