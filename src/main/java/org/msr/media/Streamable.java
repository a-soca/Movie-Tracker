package org.msr.media;

public interface Streamable {
    public String getName();
    public int getYearOfRelease();
    public Genre getGenre();
    public int getRuntime();
    public double getRating();
    public void addRating(double rating);
}
