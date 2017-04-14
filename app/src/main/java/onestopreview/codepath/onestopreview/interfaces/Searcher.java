package onestopreview.codepath.onestopreview.interfaces;

import java.util.ArrayList;

import onestopreview.codepath.onestopreview.models.ResultItem;
import onestopreview.codepath.onestopreview.models.SearchParams;

/**
 * Created by aaneja on 4/14/17.
 */

public interface Searcher {
    void DoSearch(SearchParams params, ResultsProcessor processor);
}
