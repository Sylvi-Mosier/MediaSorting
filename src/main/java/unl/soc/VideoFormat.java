package unl.soc;

import java.util.HashMap;

public enum VideoFormat {
	BLURAY,
	DVD,
	VHS;
	
	private static HashMap<String, VideoFormat> hashMap = new HashMap<>();
	
	public static VideoFormat stringToFormat(String rawFormat) {
		hashMap.put("Blu-Ray", BLURAY);
		hashMap.put(    "DVD", DVD);
		hashMap.put(    "VHS", VHS);
		
		return hashMap.get(rawFormat);
	}
}
