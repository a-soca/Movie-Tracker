package org.msr.services;

import org.msr.storage.Library;

public class StreamingService implements Billable {
    private String name;
    private double price;

    private Library library;

    StreamingService(String name, double price) {
        setName(name);
        setPrice(price);
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

}
