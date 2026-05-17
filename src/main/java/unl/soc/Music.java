package unl.soc;

import java.time.LocalDate;

public abstract class Music extends Media {

	private Integer runtime;
	
	public Music(String title, String artist, LocalDate releaseDate, Integer releaseNumber, 
				 Integer runtime) {
		
		super(title, artist, releaseDate, releaseNumber);
		this.runtime = runtime;
	}
	
	public Music(String title, String artist, LocalDate releaseDate, Integer releaseNumber, 
				 Dimension size, Integer runtime) {
		
		super(title, artist, releaseDate, releaseNumber, size);
		this.runtime = runtime;
		
	}
	
	public Music(String title, String artist, LocalDate releaseDate, Integer releaseNumber, 
				 Double length, Double width, Double height, Integer runtime) {
		
		super(title, artist, releaseDate, releaseNumber, length, width, height);
		this.runtime = runtime;
	}
	
	
	public Integer getRuntime() {
		return runtime;
	}
	
	@Override
	protected String lineHeader() {
		return String.format("+----------------------------------Music----------------------------------+\n");
	}
	
}
