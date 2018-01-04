package com.example.steighallquist.popmovies;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        Movie movie = getMovie();

        assignTextTo(movie.title, R.id.movie_title, rootView);
        assignTextTo(String.valueOf(movie.vote_average), R.id.movie_rating, rootView);
        assignTextTo(movie.release_date, R.id.movie_release_date, rootView);
        assignTextTo(movie.overview, R.id.movie_synopsis, rootView);

        getMoviePoster(movie.poster_path, rootView);

        return rootView;
    }

    private void assignTextTo(String text, int resource, View rootView ) {
        TextView textView = rootView.findViewById(resource);
        textView.setText(text);
    }

    private void getMoviePoster(String poster_path, View rootView) {
        if (poster_path.length() > 0) {
            String path = MovieAdapter.MOVIE_IMAGE_URL + poster_path;
            ImageView imageView = (ImageView)rootView.findViewById(R.id.poster_thumbnail);

            Picasso.with(getContext())
                    .load(path)
                    .into(imageView);
        }
    }

    private Movie getMovie() {
        Intent intent = getActivity().getIntent();
        Movie movie = null;

        if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            String jsonString = intent.getStringExtra(Intent.EXTRA_TEXT);
            Gson gson = new Gson();

            movie = gson.fromJson(jsonString, Movie.class);
        }

        return  movie;
    }
}
