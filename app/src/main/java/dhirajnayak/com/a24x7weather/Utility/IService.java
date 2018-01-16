package dhirajnayak.com.a24x7weather.Utility;

import java.util.List;

import dhirajnayak.com.a24x7weather.Model.City;
import dhirajnayak.com.a24x7weather.Model.Weather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dhirajnayak on 1/11/18.
 * method for different network calls
 */

public interface IService {
    //network call for searching city.
    @GET("search.json")
    Call<List<City>> getLocationData(@Query("key") String apiKey,
                                     @Query("q") String searchText);

    //network call for getting weather for a city
    @GET("forecast.json")
    Call<Weather> getWeatherDetails(@Query("key") String apiKey,
                                    @Query("q") String searchCity,
                                    @Query("days") int numOfDays);
}
