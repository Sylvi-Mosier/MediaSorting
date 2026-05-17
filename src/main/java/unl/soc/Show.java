package unl.soc;

import java.time.LocalDate;

public class Show extends Video {
	
	public Show(String title, String lead, LocalDate releaseDate, Integer releaseNumber, Medium medium,
			 	VideoFormat format, Integer runtime, Integer numDiscs) {
		super(title, lead, releaseDate, releaseNumber, medium, format, runtime, numDiscs);
	}

	public String getLead() {
		return this.getArtist();
	}
	
	@Override
	protected String lineHeader() {
		return String.format("+----------------------------------Shows----------------------------------+\n");
	}
	
}
