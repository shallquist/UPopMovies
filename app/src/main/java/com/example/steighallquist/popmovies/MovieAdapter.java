package com.example.steighallquist.popmovies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by steighallquist on 1/3/18.
 */

public class MovieAdapter extends ArrayAdapter {
    final static String MOVIE_IMAGE_URL = "https://image.tmdb.org/t/p/w500";

    public MovieAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_image_item, parent, false);
        }

        Movie movie = (Movie) getItem(position);

        if (movie != null && movie.poster_path.length() > 0) {
            String path = MOVIE_IMAGE_URL + movie.poster_path;
            ImageView imageView = (ImageView)convertView.findViewById(R.id.poster_image_view);

            Picasso.with(getContext())
                    .load(path)
                    .into(imageView);
        }

        return  convertView;
    }
}
