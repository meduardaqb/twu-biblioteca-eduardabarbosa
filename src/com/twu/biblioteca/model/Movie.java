package com.twu.biblioteca.model;

import com.twu.biblioteca.util.ITEM_TYPE;

public class Movie extends Item {
    private String director;
    private int rating;
    private int year;

    public Movie(String name, int year, String director, int rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.available = true;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object obj) {
        Movie movie = (Movie) obj;

        return this.name.equals(movie.getName()) &&
                this.director.equals(movie.getDirector()) &&
                this.getYear() == movie.getYear();
    }

    @Override
    ITEM_TYPE getType() {
        return ITEM_TYPE.MOVIE;
    }
}
