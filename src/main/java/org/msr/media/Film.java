package org.msr.media;

import org.msr.storage.StreamingLibrary;

/**
 * A film is a single piece of media which does not have episodes or seasons.
 */
public class Film implements Streamable {
    private String name;
    private int yearOfRelease;
    private Genre genre;
    private double rating;
    private int runtime;
    private int numRatings = 0;

    /**
     * Constructor for a film with no default rating (0)
     * @param name The name of the film
     * @param yearOfRelease The year the film was released
     * @param genre The genre of the film
     * @param runtime How long the film is in minutes
     * @throws Exception When a movie with the same name and release year is attempted to be created
     */
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

    /**
     * Constructor for a film with a default rating
     * @param name The name of the film
     * @param yearOfRelease The year the film was released
     * @param genre The genre of the film
     * @param runtime How long the film is in minutes
     * @param rating The default rating of the film
     * @throws Exception When a movie with the same name and release year is attempted to be created
     */
    public Film(String name, int yearOfRelease, Genre genre, int runtime, double rating) throws Exception {
        this(name, yearOfRelease, genre, runtime);
        setRating(rating);
        setNumRatings(1);
    }

    public int getNumRatings() {
        return numRatings;
    }

    public void setNumRatings(int numRatings) {
        this.numRatings = numRatings;
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
        setNumRatings(getNumRatings() + 1);
        setRating((getRating() + rating) / getNumRatings());
    }

    @Override
    public String toString() {
        return "Name: " + getName() +
                ", Genre: " + getGenre() +
                ", Release Year: " + getYearOfRelease() +
                ", Runtime: " + getRuntime();
    }
}
