package onestopreview.codepath.onestopreview.api;

import android.os.Bundle;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import org.json.JSONArray;

import java.util.ArrayList;

import onestopreview.codepath.onestopreview.interfaces.Searcher;
import onestopreview.codepath.onestopreview.interfaces.ResultsProcessor;
import onestopreview.codepath.onestopreview.models.ResultItem;
import onestopreview.codepath.onestopreview.models.SearchParams;
import onestopreview.codepath.onestopreview.models.facebook.PlacesSearchResult;

/**
 * Created by aaneja on 4/7/17.
 */

public class Facebook implements Searcher {

    public static void SearchPlaces(SearchParams searchParams, GraphRequest.GraphJSONArrayCallback callback){
        GraphRequest graphRequest = GraphRequest.newPlacesSearchRequest(AccessToken.getCurrentAccessToken(), searchParams.getLocation(), searchParams.getSearchRadiusMeters(), searchParams.getResultsToFetch(), searchParams.getSearchTerm(), callback);
        Bundle params = graphRequest.getParameters();
        params.putString("fields", "id,name,about,engagement,overall_star_rating,link,hours,phone,picture.type(large),location");
        graphRequest.executeAsync();
    }

    @Override
    public void DoSearch(final SearchParams params, final ResultsProcessor processor) {
        SearchPlaces(params, new GraphRequest.GraphJSONArrayCallback() {
            @Override
            public void onCompleted(JSONArray objects, GraphResponse response) {
                Log.i("OBJECTS",objects.toString());
                Gson gson = new GsonBuilder().create();
                PlacesSearchResult[] placesSearchResults = new PlacesSearchResult[0];

                JsonElement data = gson.fromJson(response.getRawResponse(), JsonElement.class);
                placesSearchResults = gson.fromJson(data.getAsJsonObject().get("data"), PlacesSearchResult[].class);

                ArrayList<ResultItem> results = new ArrayList<>();
                for (PlacesSearchResult item :
                        placesSearchResults) {
                    results.add(item.CreateResultItem());
                }
                processor.ProcessResults(results);
            }
        });
    }
}
