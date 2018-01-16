package dhirajnayak.com.a24x7weather.SearchScreen;

import java.util.ArrayList;

import dhirajnayak.com.a24x7weather.Model.City;
import io.reactivex.Observable;

/**
 * Created by dhirajnayak on 1/11/18.
 * interface for setting recycler view in SearchCityActivity
 */

public interface ISearchCityView {
    public void setCityRecyclerView(ArrayList<City> cities);
}
