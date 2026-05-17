package unl.soc;

import java.time.LocalDate;

public class Movie extends Video {

	public Movie(String title, String director, LocalDate releaseDate, Integer releaseNumber, Medium medium,
				 VideoFormat format, Integer runtime, Integer numDiscs) {
		super(title, director, releaseDate, releaseNumber, medium, format, runtime, numDiscs);
	}
	
	public String getDirector() {
		return this.getArtist();
	}
	
	@Override
	protected String lineHeader() {
		return String.format("+----------------------------------Movies---------------------------------+\n");
	}
	
}
