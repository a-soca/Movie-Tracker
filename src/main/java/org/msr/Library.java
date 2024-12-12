package org.msr;

import java.util.HashMap;

public class Library extends Repository {
    HashMap<Streamable, Integer> library;

    Library() {
        library = new HashMap<>();
    }

    @Override
    public void addItem(Object item) {

    }

    @Override
    public void removeItem(Object item) {

    }

    @Override
    public Object getItem(int id) {
        return null;
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
