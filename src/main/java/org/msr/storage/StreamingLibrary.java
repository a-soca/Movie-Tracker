package org.msr.storage;

import org.msr.media.Streamable;

import java.util.HashMap;

public class StreamingLibrary implements Repository {
    HashMap<String, Streamable> library;

    public StreamingLibrary() {
        library = new HashMap<>();
    }

    public void addItem(Object item) {
        Streamable media = (Streamable) item;
        library.put(media.getName(), media);
    }

    public void removeItem(String mediaName) {
        library.remove(mediaName);
    }

    public Object getItem(String mediaName) {
        return library.get(mediaName);
    }

    public int getItemCount() {
        return 0;
    }

    public String[] getItemNames() {
        return this.library.keySet().toArray(new String[0]);
    }
}