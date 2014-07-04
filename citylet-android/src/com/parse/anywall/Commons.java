package com.parse.anywall;

import android.location.Location;

import com.parse.ParseGeoPoint;
import com.parse.ParseQuery;

public class Commons {

	// Maximum post search radius for map in kilometers
	public static final int MAX_POST_SEARCH_DISTANCE = 100;

	// get map query
	public static ParseQuery<AnywallPost> getParseQuery(ParseGeoPoint myLoc) {
		ParseQuery<AnywallPost> query = AnywallPost.getQuery();
		query.include("user");
		query.whereNear("location", myLoc);
		query.whereWithinKilometers("location", myLoc, MAX_POST_SEARCH_DISTANCE);
		return query;
	}

	/*
	 * Helper method to get the Parse GEO point representation of a location
	 */
	public static ParseGeoPoint geoPointFromLocation(Location loc) {
		return new ParseGeoPoint(loc.getLatitude(), loc.getLongitude());
	}
}
