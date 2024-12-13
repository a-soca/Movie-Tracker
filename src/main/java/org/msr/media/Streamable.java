package org.msr.media;

/**
 * A type of media which can be streamed
 */
public interface Streamable {
    String getName();
    int getYearOfRelease();
    Genre getGenre();
    int getRuntime();
    double getRating();
    void addRating(double rating);
}
