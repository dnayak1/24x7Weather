package dhirajnayak.com.a24x7weather.SplashScreen;

import android.content.SharedPreferences;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import dhirajnayak.com.a24x7weather.Utility.IConnection;

/**
 * Created by dhirajnayak on 1/9/18.
 * unit testing for Splash Activity
 */
@RunWith(MockitoJUnitRunner.class)
public class SplashActivityPresenterTest {

    @Mock
    ISplashActivityView view;
    @Mock
    IConnection connection;

    private SplashActivityPresenter presenter;
    private SharedPreferences preferences;

    @Before
    public void setUp() throws Exception {
        presenter=new SplashActivityPresenter(view,connection,preferences);
    }

    @Test
    public void checkActiveConnection(){
        Mockito.when(connection.checkInternetConnection()).thenReturn(true);
        presenter.isActiveConnection();
        Mockito.verify(view).internetConnectionSuccess();
    }

    @Test
    public void checkInActiveConnection(){
        Mockito.when(connection.checkInternetConnection()).thenReturn(false);
        presenter.isActiveConnection();
        Mockito.verify(view).internetConnectionFailed();
    }


}