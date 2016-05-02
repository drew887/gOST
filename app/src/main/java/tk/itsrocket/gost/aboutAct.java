package tk.itsrocket.gost;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

public class aboutAct extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        try{
            ((TextView)findViewById(R.id.googleLicenseAboutTv)).setText
                    (getIntent().getStringExtra("googleCopyright"));
        }catch(NullPointerException ne){
            Toast.makeText(getApplicationContext(), "Oh noes! Is google play" +
                    " not installed?", Toast.LENGTH_SHORT).show();
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
