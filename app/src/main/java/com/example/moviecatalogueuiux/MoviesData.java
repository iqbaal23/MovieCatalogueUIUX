package com.example.moviecatalogueuiux;

import android.content.Context;
import android.content.res.TypedArray;

import java.util.ArrayList;

public class MoviesData {
    public static ArrayList<Movie> getListMovieData (Context context){
        String[] name = context.getResources().getStringArray(R.array.data_movie_name);
        String[] date = context.getResources().getStringArray(R.array.data_movie_date);
        String[] score = context.getResources().getStringArray(R.array.data_movie_score);
        String[] overview = context.getResources().getStringArray(R.array.data_movie_overview);
        TypedArray photo = context.getResources().obtainTypedArray(R.array.data_movie_photo);

        ArrayList<Movie> movieList = new ArrayList<>();
        for (int i=0; i<name.length; i++){
            Movie movie = new Movie();
            movie.setName(name[i]);
            movie.setDate(date[i]);
            movie.setScore(score[i]);
            movie.setOverview(overview[i]);
            movie.setPhoto(photo.getResourceId(i,-1));
            movieList.add(movie);
        }
        return movieList;
    }

     public static ArrayList<Movie> getListTvShowsData (Context context){
        String[] name = context.getResources().getStringArray(R.array.data_tvshows_name);
        String[] date = context.getResources().getStringArray(R.array.data_tvshows_date);
        String[] score = context.getResources().getStringArray(R.array.data_tvshows_score);
        String[] overview = context.getResources().getStringArray(R.array.data_tvshows_overview);
        TypedArray photo = context.getResources().obtainTypedArray(R.array.data_tvshows_photo);

        ArrayList<Movie> movieList = new ArrayList<>();
        for (int i=0; i<name.length; i++){
            Movie movie = new Movie();
            movie.setName(name[i]);
            movie.setDate(date[i]);
            movie.setScore(score[i]);
            movie.setOverview(overview[i]);
            movie.setPhoto(photo.getResourceId(i,-1));
            movieList.add(movie);
        }
        return movieList;
    }

}
