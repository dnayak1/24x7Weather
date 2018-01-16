package dhirajnayak.com.a24x7weather.SplashScreen;

/**
 * Created by dhirajnayak on 1/9/18.
 */

public interface ISplashActivityView {
    public void internetConnectionFailed();
    public void internetConnectionSuccess();
    public void haveCurrentCity();
    public void noCurrentCity();

}
