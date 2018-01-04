package com.example.steighallquist.popmovies;

import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test_gson() throws Exception {
        String jsonString = "{\"vote_count\": 5269,\"id\": 346364,\"video\": false,\"vote_average\": 7.2,\"title\": \"It\",\"popularity\": 804.89757,"
        + "\"poster_path\": \"/9E2y5Q7WlCVNEhP5GiVTjhEhx1o.jpg\",\"original_language\": \"en\",\"original_title\": \"It\",\"genre_ids\": [53,18,27,14],"
        + "\"backdrop_path\": \"/tcheoA2nPATCm2vvXw2hVQoaEFD.jpg\",\"adult\": false,\"overview\": "
        + "\"In a small town in Maine, seven children known as The Losers Club come face to face with life problems, bullies and a monster that takes the shape of a clown called Pennywise.\","
        + "\"release_date\": \"2017-09-05\"}";

        Gson gson = new Gson();
        Movie movies = gson.fromJson(jsonString,Movie.class);

        assertNotNull(movies);
    }
}