package org.msr.services;

import org.msr.media.Show;
import org.msr.media.Streamable;
import org.msr.storage.StreamingLibrary;

public class StreamingService implements Billable {
    private String name;
    private double price;

    private StreamingLibrary library;

    public StreamingService(String name, double price) {
        setName(name);
        setPrice(price);

        setLibrary(new StreamingLibrary());
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
        if(media instanceof Show show) {
            for(int i = 0; i < show.getNumberOfSeasons(); i++) {
                addMedia(show.getSeasons().get(i));
            }
        } else {
            getLibrary().addItem(media);
        }
    }

    public void addShow(Show show) {
        getLibrary().addItem(show.getSeasons());
    }

    public void removeMedia(Streamable media) {
        getLibrary().removeItem(media.getName());
    }

    public String getAllMedia() {
        String output = "";
        for (int i = 0; i < getLibrary().getItemNames().length; i++) {
            output = output.concat(getLibrary().getItemNames()[i] + "\n");
        }

        return output;
    }
}
