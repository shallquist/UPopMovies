package com.example.steighallquist.popmovies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by steighallquist on 1/3/18.
 */

public class MovieAdapter extends ArrayAdapter {
    public MovieAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull Object[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public MovieAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) { return null; }

        Movie movie = (Movie)getItem(position);

        TextView textView = convertView.findViewById(R.id.text_view);
        textView.setText(movie.title);

        return  convertView;
    }
}
