package tmalpha.procuredinc.com.procuredalpha;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserLoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static EditText uName;
    private static EditText pWord;
    private static Button login;
    Context context = this;

    //private static Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        uName = (EditText) findViewById(R.id.etUname);
        pWord = (EditText) findViewById(R.id.etPword);
        login = (Button) findViewById(R.id.bLogin);

        Button setUser = (Button) findViewById(R.id.bSetUser);
        Button resetDb = (Button) findViewById(R.id.bResetDb);

        login.setOnClickListener(this);
        setUser.setOnClickListener(this);
        resetDb.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bLogin: {
                DbOps dbo = new DbOps(getApplicationContext());
                Cursor CR = dbo.getInformation(dbo);
                boolean loginStatus = false;
                CR.moveToFirst();
                do {
                    if (uName.getText().toString().equals(CR.getString(0)) && pWord.getText().toString().equals(CR.getString(1))) {
                        loginStatus = true;
                    }
                } while (CR.moveToNext());

                if (loginStatus) {
                    Toast.makeText(getApplicationContext(), "Valid Login", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "The username or password is incorrect", Toast.LENGTH_SHORT).show();
                }

//                if (uName.getText().toString().equals("procured") && pWord.getText().toString().equals("cherry")) {
//                    Toast.makeText(getApplicationContext(), "Valid Login", Toast.LENGTH_SHORT).show();
//
//                    Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
//                    startActivity(intent);
//
//                } else {
//                    Toast.makeText(getApplicationContext(), "The username or password is incorrect", Toast.LENGTH_SHORT).show();
//                }
                break;
            }

            //ViewPager // DrawerLayout //NavigationView
            case R.id.bSetUser: {
                DbOps dbo = new DbOps(context);
                dbo.putInformation(dbo, "procured", "cherry");

//                Cursor CR = dbo.getInformation(dbo);
//                CR.moveToFirst();
//                String[] USERNAME = {"procured","1NT12CS099","nuzha"};
//                String[] PASSWORD = {"cherry"};
//                boolean check=true;
//                for(int ix=0;ix<USERNAME.length-1;ix++){
//                    do {
//                        if (USERNAME[ix].equals(CR.getString(0))) {
//                            check = false;
//                        }
//                    } while (CR.moveToNext());
//                    if(check){
//                        dbo.putInformation(dbo, USERNAME[ix], PASSWORD[0]);
//                        Toast.makeText(getApplicationContext(), "Row Created! UN: "+USERNAME[ix], Toast.LENGTH_SHORT).show();
//                    }
//                }

//                dbo.putInformation(dbo, USERNAME[ix], PASSWORD[0]);
                Toast.makeText(getApplicationContext(), "Row Created! UN: ", Toast.LENGTH_SHORT).show();//+USERNAME[ix], Toast.LENGTH_SHORT).show();

                break;
            }
            case R.id.bResetDb:{
                DbOps dbo = new DbOps(getApplicationContext());
                dbo.deleteAll(dbo);
                Toast.makeText(getApplicationContext(), "Table Deleted!",Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }
}
