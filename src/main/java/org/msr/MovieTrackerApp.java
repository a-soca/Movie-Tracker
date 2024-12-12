package org.msr;

import org.msr.media.Genre;
import org.msr.media.Season;
import org.msr.media.Show;
import org.msr.services.StreamingService;

public class MovieTrackerApp {
    public static void main(String[] args) {
        System.out.println("Movie Tracker App");

        StreamingService Notflix = new StreamingService("Notflix", 13.99);
        StreamingService Notflix = new StreamingService("Notflix", 13.99);

        Show theOffice = new Show("The Office", 2005, Genre.comedy);

        new Season(theOffice, 1, 2005, 20, Notflix);

        theOffice.addSeason(2, 2006, 25, Notflix);

        Notflix.addMedia(theOffice); // Check it does not add seasons twice

        System.out.println(Notflix.getAllMedia());
    }
}
