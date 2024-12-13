package org.msr.storage;

/**
 * Repositories store data which can be accessed, added or removed
 */
public interface Repository {
    void addItem(Object item);
    void removeItem(String id);
    Object getItem(String id);
    int getItemCount();
    Object[] getItems();
}
