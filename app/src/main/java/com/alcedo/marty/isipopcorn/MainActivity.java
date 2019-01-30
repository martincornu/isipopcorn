package com.alcedo.marty.isipopcorn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alcedo.marty.isipopcorn.adapter.MovieAdapter;

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
        myDataset[0] = "bonjour";
        myDataset[1] = "salut";
        myDataset[2] = "on est pas là pour êre ici";
        myDataset[3] = "Je suis un tres tres grand artiste";
        myRealisatorDataset[0] = "Besson";
        myRealisatorDataset[1] = "Spielberg";
        myRealisatorDataset[2] = "Toine";
        myRealisatorDataset[3] = "Manitaz";
        mAdapter = new MovieAdapter(myDataset, myRealisatorDataset);
        mRecyclerView.setAdapter(mAdapter);

    }

    public void launchDetailsActivity(View view) {
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);
    }
}
