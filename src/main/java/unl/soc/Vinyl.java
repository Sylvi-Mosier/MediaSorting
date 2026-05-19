package unl.soc;

import java.time.LocalDate;

public class Vinyl extends Music {

	private Integer numLPs;
	
	public Vinyl(String title, String artist, LocalDate releaseDate, Integer releaseNumber, Integer runtime, Integer numLPs) {
		super(title, artist, releaseDate, releaseNumber, runtime);
		this.numLPs = numLPs;
		this.setDimensions(findDimension(numLPs));
	}
	
	public Vinyl(String title, String artist, LocalDate releaseDate, Integer releaseNumber, 
				 Integer runtime, Integer numLPs, Dimension size) {
		super(title, artist, releaseDate, releaseNumber, size, runtime);
		this.numLPs = numLPs;
	}
	
	public Vinyl(String title, String artist, LocalDate releaseDate, Integer releaseNumber, 
			 Double length, Double width, Double height, Integer runtime, Integer numLPs) {
		super(title, artist, releaseDate, releaseNumber, length, width, height, runtime);
		this.numLPs = numLPs;
	}
	
	private static Dimension findDimension(int numLPs) {
		if 		(numLPs == 1) {return new Dimension(331.15,  5.0, 331.15);}
		else if (numLPs == 2) {return new Dimension(331.15, 12.7, 331.15);}
		else 				  {return null;}
	}
	
	public Integer getNumLPs() {
		return numLPs;
	}
	
	@Override
	protected String lineHeader() {
		return String.format("+----------------------------------Vinyl----------------------------------+\n");
	}
	
}
