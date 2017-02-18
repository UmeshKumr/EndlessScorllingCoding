package com.example.ideal.endlessscorllingcoding;

import android.support.v7.widget.RecyclerView;

/**
 * Created by ideal on 2/18/2017.
 */

public class ExplorePresenter implements ExplorePresenterView {
    RecyclerView recyclerView;
    private final ExploreAdapterView adapter;
    private final ExploreMainView view;
    private final ExploreInteracterView interacter;


    public ExplorePresenter(ExploreAdapterView adapter, ExploreMainView view) {
        this.adapter = adapter;
        this.view = view;
        this.interacter = new ExploreInteracter(this);
    }


    @Override
    public void addItem(Post post) {
        adapter.addItem(post);
    }

    @Override
    public void onSuccess() {
        view.hideProgress();
    }

    @Override
    public void onFailure(int page) {
        if (page == 1){
            view.networkUnavailable();
        }
        else {
            view.loadMoreNetworkUnavailable();
        }
    }

    @Override
    public void onNetworkUnavailable(int page) {
        if (page == 1){
            view.networkUnavailable();
        }
        else {
            view.loadMoreNetworkUnavailable();
        }
    }

    @Override
    public void requestData() {
        if(view !=null){
            view.showProgress();
        }
        interacter.request(1);
       }


    @Override
    public void loadMore(int page) {
        interacter.fetchData(page,10,recyclerView);
    }
}
