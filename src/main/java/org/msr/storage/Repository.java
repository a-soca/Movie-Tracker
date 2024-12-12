package org.msr.storage;

public interface Repository {
    public void addItem(Object item);
    public void removeItem(String id);
    public Object getItem(String id);
    public int getItemCount();
}
