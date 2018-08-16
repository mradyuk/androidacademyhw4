package androidacademy.minsk.lecture3lists;

import java.util.List;

import androidacademy.minsk.lecture3lists.movie.Movie;
import androidacademy.minsk.lecture3lists.movie.OMDBResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OMDBService {

    @GET("/")
    Call<OMDBResponse> getMovies(@Query("s") String key, @Query("apikey") String apikey);

}
