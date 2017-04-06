package onestopreview.codepath.onestopreview.models;

/**
 * Created by aaneja on 4/6/2017.
 */

public class DetailedReview {
    String title;
    String description;
    Integer starRating; //TODO: Build a averaging model for ratings from diff networks
    SocialNetwork[] networkLinks;

    ReviewImages[] reviewImages;
    Tag[] tags;
}
