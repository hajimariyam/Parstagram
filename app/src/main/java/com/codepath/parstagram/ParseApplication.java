package com.codepath.parstagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Register parse models before Parse.initialize
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("Rzyq5SAFzVulC4Fvh9fH2Y4N1Y4YcbkXOV0xKmAe")
                .clientKey("Eb0P4mCxlSvFsLeBEQgrJLCi8nzWkhV9JmvsS96W")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
