package com.example.ideal.endlessscorllingcoding;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ideal on 2/18/2017.
 */

public class ExploreAdapter extends RecyclerView.Adapter<ExploreAdapter.ViewHolder> implements ExploreAdapterView {

    private static List<Post> mPosts;
    ExplorePresenter presenter;

    public ExploreAdapter(List<Post> contacts) {
        mPosts = contacts;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView idTextView, userIdTextView, titleTextView, bodyTextView;


        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            idTextView = (TextView) itemView.findViewById(R.id.contact_id);
            userIdTextView = (TextView) itemView.findViewById(R.id.contact_userId);
            titleTextView = (TextView) itemView.findViewById(R.id.contact_title);
            bodyTextView = (TextView) itemView.findViewById(R.id.contact_body);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.item_contact, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Post post = mPosts.get(position);

        TextView idtextView = viewHolder.idTextView;
        idtextView.setText(String.valueOf(post.getId()));
        TextView userIdtextView = viewHolder.userIdTextView;
        userIdtextView.setText(String.valueOf(post.getUserId()));
        TextView titletextView = viewHolder.titleTextView;
        titletextView.setText(post.getTitle());
        TextView bodytextView = viewHolder.bodyTextView;
        bodytextView.setText(post.getBody());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void requestData() {
        presenter.requestData();
    }

    @Override
    public void addItem(Post post) {
        presenter.addItem(post);
    }

    @Override
    public void loadMore(int page) {
        presenter.loadMore(1);
    }

}
