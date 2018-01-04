package com.example.steighallquist.popmovies;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private MovieAdapter mMovieAdapter;

    public MainActivityFragment() {
    }

    @Override
    public void onStart() {
        super.onStart();

        fetchMovies();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        GridView gridView = (GridView)rootView.findViewById(R.id.grid_view);

        mMovieAdapter = new MovieAdapter(
                getActivity(),
                R.layout.list_image_item,
                R.id.poster_image_view,
                new ArrayList<Movie>()
        );

        gridView.setAdapter(mMovieAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Movie movie = (Movie)mMovieAdapter.getItem(position);

                Gson gson = new Gson();
                String jsonString = gson.toJson(movie);

                Intent intent = new Intent(getActivity(), DetailActivity.class)
                        .putExtra(Intent.EXTRA_TEXT, jsonString);

                startActivity(intent);
            }
        });

        return rootView;
    }

    private void fetchMovies() {
        FetchMoviesTask moviesTask = new FetchMoviesTask(mMovieAdapter);
        moviesTask.execute("popular");
    }
}
