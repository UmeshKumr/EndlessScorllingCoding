package com.example.ideal.endlessscorllingcoding;

/**
 * Created by ideal on 2/18/2017.
 */

public interface ExploreMainView {
    void showProgress();
    void hideProgress();
    void showLoadMoreProgress();
    void hideLoadMoreProgress();
    void loadMoreNetworkUnavailable();
    void networkUnavailable();

}
