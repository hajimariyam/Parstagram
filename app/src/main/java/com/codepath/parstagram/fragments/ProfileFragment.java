package com.codepath.parstagram.fragments;

import android.util.Log;

import com.codepath.parstagram.Post;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

// UI and functionality of PostsFragment accessible here
public class ProfileFragment extends PostsFragment {

    @Override
    protected void queryPosts() {
        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
        query.include(Post.KEY_USER);
        // filter for posts by signed in user
        query.whereEqualTo(Post.KEY_USER, ParseUser.getCurrentUser());
        // show max 29 posts ordered in descending order of createdAt date/time
        query.setLimit(20);
        query.addDescendingOrder(Post.KEY_CREATED_KEY);
        // retrieve all posts, getInBackground is for single items
        query.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Issue with getting posts", e);
                    return;
                }
                // if no error, iterate through posts
                for (Post post : posts) {
                    Log.i(TAG, "Post: " + post.getDescription() + ", username: " + post.getUser().getUsername());
                }
                // when queryPosts() returns data, update data source, and notify adapter
                allPosts.addAll(posts);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
