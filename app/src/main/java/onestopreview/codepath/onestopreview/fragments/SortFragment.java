package onestopreview.codepath.onestopreview.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import onestopreview.codepath.onestopreview.R;

/**
 * Created by aaneja on 4/15/17.
 */

public class SortFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_sort, parent,false);
    }

    public SortFragment() {
    }
}
