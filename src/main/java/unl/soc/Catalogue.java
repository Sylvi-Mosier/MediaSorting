package unl.soc;

import java.time.LocalDate;

public interface Catalogue {
	
	public String getTitle();
	public String getArtist();
	public String getSortTitle();
	public LocalDate getReleaseDate();
	public Integer getReleaseYear();
	public Integer getReleaseNumber();
	
}
