
package onestopreview.codepath.onestopreview.models.facebook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import onestopreview.codepath.onestopreview.models.DetailedReview;
import onestopreview.codepath.onestopreview.models.ResultItem;
import onestopreview.codepath.onestopreview.models.SocialNetwork;

public class PlacesSearchResult extends SocialNetwork {


    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("about")
    @Expose
    private String about;
    @SerializedName("engagement")
    @Expose
    private Engagement engagement;
    @SerializedName("overall_star_rating")
    @Expose
    private Double overallStarRating;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("hours")
    @Expose
    private Hours hours;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("picture")
    @Expose
    private Picture picture;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("id")
    @Expose
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Engagement getEngagement() {
        return engagement;
    }

    public void setEngagement(Engagement engagement) {
        this.engagement = engagement;
    }

    public Double getOverallStarRating() {
        return overallStarRating;
    }

    public void setOverallStarRating(Double overallStarRating) {
        this.overallStarRating = overallStarRating;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Hours getHours() {
        return hours;
    }

    public void setHours(Hours hours) {
        this.hours = hours;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ResultItem CreateResultItem() {
        ResultItem resultItem = new ResultItem(id, engagement.getCount(), picture.getData().getUrl(), name, about, new DetailedReview());
        if(location!=null) {
            android.location.Location locationToSet = new android.location.Location("");
            locationToSet.setLatitude(location.getLatitude());
            locationToSet.setLongitude(location.getLongitude());
            resultItem.setLocation(locationToSet);
        }
        return resultItem;
    }
}