package unl.soc;

import java.time.LocalDate;

public class CD extends Music {
	
	private Integer numCDs;
	
	public CD(String title, String artist, LocalDate releaseDate, Integer releaseNumber, Integer runtime, Integer numCDs) {
		super(title, artist, releaseDate, releaseNumber, runtime);
		this.numCDs = numCDs;
	}

	public Integer getNumCDs() {
		return numCDs;
	}
	
}
