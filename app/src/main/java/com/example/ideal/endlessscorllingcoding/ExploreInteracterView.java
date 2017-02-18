package com.example.ideal.endlessscorllingcoding;

import android.support.v7.widget.RecyclerView;

/**
 * Created by ideal on 2/18/2017.
 */

public interface ExploreInteracterView {

    void request(int page);
    void fetchData(int page,int max,RecyclerView view);
}
