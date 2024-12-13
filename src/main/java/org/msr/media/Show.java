package org.msr.media;

import org.msr.services.StreamingService;

import java.util.ArrayList;

/**
 * A show is a collection of {@link Season}
 */
public class Show extends Film {
    ArrayList<Season> seasons;

    /**
     * The constructor for a show with no default rating (0)
     * @param name The name of the show
     * @param yearOfRelease The year the show was released
     * @param genre The genre of the show
     * @param episodeRuntime The length of each episode of the show
     * @throws Exception When a show with the same name and year of release already exists
     */
    public Show(String name, int yearOfRelease, Genre genre, int episodeRuntime) throws Exception{
        super(name, yearOfRelease, genre, episodeRuntime);
        seasons = new ArrayList<>();
    }

    /**
     * The constructor for a show with a default rating
     * @param name The name of the show
     * @param yearOfRelease The year the show was released
     * @param genre The genre of the show
     * @param episodeRuntime The length of each episode of the show
     * @param rating The default rating of the show
     * @throws Exception When a show with the same name and year of release already exists
     */
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
