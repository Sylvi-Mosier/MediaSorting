package unl.soc;

import java.time.LocalDate;

public abstract class Video extends Media {
	
	private Medium medium;
	private VideoFormat format;
	private Integer runtime;
	private Integer numDiscs;
	
	public Video(String title, String artist, LocalDate releaseDate, Integer releaseNumber, 
				 Medium medium, VideoFormat format, Integer runtime, Integer numDiscs) {
		super(title, artist, releaseDate, releaseNumber);
		this.medium = medium;
		this.format = format;
		this.runtime = runtime;
		this.numDiscs = numDiscs;
	}

	public Medium getMedium() {
		return medium;
	}
	public VideoFormat getFormat() {
		return format;
	}
	public Integer getRuntime() {
		return runtime;
	}
	public Integer getNumDiscs() {
		return numDiscs;
	}
	
	public String mediaToJson() {
		String medium =   String.format("    \"medium\": \"%s\",\n", getMedium().toString());
		String format =   String.format("    \"videoFormat\": \"%s\",\n", getFormat().toString());
		String runtime =  String.format("    \"runtime\": %d,\n", getRuntime());
		String numDiscs = String.format("    \"numDiscs\": %d\n", getNumDiscs());
		
		return medium + format + runtime + numDiscs;
	}
	
}
