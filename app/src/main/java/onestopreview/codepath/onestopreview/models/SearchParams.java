package onestopreview.codepath.onestopreview.models;

import android.location.Location;

import org.parceler.Parcel;

@Parcel
public class SearchParams {
    private String searchTerm;
    private Location location;

    public SearchParams(String searchTerm, Location location) {
        this.searchTerm = searchTerm;
        this.location = location;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public Location getLocation() {
        return location;
    }

    public SearchParams() {
    }
}
