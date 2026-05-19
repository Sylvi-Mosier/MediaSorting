package unl.soc;

import java.time.LocalDate;

public class CD extends Music {
	
	private Integer numCDs;
	
	public CD(String title, String artist, LocalDate releaseDate, Integer releaseNumber, Integer runtime, Integer numCDs) {
		super(title, artist, releaseDate, releaseNumber, runtime);
		this.numCDs = numCDs;
		this.setDimensions(findDimension(numCDs));
	}
	
	public CD(String title, String artist, LocalDate releaseDate, Integer releaseNumber, Integer runtime, Integer numCDs, Dimension size) {
		super(title, artist, releaseDate, releaseNumber, size, runtime);
		this.numCDs = numCDs;
	}
	
	public CD(String title, String artist, LocalDate releaseDate, Integer releaseNumber, 
			 Double length, Double width, Double height, Integer runtime, Integer numCDs) {
		super(title, artist, releaseDate, releaseNumber, length, width, height, runtime);
		this.numCDs = numCDs;
	}
	
	private static Dimension findDimension(int numCDs) {
		if 		(numCDs == 1) {return new Dimension(142.0, 10.0, 125.0);}
		else if (numCDs == 2) {return new Dimension(142.0, 10.0, 125.0);}
		else 				  {return null;}
	}
	
	public Integer getNumCDs() {
		return numCDs;
	}
	
	@Override
	protected String lineHeader() {
		return String.format("+-----------------------------------CDs-----------------------------------+\n");
	}
	
}
