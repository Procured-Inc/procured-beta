package tmalpha.procuredinc.com.procuredalpha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartTestActivity extends AppCompatActivity {

    private static Button bStartTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_test);

        bStartTest = (Button) findViewById(R.id.bStartTest);

        bStartTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), TestActivity.class));
            }
        });
    }
}
