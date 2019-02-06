package com.alcedo.marty.isipopcorn.adapter;

import android.content.res.Resources;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alcedo.marty.isipopcorn.R;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    protected ArrayList<String> mDataset;
    protected ArrayList<String> mRealisatorDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTitleTextView;
        public TextView mRealisatorTextView;
        public ImageView mMovieImageView;

        public MovieViewHolder(View itemView) {
            super(itemView);
            mTitleTextView = itemView.findViewById(R.id.movie_title);
            mRealisatorTextView = itemView.findViewById(R.id.movie_realisator);
            mMovieImageView = itemView.findViewById(R.id.movie_image);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MovieAdapter(ArrayList<String> myDataset, ArrayList<String> myRealisatorDataset) {
        mDataset = myDataset;
        mRealisatorDataset = myRealisatorDataset;
    }

    public void setmDataset(ArrayList<String> mDataset) {
        this.mDataset = mDataset;
        notifyDataSetChanged();
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_row_item, parent, false);
        MovieViewHolder vh = new MovieViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTitleTextView.setText(mDataset.get(position));
        holder.mRealisatorTextView.setText(mRealisatorDataset.get(position));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
