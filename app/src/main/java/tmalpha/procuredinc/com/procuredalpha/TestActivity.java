package tmalpha.procuredinc.com.procuredalpha;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {

    private static TextView finalCountdown;
    private static long testTime= 1;    //60;   //in minutes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        finalCountdown = (TextView) findViewById(R.id.bFinalCountdown);

        new CountDownTimer(testTime*60000, 1000) {

            public void onTick(long millisUntilFinished) {
                long min = millisUntilFinished/60000;
                long secs = (millisUntilFinished-min*60000)/1000;
                finalCountdown.setText( min+ ":" +secs);
            }

            public void onFinish() {
                Toast.makeText(getApplicationContext(),"Time's Up!",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),EndTestActivity.class));
            }
        }.start();
    }
}
