package unl.soc;

import java.time.LocalDate;

public class Vinyl extends Music {

	private Integer numLPs;
	
	public Vinyl(String title, String artist, LocalDate releaseDate, Integer releaseNumber, Integer runtime, Integer numLPs) {
		super(title, artist, releaseDate, releaseNumber, runtime);
		this.numLPs = numLPs;
	}
	
	public Integer getNumLPs() {
		return numLPs;
	}
	
}
