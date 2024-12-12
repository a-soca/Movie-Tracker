package org.msr.storage;

import org.msr.media.Streamable;

import java.util.HashMap;

public class Library implements Repository {
    HashMap<Streamable, Integer> library;

    Library() {
        library = new HashMap<>();
    }

    public void addItem(Object item) {

    }

    public void removeItem(Object item) {

    }

    public Object getItem(int id) {
        return null;
    }

    public int getItemCount() {
        return 0;
    }
}
