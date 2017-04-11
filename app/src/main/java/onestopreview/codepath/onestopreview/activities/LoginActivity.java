package onestopreview.codepath.onestopreview.activities;

import android.content.Intent;
import android.os.Bundle;

import com.parse.ui.ParseLoginBuilder;

import onestopreview.codepath.onestopreview.R;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ParseLoginBuilder builder = new ParseLoginBuilder(LoginActivity.this);
        startActivityForResult(builder.build(), 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 0){
            if(resultCode == RESULT_OK){
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        }
    }
}
