package unl.soc;

import java.util.HashMap;

public enum Medium {
	LIVE_ACTION,
	TWO_DIMENSION_ANIMATION,
	THREE_DIMENSION_ANIMATION,
	STOP_MOTION_ANIMATION;
	
	private static HashMap<String, Medium> hashMap = new HashMap<>();
	
	public static Medium stringToMedium(String rawMedium) {
		hashMap.put( "Live Action", LIVE_ACTION);
		hashMap.put("2D Animation", TWO_DIMENSION_ANIMATION);
		hashMap.put("3D Animation", THREE_DIMENSION_ANIMATION);
		hashMap.put( "Stop Motion", STOP_MOTION_ANIMATION);
		
		return hashMap.get(rawMedium);
	}
	
}
