package dhirajnayak.com.a24x7weather.SplashScreen;

import android.content.SharedPreferences;

import dhirajnayak.com.a24x7weather.Utility.IConnection;

/**
 * Created by dhirajnayak on 1/9/18.
 */

public class SplashActivityPresenter{
    ISplashActivityView view;
    IConnection connection;
    SharedPreferences preferences;

    public SplashActivityPresenter(ISplashActivityView view, IConnection connection, SharedPreferences preferences) {
        this.view = view;
        this.connection=connection;
        this.preferences=preferences;
    }

    public void isActiveConnection(){
        if(connection.checkInternetConnection()){
            view.internetConnectionSuccess();
        }else{
            view.internetConnectionFailed();
        }
    }

    public void getCurrentCity(){
        String currentCity= preferences.getString("currentCity",null);
        if(currentCity!=null){
            view.haveCurrentCity();
        }else{
            view.noCurrentCity();
        }

    }
}

