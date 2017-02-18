package com.example.ideal.endlessscorllingcoding;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ideal on 2/18/2017.
 */

public class Post {
    private int id;
    private int userId;
    private String title;
    private String body;

    public Post(){}
    public Post(int id,int userId,String title,String body){
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }
    public void setPost(int id,int userId,String title,String body){
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }
    public static Post jsontoPost(JSONObject jsonObject){
        Post post = new Post();
        try {
            post.setPost(Integer.valueOf(jsonObject.getString("id")),Integer.valueOf(jsonObject.getString("userId")),jsonObject.getString("title"),jsonObject.getString("body"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return  post;
    }
}
