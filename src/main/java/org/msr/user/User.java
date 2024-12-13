package org.msr.user;

import org.msr.media.Season;
import org.msr.media.Streamable;
import org.msr.services.StreamingService;
import org.msr.storage.ServiceList;
import org.msr.storage.StreamingLibrary;

import java.util.stream.Stream;

public class User {
    private final ServiceList trackedServices;
    private final StreamingLibrary trackedMedia;

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
        System.out.println("Streaming Service Tracked: " + name);
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

    public void trackMedia(String name) throws Exception {
        Streamable media = StreamingLibrary.getMedia(name);
        if(media instanceof Season season && getTrackedStreamingService((season.getExclusiveTo().getName())) == null) {
            throw new Exception("You have not tracked the streaming service " + season.getExclusiveTo().getName());
        } else {
            trackedMedia.addItem(media);
            System.out.println("Media Tracked: " + name);
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

    public void printAllServices() {
        System.out.println("Tracked Streaming Services:");
        for(int i = 0; i < trackedServices.getItemCount(); i++) {
            System.out.println(((StreamingService) getTrackedServices()[i]).getName());
        }
    }

    public void printAllTrackedMedia() {
        System.out.println("Tracked Streamable Media:");
        for(int i = 0; i < trackedMedia.getItemCount(); i++) {
            Streamable media = (Streamable) getAllTrackedMedia()[i];
            System.out.println(media.getName() + ", Rating: " + media.getRating());
        }
    }

    public void printAllMediaFromService(String service) {
        System.out.println("Media on " + service + ":");
        System.out.println(StreamingService.getService(service).getAllMedia());
    }

    public void addRating(String media, double rating) throws Exception {
        if(rating > 5 || rating < 0) {
            throw new Exception("Rating must be between 0 and 5");
        } else if(getTrackedMedia(media) == null) {
            throw new Exception("You have not tracked " + media);
        } else {
            getTrackedMedia(media).addRating(rating);
            System.out.println("Rating added: " + rating);
        }
    }
}
