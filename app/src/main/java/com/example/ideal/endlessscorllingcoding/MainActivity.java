package com.example.ideal.endlessscorllingcoding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ExploreMainView {

    RecyclerView recyclerView;
    ProgressBar progressBar1,progressBar2;
    TextView textView1,textView2;
    public List<Post> allPosts;
    private int index;
    public ExploreAdapter adapter;
    public RecyclerView.LayoutManager l;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
            textView1 = (TextView) findViewById(R.id.text_view1);
            textView2 = (TextView) findViewById(R.id.text_view2);
            progressBar1 = (ProgressBar) findViewById(R.id.progress_bar1);
            progressBar2 = (ProgressBar) findViewById(R.id.progress_bar2);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar);
        allPosts = new ArrayList<Post>();
        adapter = new ExploreAdapter(allPosts);

         final LinearLayoutManager l  = new LinearLayoutManager(this);
         recyclerView.setLayoutManager(l);
         recyclerView.setAdapter(adapter);

        EndlessRecyclerViewScrollListener scrollListener = new EndlessRecyclerViewScrollListener(l) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                adapter.loadMore(1);
            }
        };
        recyclerView.addOnScrollListener(scrollListener);

    }
    public void alert(){
        recyclerView.post(new Runnable() {
            @Override
            public void run() {
                adapter.notifyDataSetChanged();
            }
        });

    }


    @Override
        public void showProgress (){
            recyclerView.setVisibility(View.INVISIBLE);
           textView1.setVisibility(View.INVISIBLE);
        progressBar1.setVisibility(View.VISIBLE);
            progressBar2.setVisibility(View.INVISIBLE);
            textView2.setVisibility(View.INVISIBLE);
        }

        @Override
        public void hideProgress () {
            recyclerView.setVisibility(View.VISIBLE);
            progressBar1.setVisibility(View.INVISIBLE);
            progressBar2.setVisibility(View.INVISIBLE);
            textView1.setVisibility(View.INVISIBLE);
            textView2.setVisibility(View.INVISIBLE);
        }

        @Override
        public void showLoadMoreProgress () {
            recyclerView.setVisibility(View.VISIBLE);
            progressBar1.setVisibility(View.INVISIBLE);
            progressBar2.setVisibility(View.VISIBLE);
            textView1.setVisibility(View.INVISIBLE);
            textView2.setVisibility(View.INVISIBLE);
        }

        @Override
        public void hideLoadMoreProgress () {
            recyclerView.setVisibility(View.VISIBLE);
            progressBar1.setVisibility(View.INVISIBLE);
            progressBar2.setVisibility(View.INVISIBLE);
            textView1.setVisibility(View.INVISIBLE);
            textView2.setVisibility(View.INVISIBLE);
        }

        @Override
        public void loadMoreNetworkUnavailable () {
            recyclerView.setVisibility(View.VISIBLE);
            progressBar1.setVisibility(View.INVISIBLE);
            progressBar2.setVisibility(View.INVISIBLE);
            textView1.setVisibility(View.INVISIBLE);
            textView2.setVisibility(View.VISIBLE);
        }

        @Override
        public void networkUnavailable () {
            recyclerView.setVisibility(View.INVISIBLE);
            progressBar1.setVisibility(View.INVISIBLE);
            progressBar2.setVisibility(View.INVISIBLE);
            textView1.setVisibility(View.VISIBLE);
            textView2.setVisibility(View.INVISIBLE);
        }
    }
