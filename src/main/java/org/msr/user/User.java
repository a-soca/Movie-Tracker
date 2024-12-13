package org.msr.user;

import org.msr.media.Season;
import org.msr.media.Streamable;
import org.msr.services.StreamingService;
import org.msr.storage.ServiceList;
import org.msr.storage.StreamingLibrary;

/**
 * A User is someone who can track their own list of {@link StreamingService}, {@link Streamable} media
 * and add ratings to media they have tracked (Through the use of {@link #addRating(String, double)}
 */
public class User {
    private final ServiceList trackedServices; // Stores a list of all the services this user has tracked
    private final StreamingLibrary trackedMedia; // Stores a list of all the media this user has tracked

    public User() {
        this.trackedServices = new ServiceList();
        this.trackedMedia = new StreamingLibrary();
    }

    public void getAllServices() {
        System.out.println("Streaming Services Available:\n" + StreamingService.getAllServices());
    }

    public void getAllMedia() {
        System.out.println("Streamable Media Available:\n" + StreamingLibrary.getAllMedia());
    }

    public void trackStreamingService(String name) {
        trackedServices.addItem(StreamingService.getServiceList().getItem(name));
    }

    public void untrackStreamingService(String name) {
        trackedServices.removeItem(name);
        System.out.println("Streaming Service Untracked: " + name);
    }

    private Object[] getTrackedServices() {
        return trackedServices.getItems();
    }

    private StreamingService getTrackedStreamingService(String name) {
        return (StreamingService) trackedServices.getItem(name);
    }

    /**
     * Used to track a piece of {@link Streamable} media
     * @param name The name of the media to track
     * @throws Exception When the media does not exist or if the streaming service the media is exclusive to is not
     * tracked
     */
    public void trackMedia(String name) throws Exception {
        Streamable media = StreamingLibrary.getMedia(name); // Find the media in the app media library
        if(media == null) { // If the search returned nothing,
            throw new Exception("Media not found: " + name);
        } else if(media instanceof Season season &&
                getTrackedStreamingService((season.getExclusiveTo().getName())) == null) {
            // If the media is a season and is exclusive to a service the user does not track
            throw new Exception("You have not tracked the streaming service " + season.getExclusiveTo().getName());
        } else {
            trackedMedia.addItem(media);
        }
    }

    public void untrackMedia(String name) {
        trackedMedia.removeItem(name);
        System.out.println("Media Untracked: " + name);
    }

    private Object[] getAllTrackedMedia() {
        return trackedMedia.getItems();
    }

    private Streamable getTrackedMedia(String name) {
        return (Streamable) trackedMedia.getItem(name);
    }

    /**
     * Prints the names of all the {@link StreamingService} the user has tracked
     */
    public void printAllTrackedServices() {
        if(getTrackedServices().length == 0) { // If the tracked services list is empty
            System.out.println("No Tracked Services Available");
        } else {
            System.out.println("Tracked Streaming Services:");
            for (int i = 0; i < trackedServices.getItemCount(); i++) {
                System.out.println(((StreamingService) getTrackedServices()[i]).getName());
            }
        }
    }

    /**
     * Prints the names of all the {@link Streamable} media the user has tracked
     */
    public void printAllTrackedMedia() {
        if(getAllTrackedMedia().length == 0) { // If the tracked media list is empty
            System.out.println("No Tracked Media Available");
        } else {
            System.out.println("Tracked Streamable Media:");
            for (int i = 0; i < trackedMedia.getItemCount(); i++) {
                Streamable media = (Streamable) getAllTrackedMedia()[i];
                System.out.println(media.getName() + ", Rating: " + media.getRating());
            }
        }
    }

    public void printExclusiveMediaFromService(String service) {
        System.out.println("Exclusive Media on " + service + ":");
        System.out.println(StreamingService.getService(service).getAllMedia());
    }

    /**
     * Allows the user to add a rating to {@link Streamable} media
     * @param media The name of the media to rate
     * @param rating The rating between 0 and 5 to add
     * @throws Exception When the rating is outside the acceptable range or the media is not tracked
     */
    public void addRating(String media, double rating) throws Exception {
        if(rating > 5 || rating < 0) {
            throw new Exception("Rating must be between 0 and 5");
        } else if(getTrackedMedia(media) == null) {
            throw new Exception("You have not tracked " + media);
        } else {
            getTrackedMedia(media).addRating(rating);
        }
    }
}
