package com.parse.anywall;

import android.content.Context;
import android.content.SharedPreferences;

import com.parse.Parse;
import com.parse.ParseObject;

public class Application extends android.app.Application {
  // Debugging switch
  public static final boolean APPDEBUG = true;
  
  // Debugging tag for the application
  public static final String APPTAG = "AnyWall";

  // Key for saving the search distance preference
  private static final String KEY_SEARCH_DISTANCE = "searchDistance";

  private static SharedPreferences preferences;

  public Application() {
  }

  @Override
  public void onCreate() {
    super.onCreate();

    ParseObject.registerSubclass(AnywallPost.class);
    Parse.initialize(this, "yJbawGg9xwf2YK6gBYfTXHgCnP9Z4i221y7jKUSz",
        "ioT0FrdWODwh6kU7vmQfjnmgoI1CKIZyYed2jL7j");
    preferences = getSharedPreferences("com.parse.anywall", Context.MODE_PRIVATE);
  }

  public static float getSearchDistance() {
    return preferences.getFloat(KEY_SEARCH_DISTANCE, 4000);
  }

  public static void setSearchDistance(float value) {
    preferences.edit().putFloat(KEY_SEARCH_DISTANCE, value).commit();
  }

}
