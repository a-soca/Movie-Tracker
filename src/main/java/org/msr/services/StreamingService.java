package org.msr.services;

import org.msr.media.Show;
import org.msr.media.Streamable;
import org.msr.storage.ServiceList;
import org.msr.storage.StreamingLibrary;

/**
 * A Streaming Service is a {@link Billable} service which hosts {@link Streamable} media
 */
public class StreamingService implements Billable {
    private String name;
    private double price;

    private StreamingLibrary library; // The exclusive media the streaming service hosts

    private static final ServiceList serviceList = new ServiceList(); // A global list of all streaming services

    /**
     * The constructor for a {@link StreamingService}
     * @param name The name of the streaming service
     * @param price The monthly price of the service
     */
    public StreamingService(String name, double price) {
        setName(name);
        setPrice(price);

        setLibrary(new StreamingLibrary()); // Create a new streaming library to store exclusive media

        serviceList.addItem(this);
    }

    public static ServiceList getServiceList() {
        return serviceList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public StreamingLibrary getLibrary() {
        return library;
    }

    public void setLibrary(StreamingLibrary library) {
        this.library = library;
    }

    public void addMedia(Streamable media) {
        if(media instanceof Show show) { // If the media is a show,
            // Add each season of the show to the service as an exclusive
            for(int i = 0; i < show.getNumberOfSeasons(); i++) {
                addMedia(show.getSeasons().get(i));
            }
        } else { // Otherwise,
            getLibrary().addItem(media); // Add the media to the service as an exclusive
        }
    }

    public void removeMedia(Streamable media) {
        getLibrary().removeItem(media.getName());
    }

    /**
     * @return A string with the name of each exclusive on the service on a new line
     */
    public String getAllMedia() {
        String output = "";
        for (int i = 0; i < getLibrary().getItemCount(); i++) {
            output = output.concat(getLibrary().getItemNames()[i] + "\n");
        }

        return output;
    }

    public static StreamingService getService(String name) {
        return (StreamingService) serviceList.getItem(name);
    }

    /**
     * @return A string with the name of each service on a new line
     */
    public static String getAllServices() {
        String output = "";
        for(int i = 0; i < serviceList.getItemCount(); i++) {
            output = output.concat(getServiceList().getItems()[i].toString() + "\n");
        }

        return output;
    }

    @Override
    public String toString() {
        return "Name: " + getName() +
                ", Price: " + getPrice();
    }
}
