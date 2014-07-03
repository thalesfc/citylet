package com.parse.anywall;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

/**
 * Data model for a post.
 */
@ParseClassName("Posts")
public class AnywallPost extends ParseObject {
	public ParseFile getImageFile() {
		return getParseFile("image");
	}

	public void setImageFile(ParseFile file) {
		put("image", file);
	}
	public String getPrice(){
		return getString("price");
	}
	
	public void setPrice(String value){
		put("price", value);
	}

	public String getText() {
		return getString("text");
	}

	public void setText(String value) {
		put("text", value);
	}

	public ParseUser getUser() {
		return getParseUser("user");
	}

	public void setUser(ParseUser value) {
		put("user", value);
	}

	public ParseGeoPoint getLocation() {
		return getParseGeoPoint("location");
	}

	public void setLocation(ParseGeoPoint value) {
		put("location", value);
	}

	public static ParseQuery<AnywallPost> getQuery() {
		return ParseQuery.getQuery(AnywallPost.class);
	}
}
