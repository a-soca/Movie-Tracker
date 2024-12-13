package org.msr.media;

import org.msr.services.StreamingService;

import java.util.ArrayList;

public class Show extends Film {
    ArrayList<Season> seasons;

    public Show(String name, int yearOfRelease, Genre genre, int episodeRuntime) throws Exception{
        super(name, yearOfRelease, genre, episodeRuntime);
        seasons = new ArrayList<>();
    }

    public Show(String name, int yearOfRelease, Genre genre, int episodeRuntime, double rating) throws Exception {
        this(name, yearOfRelease, genre, episodeRuntime);
        setRating(rating);
    }

    public ArrayList<Season> getSeasons() {
        return seasons;
    }

    public void addSeason(int seasonNumber, int yearOfRelease, int numberOfEpisodes, String exclusiveTo) {
        StreamingService service = StreamingService.getService(exclusiveTo);
        Season s = new Season(this, seasonNumber, yearOfRelease, numberOfEpisodes, service);
        seasons.add(s);
    }

    public int getNumberOfSeasons() {
        return seasons.size();
    }

    @Override
    public String toString() {
        return "Name: " + getName() +
                ", Genre: " + getGenre() +
                ", Release Year: " + getYearOfRelease() +
                ", Episode Length: " + getRuntime() +
                ", Number of Seasons: " + getNumberOfSeasons();
    }
}
