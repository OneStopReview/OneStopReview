package onestopreview.codepath.onestopreview.activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.StaggeredGridLayoutManager;

import org.parceler.Parcels;

import java.util.List;

import onestopreview.codepath.onestopreview.R;
import onestopreview.codepath.onestopreview.adapters.ResultItemAdapter;
import onestopreview.codepath.onestopreview.databinding.ActivityLandingBinding;
import onestopreview.codepath.onestopreview.models.ResultItem;
import onestopreview.codepath.onestopreview.models.SearchParams;

public class LandingActivity extends AppCompatActivity {

    public static final String SEARCH_RESULTS = "SEARCH_RESULTS";
    public static final String SEARCH_PARAMS = "SEARCH_PARAMS";
    private ActivityLandingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_landing);

        List<ResultItem> resultItems = (List<ResultItem>) Parcels.unwrap(getIntent().getParcelableExtra(SEARCH_RESULTS));
        SearchParams searchedParams = (SearchParams) Parcels.unwrap(getIntent().getParcelableExtra(SEARCH_PARAMS));
        binding.rvSearchResults.setAdapter(new ResultItemAdapter(resultItems, searchedParams));
        binding.rvSearchResults.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
    }
}
