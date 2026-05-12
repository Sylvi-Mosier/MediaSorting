package unl.soc;

import java.time.LocalDate;

public abstract class Music extends Media {

	private Integer runtime;
	
	public Music(String title, String artist, LocalDate releaseDate, Integer releaseNumber, Integer runtime) {
		super(title, artist, releaseDate, releaseNumber);
		this.runtime = runtime;
	}

	public Integer getRuntime() {
		return runtime;
	}
	
}
