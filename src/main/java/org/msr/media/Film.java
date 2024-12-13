package org.msr.media;

import org.msr.storage.StreamingLibrary;

public class Film implements Streamable {
    private String name;
    private int yearOfRelease;
    private Genre genre;
    private double rating;
    private int runtime;
    private int numRatings = 0;

    public Film(String name, int yearOfRelease, Genre genre, int runtime) throws Exception {
        Streamable duplicate = StreamingLibrary.getMedia(name);
        if(duplicate != null && duplicate.getYearOfRelease() == yearOfRelease) {
            throw new Exception("Media already exists");
        }

        setName(name);
        setYearOfRelease(yearOfRelease);
        setGenre(genre);
        setRating(0);

        setRuntime(runtime);

        StreamingLibrary.getMediaList().addItem(this);
    }

    public Film(String name, int yearOfRelease, Genre genre, int runtime, double rating) throws Exception {
        this(name, yearOfRelease, genre, runtime);
        setRating(rating);
    }

    private void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    @Override
    public int getYearOfRelease() {
        return this.yearOfRelease;
    }

    private void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public Genre getGenre() {
        return this.genre;
    }

    @Override
    public int getRuntime() {
        return this.runtime;
    }

    protected void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public double getRating() {
        return this.rating;
    }

    @Override
    public void addRating(double rating) {
        numRatings++;
        setRating((getRating() + rating) / numRatings);
    }

    @Override
    public String toString() {
        return "Name: " + getName() +
                ", Genre: " + getGenre() +
                ", Release Year: " + getYearOfRelease() +
                ", Runtime: " + getRuntime();
    }
}
