package com.example.steighallquist.popmovies;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by steighallquist on 1/3/18.
 */

public class FetchMoviesTask extends AsyncTask<Void, Void, Void> {
    final String MOVIE_DB_URL = "https://api.themoviedb.org/3/movie";
    final String MOVIE_POPULAR = "popular";

    final String LOG_TAG = FetchMoviesTask.class.getSimpleName();

    @Override
    protected Void doInBackground(Void... voids) {
        // These two need to be declared outside the try/catch
        // so that they can be closed in the finally block.
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        // Will contain the raw JSON response as a string.
        String moviesJsonStr = null;

        try {
            URL url = getMovieUrl(MOVIE_POPULAR);

            // Create the request to Movie DB, and open the connection
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // Read the input stream into a String
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();

            if (inputStream == null) {
                // Nothing to do.
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                // But it does make debugging a *lot* easier if you print out the completed
                // buffer for debugging.
                buffer.append(line + "\n");
            }

            if (buffer.length() == 0) {
                // Stream was empty.  No point in parsing.
                return null;
            }

            moviesJsonStr = buffer.toString();
        }
        catch (Exception e)  {
            Log.e(LOG_TAG, "Error connecting to Movie DB", e);
        }
        finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.e(LOG_TAG, "Error closing stream", e);
                }
            }
        }


        return null;
    }

    private URL getMovieUrl(String api) throws IOException {
        Uri uri = Uri.parse(MOVIE_DB_URL).buildUpon()
                .appendPath(api)
                .appendQueryParameter("api_key","3c246c8b765a359180688b11f2134457")
                .build();

        URL url = new URL(uri.toString());

        return url;
    }
}
