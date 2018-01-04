package com.example.steighallquist.popmovies;

import android.graphics.*;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private MovieAdapter mMovieAdapter;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        GridView gridView = (GridView)rootView.findViewById(R.id.grid_view);

        mMovieAdapter = new MovieAdapter(
                getActivity(),
                R.layout.list_text_item,
                R.id.text_view,
                new ArrayList<android.graphics.Movie>()
        );


        FetchMoviesTask moviesTask = new FetchMoviesTask(mMovieAdapter);
        moviesTask.execute("popular");

        return rootView;
    }
}
