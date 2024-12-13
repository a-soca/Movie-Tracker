package org.msr;

import org.msr.media.Film;
import org.msr.media.Genre;
import org.msr.media.Show;
import org.msr.services.StreamingService;
import org.msr.user.User;

public class MovieTrackerApp {

    public static void main(String[] args) {
        System.out.println("Movie Tracker App"); // Output the name of the application

        createStreamingServices(); // Create some test services
        createMedia(); // Create some test media

        User user = new User(); // Create a demo user


        /////////////////////////////
        // Perform user actions here
        /////////////////////////////

        // Get a list of all services
        user.getAllServices();

        // Get media list from service
        user.printAllMediaFromService("Notflix");

        // Tracking Services
        user.trackStreamingService("Notflix");

        // Tracking Shows
        try {
            user.trackMedia("The Office Season 1");
            user.trackMedia("The Office Season 2");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Tracking Films
        try {
            user.trackMedia("Brave");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Checking Tracked information
        user.printAllServices();
        user.printAllTrackedMedia();

        // Adding Ratings
        try {
            user.addRating("The Office Season 1", 5);
            user.addRating("The Office Season 2", 2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Checking Tracked media
        user.printAllTrackedMedia();

        // Untracking media
        user.untrackMedia("The Office Season 1");
        user.untrackMedia("The Office Season 2");

        // Checking Tracked media
        user.printAllTrackedMedia();
    }

    private static void createStreamingServices() {
        new StreamingService("Notflix", 13.99);
        new StreamingService("Congo Prime", 5.49);
    }

    private static void createMedia() {
        Show theOffice = null;
        try {
            theOffice = new Show("The Office", 2005, Genre.comedy, 45);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        theOffice.addSeason(1, 2005, 20, "Notflix");
        theOffice.addSeason(2, 2006, 25, "Congo Prime");

        try {
            Film brave = new Film("Brave", 2012, Genre.adventure, 93);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
