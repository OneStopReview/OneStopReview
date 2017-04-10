
package onestopreview.codepath.onestopreview.models.facebook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Engagement {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("social_sentence")
    @Expose
    private String socialSentence;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getSocialSentence() {
        return socialSentence;
    }

    public void setSocialSentence(String socialSentence) {
        this.socialSentence = socialSentence;
    }

}
