package onestopreview.codepath.onestopreview.api;

import android.os.Bundle;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;

import onestopreview.codepath.onestopreview.models.SearchParams;

/**
 * Created by aaneja on 4/7/17.
 */

public class Facebook {

    public void SearchPlaces(SearchParams searchParams, GraphRequest.GraphJSONArrayCallback callback){
        GraphRequest graphRequest = GraphRequest.newPlacesSearchRequest(AccessToken.getCurrentAccessToken(), searchParams.getLocation(), 20000, 100, searchParams.getSearchTerm(), callback);
        Bundle params = graphRequest.getParameters();
        params.putString("fields", "id,name,about,engagement,overall_star_rating,link,hours,phone,picture.type(large),location");
        graphRequest.executeAsync();
    }
}
