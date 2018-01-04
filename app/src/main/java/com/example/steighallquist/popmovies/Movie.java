package com.example.steighallquist.popmovies;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by steighallquist on 1/3/18.
 */

public class Movie {
    public int vote_count;
    public int id;
    public boolean video;
    public double vote_average;
    public String title;
    public double popularity;
    public String poster_path;
    public String original_language;
    public String original_title;
    public List<Integer> genre_ids;
    public String backdrop_path;
    public boolean adult;
    public String overview;
    public String release_date;
}
