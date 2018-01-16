package dhirajnayak.com.a24x7weather.SplashScreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.github.ybq.android.spinkit.SpinKitView;

import dhirajnayak.com.a24x7weather.Utility.Connection;
import dhirajnayak.com.a24x7weather.Utility.IConnection;
import dhirajnayak.com.a24x7weather.R;
import dhirajnayak.com.a24x7weather.SearchScreen.SearchCityActivity;
import dhirajnayak.com.a24x7weather.WeatherScreen.WeatherActivity;

public class SplashActivity extends AppCompatActivity implements ISplashActivityView {


    SplashActivityPresenter presenter;
    SharedPreferences preferences;
    SpinKitView spinKitView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        spinKitView=findViewById(R.id.spin_kit);
        preferences= PreferenceManager.getDefaultSharedPreferences(this);
        ISplashActivityView view=this;
        IConnection connection=new Connection(this);
        presenter=new SplashActivityPresenter(view,connection,preferences);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                presenter.isActiveConnection();
            }
        }, 3000);

    }

    @Override
    public void internetConnectionFailed() {
        Toast.makeText(this,"Please make sure you are connected to Internet",Toast.LENGTH_LONG).show();
        spinKitView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void internetConnectionSuccess() {
        presenter.getCurrentCity();
    }

    @Override
    public void haveCurrentCity() {
        Intent intent=new Intent(SplashActivity.this, WeatherActivity.class);
        startActivity(intent);
    }

    @Override
    public void noCurrentCity() {
        Intent intent=new Intent(SplashActivity.this, SearchCityActivity.class);
        startActivity(intent);
    }

}
