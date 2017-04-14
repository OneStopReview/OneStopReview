package onestopreview.codepath.onestopreview.activities;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import org.json.JSONArray;
import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import onestopreview.codepath.onestopreview.R;
import onestopreview.codepath.onestopreview.api.Facebook;
import onestopreview.codepath.onestopreview.helpers.Utils;
import onestopreview.codepath.onestopreview.interfaces.ResultsProcessor;
import onestopreview.codepath.onestopreview.models.ResultItem;
import onestopreview.codepath.onestopreview.models.SearchParams;
import onestopreview.codepath.onestopreview.models.facebook.PlacesSearchResult;

public class MainActivity extends BaseActivity implements ResultsProcessor{

    private Facebook fbApi = new Facebook();
    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private SearchParams searchParam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppEventsLogger.activateApp(getApplication());

        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");
        // Other app specific specialization

        callbackManager = CallbackManager.Factory.create();
        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                Log.i("LOGINRESULT", "Got AccessToken: " + loginResult.getAccessToken());

            }

            @Override
            public void onCancel() {
                // App code
                Log.i("LOGINRESULT", " On cancel called!");
            }

            @Override
            public void onError(FacebookException exception) {
                exception.printStackTrace();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    public void btnTestApi_onclick(View view) {

        final Location location = new Location("");
        location.setLatitude(47.610150);
        location.setLongitude(-122.201516);

        searchParam = new SearchParams("pizza", location, Utils.GetMeters(10), 100);
        fbApi.DoSearch(searchParam,this);
    }

    @Override
    public void ProcessResults(List<ResultItem> results) {
        //!!!!IMPORTANT : Parceler only works with ArrayList for the top level collection types!!!
        //Do not use : List<>, Arrays or any other type
        //https://github.com/johncarl81/parceler/issues/18

        Intent i = new Intent(MainActivity.this, LandingActivity.class);
        i.putExtra(LandingActivity.SEARCH_RESULTS, Parcels.wrap(results));
        i.putExtra(LandingActivity.SEARCH_PARAMS, Parcels.wrap(searchParam));
        startActivity(i);
    }
}
