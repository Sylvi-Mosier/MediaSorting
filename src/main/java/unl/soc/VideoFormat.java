package unl.soc;

import java.util.HashMap;

public enum VideoFormat {
	CRITERION(0),
	BLURAY(1),
	DVD(2),
	VHS(3);
	
	private final Integer formatValue;
	
	VideoFormat(int formatValue) {
		this.formatValue = formatValue;
	}
	
	public Integer getFormatValue() {
		return this.formatValue;
	}
	
	
	private static HashMap<String, VideoFormat> hashMap = new HashMap<>();
	
	public static VideoFormat stringToFormat(String rawFormat) {
		hashMap.put("Criterion", CRITERION);
		hashMap.put(  "Blu-Ray", BLURAY);
		hashMap.put(	  "DVD", DVD);
		hashMap.put(	  "VHS", VHS);
		
		return hashMap.get(rawFormat);
	}
}
