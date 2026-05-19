package unl.soc;

import java.util.HashMap;

public enum LengthUnit {
	FEET("Feet"),
	INCHES("Inches"),
	CENTIMETERS("Centimeters"),
	MILLIMETERS("Millimeters");
	
	private final String lengthUnit;
	
	LengthUnit(String lengthUnit) {
		this.lengthUnit = lengthUnit;
	}
	
	public String string() {
		return this.lengthUnit;
	}
	
	private static HashMap<String, LengthUnit> hashMap = new HashMap<>();
	
	public static LengthUnit parseUnit(String rawUnit) {
		hashMap.put(	   "Feet", FEET);
		hashMap.put(	 "Inches", INCHES);
		hashMap.put("Centimeters", CENTIMETERS);
		hashMap.put("Millimeters", MILLIMETERS);
		
		return hashMap.get(rawUnit);
	}
}
