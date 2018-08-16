package androidacademy.minsk.lecture3lists;

import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import androidacademy.minsk.lecture3lists.movie.Movie;
import androidacademy.minsk.lecture3lists.movie.OMDBResponse;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieActivity extends AppCompatActivity {

    private MovieRecyclerAdapter movieRecyclerAdapter;

    static final String BASE_URL = "http://omdbapi.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        RecyclerView list = findViewById(R.id.movieList);

        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE))
                .getDefaultDisplay();

        int orientation = display.getRotation();

        RecyclerView.LayoutManager layoutManager;
        if (orientation == Surface.ROTATION_90
                || orientation == Surface.ROTATION_270) {
            layoutManager = new GridLayoutManager(getApplicationContext(), 4);
        } else {
            layoutManager = new GridLayoutManager(getApplicationContext(), 2);

        }

        list.setLayoutManager(layoutManager);


        movieRecyclerAdapter = new MovieRecyclerAdapter(MovieActivity.this, new ArrayList<>());
        list.setAdapter(movieRecyclerAdapter);


        EditText key = (EditText) findViewById(R.id.key);
        Button searchBtn = (Button) findViewById(R.id.searchBtn);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(buildHttpClient())
                        .build();

                OMDBService service = retrofit.create(OMDBService.class);
                Call<OMDBResponse> call = service.getMovies(key.getText().toString(), "57430b23");

                call.enqueue(new Callback<OMDBResponse>() {
                    @Override
                    public void onResponse(Call<OMDBResponse> call, Response<OMDBResponse> response) {

                        if (!response.isSuccessful()) {
                            return;
                        }

                        OMDBResponse omdbresponse = response.body();

                        List<Movie> movies = omdbresponse.getSearch();

                        movieRecyclerAdapter.setItems(movies);

                    }

                    @Override
                    public void onFailure(Call<OMDBResponse> call, Throwable t) {
                        Log.e("MOVIESERVICE", "exception", t);
                    }
                });
                /*
                try {
                    Response<OMDBResponse> response = call.execute();
                    OMDBResponse omdbresponse = response.body();
                    List <Movie> movies = omdbresponse.getSearch();
                } catch (Exception ex) {
                    Log.e("MYAPP", "exception", ex);
                }
*/

            }
        });
    }

    private OkHttpClient buildHttpClient() {
        return new OkHttpClient.Builder().build();
    }
}
