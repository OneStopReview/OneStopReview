package onestopreview.codepath.onestopreview;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.parse.Parse;
import com.parse.ParseFacebookUtils;
import com.parse.ParseTwitterUtils;
import com.parse.interceptors.ParseStethoInterceptor;

public class OneStopApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Stetho.InitializerBuilder initializerBuilder = Stetho.newInitializerBuilder(this);

        //Enable chrome Dev tools
        initializerBuilder.enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this));

        //Enable command line interface
        initializerBuilder.enableDumpapp(Stetho.defaultDumperPluginsProvider(getApplicationContext()));

        //Use the InitializerBuuilder to generate an initializer
        Stetho.Initializer initializer = initializerBuilder.build();

        //Initialize Stetho with intializer
        Stetho.initialize(initializer);

        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);



        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("C8DD662D230F4906BA1DA65DF1BD1D57")
                .addNetworkInterceptor(new ParseStethoInterceptor())
                .server("https://onestopreview.herokuapp.com/parse/").build());

       ParseTwitterUtils.initialize(getString(R.string.twitter_consumer_key),
               getString(R.string.twitter_consumer_secret));

        ParseFacebookUtils.initialize(this);



    }


}
