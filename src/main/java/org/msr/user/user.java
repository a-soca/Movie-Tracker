package org.msr.user;

import org.msr.media.Streamable;
import org.msr.services.StreamingService;

public abstract class user {
    public abstract void addStreamingService();
    public abstract void removeStreamingService();

    public abstract void addMediaToService();
    public abstract void removeMediaFromService();

    public abstract String getAllTrackedMedia();
    public abstract String getMediaFromService();

    public abstract void addRating();
}
