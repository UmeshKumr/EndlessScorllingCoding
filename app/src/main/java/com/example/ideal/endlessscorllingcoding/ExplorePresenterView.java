package com.example.ideal.endlessscorllingcoding;

/**
 * Created by ideal on 2/18/2017.
 */

public interface ExplorePresenterView {
    void addItem(Post post);
    void onSuccess();
    void onFailure(int page);
    void onNetworkUnavailable(int page);
    void requestData();
    void loadMore(int page);
}
