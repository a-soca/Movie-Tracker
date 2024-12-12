package org.msr.storage;

public interface Repository {
    public void addItem(Object item);
    public void removeItem(Object item);
    public Object getItem(int id);
    public int getItemCount();
}
