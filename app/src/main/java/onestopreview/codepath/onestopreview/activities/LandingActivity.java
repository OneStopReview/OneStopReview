package onestopreview.codepath.onestopreview.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import onestopreview.codepath.onestopreview.R;
import onestopreview.codepath.onestopreview.adapters.ResultItemAdapter;
import onestopreview.codepath.onestopreview.api.Facebook;
import onestopreview.codepath.onestopreview.databinding.ActivityLandingBinding;
import onestopreview.codepath.onestopreview.interfaces.ResultsProcessor;
import onestopreview.codepath.onestopreview.interfaces.Searcher;
import onestopreview.codepath.onestopreview.models.ResultItem;
import onestopreview.codepath.onestopreview.models.SearchParams;

public class LandingActivity extends AppCompatActivity implements ResultsProcessor{

    public static final String SEARCH_RESULTS = "SEARCH_RESULTS";
    public static final String SEARCH_PARAMS = "SEARCH_PARAMS";
    private ActivityLandingBinding binding;
    private SearchParams searchedParams;
    private Facebook fbApi = new Facebook();
    private List<Searcher> apiSources = new ArrayList<>();
    private List<ResultItem> resultItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        HookupApiSources();

        binding = DataBindingUtil.setContentView(this, R.layout.activity_landing);

        resultItems =  Parcels.unwrap(getIntent().getParcelableExtra(SEARCH_RESULTS));
        searchedParams = Parcels.unwrap(getIntent().getParcelableExtra(SEARCH_PARAMS));
        binding.rvSearchResults.setAdapter(new ResultItemAdapter(resultItems, searchedParams));
        binding.rvSearchResults.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
    }

    //Based on connected networks hookup API sources
    private void HookupApiSources() {
        apiSources.add(fbApi); //for now assume we have the fbApi functional
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.landing_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String newSearchTerm) {
                // perform query here
                searchedParams.setSearchTerm(newSearchTerm);
                for (Searcher searcher :
                        apiSources) {
                    searcher.DoSearch(searchedParams, LandingActivity.this);
                }
                // workaround to avoid issues with some emulators and keyboard devices firing twice if a keyboard enter is used
                // see https://code.google.com/p/android/issues/detail?id=24599
                searchView.clearFocus();

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void ProcessResults(List<ResultItem> results) {
        resultItems.clear();
        resultItems.addAll(results); //TODO:Re-implement in Sprint 3 to merge results reg the same location into a single result
        binding.rvSearchResults.scrollToPosition(0);
        binding.rvSearchResults.getAdapter().notifyDataSetChanged();
    }
}
