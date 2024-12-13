package org.msr.media;

import org.msr.services.StreamingService;
import org.msr.storage.StreamingLibrary;

/**
 * A season belongs to a {@link Show} and is {@link #exclusiveTo} one {@link StreamingService}.
 * Each season has a season number, year of release and number of episodes.
 */
public class Season implements Streamable {
    private int seasonNumber, yearOfRelease, numberOfEpisodes;
    private StreamingService exclusiveTo;
    private Show show;
    private double rating;
    private int numRatings = 0;

    /**
     * @param show The show the season belongs to
     * @param seasonNumber The season number of the season
     * @param yearOfRelease The year the season was released
     * @param numberOfEpisodes The number of episodes in the season
     * @param exclusiveTo The {@link StreamingService} the season is exclusive to
     */
    public Season(Show show, int seasonNumber, int yearOfRelease, int numberOfEpisodes, StreamingService exclusiveTo) {
        setShow(show);
        setSeasonNumber(seasonNumber);
        setYearOfRelease(yearOfRelease);
        setNumberOfEpisodes(numberOfEpisodes);
        setExclusiveTo(exclusiveTo);

        setRating(0);

        StreamingLibrary.getMediaList().addItem(this);
    }

    public int getSeasonNumber() {
        return this.seasonNumber;
    }

    private void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    private void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    private void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public int getYearOfRelease() {
        return this.yearOfRelease;
    }

    @Override
    public Genre getGenre() {
        return this.show.getGenre();
    }

    @Override
    public int getRuntime() {
        return getShow().getRuntime();
    }

    @Override
    public double getRating() {
        return this.rating;
    }

    @Override
    public void addRating(double rating) {
        numRatings++;
        setRating((getRating() + rating)/numRatings); // Recalculate the average rating of the show and set it
    }

    @Override
    public String getName() {
        return this.show.getName() + " Season " + this.seasonNumber;
    }

    public int getNumberOfEpisodes() {
        return this.numberOfEpisodes;
    }

    private void setNumberOfEpisodes(int numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }

    public StreamingService getExclusiveTo() {
        return exclusiveTo;
    }

    private void setExclusiveTo(StreamingService exclusiveTo) {
        if(this.exclusiveTo != null){ // If the season is already exclusive to another service,
            exclusiveTo.removeMedia(this); // Remove the season from the other service
        }

        exclusiveTo.addMedia(this); // Add this season to the streaming service
        this.exclusiveTo = exclusiveTo;
    }

    public Show getShow() {
        return show;
    }

    private void setShow(Show show) {
        this.show = show;
    }

    @Override
    public String toString() {
        return "Name: " + getName() +
                ", Genre: " + getGenre() +
                ", Release Year: " + getYearOfRelease() +
                ", Number of Episodes: " + getNumberOfEpisodes() +
                ", Episode Length: " + getRuntime() +
                ", Exclusive to: " + getExclusiveTo().getName();
    }
}
