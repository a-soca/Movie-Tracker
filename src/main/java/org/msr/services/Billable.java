package org.msr.services;

/**
 * A service which costs money
 */
public interface Billable {
    void setPrice(double price);
    double getPrice();
}
