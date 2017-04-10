package onestopreview.codepath.onestopreview.models;

import android.location.Location;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

/**
 * Created by aaneja on 4/6/2017.
 */

@Parcel(analyze = ResultItem.class)
public class ResultItem {
    String Id;
    Integer LikeCount;

    DetailedReview detailedReview;

    //Small image url
    String profileUrl;
    String title;
    String description;

    Location location;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Integer getLikeCount() {
        return LikeCount;
    }

    public void setLikeCount(Integer likeCount) {
        LikeCount = likeCount;
    }

    public DetailedReview getDetailedReview() {
        return detailedReview;
    }

    public void setDetailedReview(DetailedReview detailedReview) {
        this.detailedReview = detailedReview;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @ParcelConstructor
    public ResultItem() {
    }

    public ResultItem(String id, Integer likeCount, String profileUrl, String title, String description, DetailedReview detailedReview) {
        Id = id;
        LikeCount = likeCount;
        this.profileUrl = profileUrl;
        this.title = title;
        this.description = description;
        this.detailedReview = detailedReview;
    }

    public float GetDistanceTo(Location location){
        if(location == null || this.location == null){
            return -1;
        }
        return this.location.distanceTo(location);
    }

}

