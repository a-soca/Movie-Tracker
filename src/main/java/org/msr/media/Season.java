package org.msr.media;

import org.msr.services.StreamingService;

/**
 * A season belongs to a {@link Show} and is {@link #exclusiveTo} one {@link StreamingService}.
 * Each season has a season number, year of release and number of episodes.
 */
public class Season implements Streamable {
    private int seasonNumber, yearOfRelease, numberOfEpisodes;
    private StreamingService exclusiveTo;
    private Show show;

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
    }

    public int getSeasonNumber() {
        return this.seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public int getYearOfRelease() {
        return this.yearOfRelease;
    }


    @Override
    public Genre getGenre() {
        return this.show.getGenre();
    }


    @Override
    public double getRating() {
        return this.show.getRating();
    }


    @Override
    public String getName() {
        return this.show.getName() + " Season " + this.seasonNumber;
    }

    public  int getNumberOfEpisodes() {
        return this.numberOfEpisodes;
    }

    public void setNumberOfEpisodes(int numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }

    public StreamingService getExclusiveTo() {
        return exclusiveTo;
    }

    public void setExclusiveTo(StreamingService exclusiveTo) {
        if(this.exclusiveTo != null){
            exclusiveTo.removeMedia(this);
        }

        exclusiveTo.addMedia(this);
        this.exclusiveTo = exclusiveTo;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }
}
