package org.msr.media;

public class Film implements Streamable {
    private String name;
    private int yearOfRelease;
    private Genre genre;
    private double rating;

    public Film(String name, int yearOfRelease, Genre genre) {
        setName(name);
        setYearOfRelease(yearOfRelease);
        setGenre(genre);
        setRating(0);
    }

    public Film(String name, int yearOfRelease, Genre genre, double rating) {
        this(name, yearOfRelease, genre);
        setRating(rating);
    }


    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    @Override
    public int getYearOfRelease() {
        return this.yearOfRelease;
    }

    @Override
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public Genre getGenre() {
        return this.genre;
    }

    @Override
    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public double getRating() {
        return this.rating;
    }
}
