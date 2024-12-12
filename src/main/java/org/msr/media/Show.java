package org.msr.media;

import java.util.ArrayList;

public abstract class Show extends Film {
    ArrayList<Season> seasons;

    public Show(String name, int yearOfRelease, Genre genre) {
        super(name, yearOfRelease, genre);
        seasons = new ArrayList<>();
    }

    public Show(String name, int yearOfRelease, Genre genre, double rating) {
        this(name, yearOfRelease, genre);
        setRating(rating);
    }
}
