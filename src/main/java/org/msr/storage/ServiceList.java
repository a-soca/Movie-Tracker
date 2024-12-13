package org.msr.storage;

import org.msr.services.StreamingService;

import java.util.HashMap;

public class ServiceList implements Repository {
    private final HashMap<String, StreamingService> services;

    public ServiceList() {
        services = new HashMap<>();
    }

    @Override
    public void addItem(Object service) {
        StreamingService s = (StreamingService) service;
        services.put(s.getName(), s);
    }

    @Override
    public void removeItem(String serviceName) {
        services.remove(serviceName);
    }

    @Override
    public Object getItem(String serviceName) {
        return services.get(serviceName);
    }

    @Override
    public int getItemCount() {
        return services.size();
    }

    @Override
    public Object[] getItems() {
        return services.values().toArray();
    }
}
