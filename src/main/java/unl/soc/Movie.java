package unl.soc;

import java.time.LocalDate;

public class Movie extends Video {

	public Movie(String title, String director, LocalDate releaseDate, Integer releaseNumber, Medium medium,
				 VideoFormat format, Integer runtime, Integer numDiscs) {
		super(title, director, releaseDate, releaseNumber, medium, format, runtime, numDiscs);
		if (format == VideoFormat.CRITERION) {
			if (numDiscs < 3) {
				this.setDimensions(new Dimension(5.5625, 0.5, 6.875, LengthUnit.INCHES));
			} else {
				this.setDimensions(new Dimension(137.5, 19.05, 174.625));
			}
		}
	}
	
	public Movie(String title, String director, LocalDate releaseDate, Integer releaseNumber, Medium medium,
			 	 VideoFormat format, Integer runtime, Integer numDiscs, Dimension dimension) {
	super(title, director, releaseDate, releaseNumber, medium, format, runtime, numDiscs, dimension);
	
}
	
	public String getDirector() {
		return this.getArtist();
	}
	
	@Override
	protected String lineHeader() {
		return String.format("+----------------------------------Movies---------------------------------+\n");
	}
	
}
