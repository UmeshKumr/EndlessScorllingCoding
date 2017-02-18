package com.example.ideal.endlessscorllingcoding;

import android.support.v7.widget.RecyclerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ideal on 2/18/2017.
 */

public class ExploreInteracter implements ExploreInteracterView {

    private ExplorePresenterView presenter;

    public ExploreInteracter(ExplorePresenterView presenter){
        this.presenter = presenter;
    }


    @Override
    public void request(int page) {}

    public void fetchData(int page,int max,RecyclerView view){
        for(int i=page;i<=max;i++){
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("http://jsonplaceholder.typicode.com/posts/"+i)
                    .build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    // net fail System.out.println("Failure here wit Excep "+e);

                    presenter.onNetworkUnavailable(1);
                }

                @Override
                public void onResponse(Call call, final Response response) throws IOException {
                    try {
                        String responseData = response.body().string();
                        JSONObject json = new JSONObject(responseData);
                        Post post = Post.jsontoPost(json);

                        presenter.onSuccess();
                        presenter.addItem(post);
                        // mlistener.addPost(post);
                        //  System.out.println(" post id "+post.getTitle());

                    } catch (JSONException e) {
                        //System.out.println("json exception "+e);
                        presenter.onFailure(1);
                    }
                }
            });

        }
    }

}
