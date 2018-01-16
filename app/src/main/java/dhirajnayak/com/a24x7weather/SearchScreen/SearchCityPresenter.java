package dhirajnayak.com.a24x7weather.SearchScreen;

import java.util.ArrayList;

import dhirajnayak.com.a24x7weather.Model.City;
import io.reactivex.Observable;

/**
 * Created by dhirajnayak on 1/11/18.
 * Search city presenter to load city search results into the view
 */

public class SearchCityPresenter {
    private ICityRepository repository;
    private ISearchCityView view;

    public SearchCityPresenter(ICityRepository repository, ISearchCityView view) {
        this.repository = repository;
        this.view = view;
    }

    //return list of cities based on search query
    public Observable<ArrayList<City>> loadCities(String searchText){
        return repository.dataFromNetwork(searchText);

    }


}
