package com.example.springboot.util;

public class DistanceCalculator {
	
	 public static final double RADIUS_OF_EARTH = 6371; // Radius of the Earth in kilometers
	    
	 //Calculated using The Haversine formula, which takes into account the curvature of the Earth.
	    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
	        double latDistance = Math.toRadians(lat2 - lat1);
	        double lonDistance = Math.toRadians(lon2 - lon1);
	        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
	                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	        return RADIUS_OF_EARTH * c;
	    }

}
