package com.codepath.parstagram;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.util.Date;

@ParseClassName("Post")
public class Post extends ParseObject {

    // match to keys (columns) on Parse table
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_USER = "user";
    public static final String KEY_CREATED_KEY = "createdAt";

    // getter for description, returns string
    public String getDescription() {
        // return method defined in ParseObject.java (ctrl+click)
        return getString(KEY_DESCRIPTION);
    }

    // setter (void bc no return) for description
    public void setDescription(String description) {
        // set KEY_DESCRIPTION as description, put method defined in ParseObject.java (ctrl+click)
        put(KEY_DESCRIPTION, description);
    }

    public ParseFile getImage() {
        return getParseFile(KEY_IMAGE);
    }

    public void setImage(ParseFile parseFile) {
        put(KEY_IMAGE, parseFile);
    }

    public ParseUser getUser() {
        return getParseUser(KEY_USER);
    }

    public void setUser(ParseUser user) {
        put(KEY_USER, user);
    }

}
