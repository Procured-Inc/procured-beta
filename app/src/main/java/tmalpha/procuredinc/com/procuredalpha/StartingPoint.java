package tmalpha.procuredinc.com.procuredalpha;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.facebook.FacebookSdk.getApplicationContext;

public class StartingPoint extends AppCompatActivity implements View.OnClickListener {
    private static EditText config;
    private static Button submit;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_point);

        config = (EditText) findViewById(R.id.etConfig);
        submit = (Button) findViewById(R.id.bSubmit);

        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bSubmit: {
                if (config.getText().toString().equals("Incture")) {
                    Toast.makeText(getApplicationContext(), "Valid Token", Toast.LENGTH_SHORT).show();

                    Intent goToLogin = new Intent(getApplicationContext(), UserLoginActivity.class);
                    goToLogin.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getApplicationContext().startActivity(goToLogin);

                } else {
                    Toast.makeText(getApplicationContext(), "The configuration token is incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
