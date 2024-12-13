package org.msr;

import org.msr.media.Film;
import org.msr.media.Genre;
import org.msr.media.Show;
import org.msr.services.StreamingService;
import org.msr.user.User;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MovieTrackerApp {
    private static Scanner scanner; // For user input
    private static User user = new User(); // Create a demo user

    public static void main(String[] args) {
        createStreamingServices(); // Create some test services
        createMedia(); // Create some test media

        scanner = new Scanner(System.in); // Set the scanner source

        userInterface(); // Open the main user interface
    }

    private static void userInterface() {
        /////////////////////////////
        // Perform user actions here
        /////////////////////////////

        boolean exit = false;
        printTitle("Select an option:");
        while(!exit) {
            printMenu();

            String option = scanner.nextLine();
            switch(option) {
                case "ServiceMenu":
                    printTitle("Service Menu");
                    user.getAllServices();
                    break;
                case "MediaMenu":
                    printTitle("Media Menu");
                    user.getAllMedia();
                    break;
                case "MyServices":
                    printTitle("My Services");
                    user.printAllTrackedServices();
                    break;
                case "MyMedia":
                    printTitle("My Media");
                    user.printAllTrackedMedia();
                    break;
                case "ExclusiveTo":
                    printTitle("Exclusive Media");
                    exclusiveMenu();
                    break;
                case "TrackService":
                    printTitle("Track a Service");
                    trackServiceMenu();
                    break;
                case "TrackMedia":
                    printTitle("Track Media");
                    trackMediaMenu();
                    break;
                case "AddRating":
                    printTitle("Add a Rating");
                    addRatingMenu();
                    break;
                case "UntrackService":
                    printTitle("Untrack a Service");
                    untrackServiceMenu();
                    break;
                case "UntrackMedia":
                    printTitle("Untrack Media");
                    untrackMediaMenu();
                    break;
                case "Exit":
                    exit = true;
                    break;
                default:
                    printTitle("Invalid Option. Please try again:");
                    break;
            }
        }
    }

    private static void addRatingMenu() {
        boolean success = false;
        while(!success) {
            user.printAllTrackedMedia();
            System.out.println("Enter the name of the media to rate:");

            String mediaName = scanner.nextLine();

            System.out.println("Enter the rating (0 - 5):");

            try {
                double rating = scanner.nextDouble();

                user.addRating(mediaName, rating);
                printTitle("Rating added: " + rating + ". Select an option:");
                success = true;
            } catch(InputMismatchException e) {
                printTitle("Error : rating must be a number between 0 and 5, Please try again:");
            } catch (Exception e) {
                printTitle("Error : " + e.getMessage() + ", Please try again:");
            }
            scanner.nextLine(); // Flush the newline
        }
    }


    private static void createStreamingServices() {
        new StreamingService("Notflix", 13.99);
        new StreamingService("Congo Prime", 5.49);
    }

    private static void createMedia() {
        try {
            Show theOffice = new Show("The Office", 2005, Genre.comedy, 45);
            theOffice.addSeason(1, 2005, 20, "Notflix");
            theOffice.addSeason(2, 2006, 25, "Congo Prime");

            new Film("Brave", 2012, Genre.adventure, 93);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void untrackMediaMenu() {
        printTitle("Please enter the name of the Media to untrack:");
        String mediaName = scanner.nextLine();

        user.untrackMedia(mediaName);
    }

    private static void untrackServiceMenu() {
        printTitle("Please enter the name of the Service to untrack:");
        String serviceName = scanner.nextLine();

        user.untrackStreamingService(serviceName);
    }

    private static void trackServiceMenu() {
        printTitle("Please enter the name of the Service to track:");
        user.getAllServices();
        String serviceName = scanner.nextLine();

        user.trackStreamingService(serviceName);
    }

    private static void trackMediaMenu() {
        printTitle("Please enter the name of the Media to track:");

        boolean success = false;
        while(!success) {
            user.getAllMedia();
            String mediaName = scanner.nextLine();

            try {
                user.trackMedia(mediaName);
                success = true;
                printTitle("Media Tracked: " + mediaName +". Select an option:");
            } catch (Exception e) {
                printTitle("Error : " + e.getMessage() + ", Please try again:");
            }
        }
    }

    private static void exclusiveMenu() {
        printTitle("Please enter the name of the Service to find exclusive media:");
        user.getAllServices();
        String serviceName = scanner.nextLine();

        user.printExclusiveMediaFromService(serviceName);
    }

    private static void clearScreen() {
        System.out.println(new String(new char[50]).replace("\0", "\r\n"));
    }

    private static void printTitle(String title) {
        clearScreen();
        System.out.println( "-------------------------" +
                            "\n\tMovie Tracker App" +
                            "\n-------------------------"); // Output the name of the application
        System.out.println("-> " + title + "\n");
    }

    private static void printMenu() {
        System.out.println( "ServiceMenu    - Show All Available Services\n" +
                            "MediaMenu      - Show All Available Streamable Media\n" +
                            "MyServices     - Show Services you have Tracked\n" +
                            "MyMedia        - Show Media you have Tracked\n" +
                            "ExclusiveTo    - Show Seasons Exclusive to a Service\n" +
                            "TrackService   - Track a Streaming Service\n" +
                            "TrackMedia     - Track Media\n" +
                            "UntrackService - Untrack a Streaming Service\n" +
                            "UntrackMedia   - Untrack Media\n" +
                            "Exit           - Exit the application\n"
        );
    }


}
