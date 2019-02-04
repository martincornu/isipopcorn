package com.alcedo.marty.isipopcorn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alcedo.marty.isipopcorn.adapter.MovieAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    protected String[] myDataset = new String[4];
    protected String[] myRealisatorDataset = new String[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.main_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        myRealisatorDataset[0] = "Besson";
        myRealisatorDataset[1] = "Spielberg";
        myRealisatorDataset[2] = "Toine";
        myRealisatorDataset[3] = "Manitaz";
        mAdapter = new MovieAdapter(myDataset, myRealisatorDataset);
        mRecyclerView.setAdapter(mAdapter);

       Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://etudiants.openium.fr/pam/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<InitialObject> call = jsonPlaceHolderApi.getInitialObject();
        call.enqueue(new Callback<InitialObject>() {
            @Override
            public void onResponse(Call<InitialObject> call, Response<InitialObject> response) {

                if (!response.isSuccessful()) {
                    myDataset[0] = "probleme";
                    return;
                }
                List<MovieShowtime> movieShowtimes = response.body().getMovieShowtimeList();
                int i = 0;
               for (MovieShowtime movieShowtime : movieShowtimes) {
                    String content = "";
                    content += "Title: " + movieShowtime.getOnShow().getMovie().getTitle() + "\n";
                    content += "" + movieShowtime.getDisplay() + "\n\n";
                    if(i <= 3){
                        myDataset[i] = movieShowtime.getOnShow().getMovie().getTitle();
                        myRealisatorDataset[i] = movieShowtime.getOnShow().getMovie().getCastingShort().getActors();
                    }
                   i++;
               }
                    i++;
                mAdapter.notifyDataSetChanged();
                }
            @Override
            public void onFailure(Call<InitialObject> call, Throwable t) {
                myDataset[0] = "probleme";
            }
        });
    }

    public void launchDetailsActivity(View view) {
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);
    }
}
