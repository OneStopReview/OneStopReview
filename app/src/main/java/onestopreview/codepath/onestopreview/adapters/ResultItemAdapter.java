package onestopreview.codepath.onestopreview.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import onestopreview.codepath.onestopreview.databinding.ResultitemLayoutBinding;
import onestopreview.codepath.onestopreview.models.ResultItem;
import onestopreview.codepath.onestopreview.models.SearchParams;

/**
 * Created by aaneja on 4/9/17.
 */


public class ResultItemAdapter extends
        RecyclerView.Adapter<ResultItemAdapter.ViewHolder> {
    private final SearchParams searchedParams;
    private List<ResultItem> FetchedResults;

    public ResultItemAdapter(List<ResultItem> fetchedResults, SearchParams searchedParams) {
        FetchedResults = fetchedResults;
        this.searchedParams = searchedParams; 
    }

    public static class ViewHolder extends RecyclerView.ViewHolder  {

        private ResultitemLayoutBinding binding;

        public ViewHolder(ResultitemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(ResultItem resultItem, SearchParams searchedParams) {
            binding.tvTitle.setText(resultItem.getTitle());
            binding.tvDescription.setText(resultItem.getDescription());
            binding.tvLikes.setText(String.format("%d likes", resultItem.getLikeCount()));
            if(resultItem.getLocation()!=null) {
                binding.tvDistance.setText(String.format("%f meters away", resultItem.GetDistanceTo(searchedParams.getLocation())));
            }
            Glide.with(binding.ivProfile.getContext()).load(resultItem.getProfileUrl()).into(binding.ivProfile);
            binding.executePendingBindings();
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ResultItem tweet = getItemForPosition(position);
        holder.bind(tweet,searchedParams);
    }

    private ResultItem getItemForPosition(int position) {
        return FetchedResults.get(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ResultitemLayoutBinding itemBinding =  ResultitemLayoutBinding.inflate(inflater, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemBinding);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return FetchedResults.size();
    }
}
