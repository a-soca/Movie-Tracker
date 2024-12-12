package org.msr;

public interface Streamable {
    public void setName(String name);
    public String getName();
    public void setYearOfRelease(int yearOfRelease);
    public int getYearOfRelease();
    public void setGenre(Genre genre);
    public Genre getGenre();
    public void setRating(double rating);
    public double getRating();
}
