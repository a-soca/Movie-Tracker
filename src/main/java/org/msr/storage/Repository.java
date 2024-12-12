package org.msr.storage;

public abstract class Repository {
    public abstract void addItem(Object item);
    public abstract void removeItem(Object item);
    public abstract Object getItem(int id);
    public abstract int getItemCount();
}
