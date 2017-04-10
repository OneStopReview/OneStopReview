package onestopreview.codepath.onestopreview.activities;

import android.os.Bundle;

import com.parse.ui.ParseLoginBuilder;

import onestopreview.codepath.onestopreview.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParseLoginBuilder builder = new ParseLoginBuilder(MainActivity.this);
        startActivityForResult(builder.build(), 0);
    }
}
