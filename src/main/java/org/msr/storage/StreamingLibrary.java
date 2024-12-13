package org.msr.storage;

import org.msr.media.Streamable;

import java.util.HashMap;

/**
 * A Streaming Library is a {@link Repository} which stores {@link Streamable} media. Stores a list of all
 * media added to the application in {@link #mediaList} (accessible with {@link #getMedia(String)})
 */
public class StreamingLibrary implements Repository {
    HashMap<String, Streamable> library; // A Hashmap to store Streamable media (key = media name)

    // A master library for all streamable media added to the application
    private static final StreamingLibrary mediaList = new StreamingLibrary();

    public StreamingLibrary() {
        library = new HashMap<>();
    }

    @Override
    public void addItem(Object item) {
        Streamable media = (Streamable) item;
        library.put(media.getName(), media);
    }

    @Override
    public void removeItem(String mediaName) {
        library.remove(mediaName);
    }

    @Override
    public Object getItem(String mediaName) {
        return library.get(mediaName);
    }

    @Override
    public int getItemCount() {
        return library.size();
    }

    @Override
    public Object[] getItems() {
        return library.values().toArray();
    }


    public String[] getItemNames() {
        return this.library.keySet().toArray(new String[0]);
    }

    public static StreamingLibrary getMediaList() {
        return mediaList;
    }

    public static Streamable getMedia(String mediaName) {
        return (Streamable) getMediaList().getItem(mediaName);
    }

    /**
     * @return A string of all the streamable media added to the app with each media item on a new line
     */
    public static String getAllMedia() {
        String output = "";
        for(int i = 0; i < getMediaList().getItemCount(); i++) {
            output = output.concat(getMediaList().getItems()[i].toString() + "\n");
        }

        return output;
    }
}