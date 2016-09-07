package tmalpha.procuredinc.com.procuredalpha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener{

    private static Button takeTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        takeTest = (Button) findViewById(R.id.bTakeTest);

        takeTest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.bTakeTest:{
                startActivity(new Intent(getApplicationContext(), StartTestActivity.class));
                break;
            }
        }
    }

}
