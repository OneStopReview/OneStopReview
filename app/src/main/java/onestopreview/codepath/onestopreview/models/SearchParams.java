package onestopreview.codepath.onestopreview.models;

import android.location.Location;

import org.parceler.Parcel;

@Parcel
public class SearchParams {
    private String searchTerm;
    private Location location;
    private int searchRadiusMeters;
    private int resultsToFetch;

    public int getSearchRadiusMeters() {
        return searchRadiusMeters;
    }

    public int getResultsToFetch() {
        return resultsToFetch;
    }

    public SearchParams(String searchTerm, Location location, int searchRadiusMeters, int resultsToFetch) {
        this.searchTerm = searchTerm;
        this.location = location;
        this.searchRadiusMeters = searchRadiusMeters;
        this.resultsToFetch = resultsToFetch;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public Location getLocation() {
        return location;
    }

    public SearchParams() {
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setSearchRadiusMeters(int searchRadiusMeters) {
        this.searchRadiusMeters = searchRadiusMeters;
    }

    public void setResultsToFetch(int resultsToFetch) {
        this.resultsToFetch = resultsToFetch;
    }
}
