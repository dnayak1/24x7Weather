package dhirajnayak.com.a24x7weather.SearchScreen;



import java.util.ArrayList;
import java.util.List;

import dhirajnayak.com.a24x7weather.Model.City;
import io.reactivex.Observable;

/**
 * Created by dhirajnayak on 1/11/18.
 * contains method for getting data from network
 */

public interface ICityRepository {
    public Observable<ArrayList<City>> dataFromNetwork(String searchText);
}
