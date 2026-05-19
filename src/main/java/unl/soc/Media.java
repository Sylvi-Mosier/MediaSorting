package unl.soc;

import java.time.LocalDate;

public abstract class Media implements Catalogue {
	
	private String title;
	private String artist;
	private String sortTitle;
	private String sortArtist;
	private LocalDate releaseDate;
	private Integer releaseNumber;
	private Dimension dimension;
	//TODO: implement genre
	// private List<? extends Genre> genres;
	
	public Media(String title, String artist, LocalDate releaseDate, Integer releaseNumber) {
		super();
		this.title = title;
		this.artist = artist;
		this.releaseDate = releaseDate;
		this.releaseNumber = releaseNumber;
		this.dimension = null;
	}
	
	public Media(String title, String artist, LocalDate releaseDate, Integer releaseNumber, Dimension size) {
		super();
		this.title = title;
		this.artist = artist;
		this.releaseDate = releaseDate;
		this.releaseNumber = releaseNumber;
		this.dimension = size;
	}
	
	public Media(String title, String artist, LocalDate releaseDate, Integer releaseNumber, Double length, Double width, Double height) {
		super();
		this.title = title;
		this.artist = artist;
		this.releaseDate = releaseDate;
		this.releaseNumber = releaseNumber;
		this.dimension = new Dimension(length, width, height);
	}

	public String getSortTitle() {
		if (sortTitle == null) { return title;}
		else 				   { return sortTitle;}
	}

	public void setSortTitle(String sortTitle) {
		this.sortTitle = sortTitle;
	}

	public String getSortArtist() {
		if (sortArtist == null) { return artist;}
		else					{ return sortArtist;}
	}

	public void setSortArtist(String sortArtist) {
		this.sortArtist = sortArtist;
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public Integer getReleaseNumber() {
		return releaseNumber;
	}
	
	public Integer getReleaseYear() {
		return releaseDate.getYear();
	}
	
	public Dimension getDimensions() {
		return this.dimension;
	}
	
	protected void setDimensions(Dimension dimension) {
		if (dimension != null) {
			this.dimension = dimension;
		}
	}
	
	protected String lineHeader() {
		return String.format("+----------------------------------Media----------------------------------+\n");
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s [%d]", this.getArtist(), this.getTitle(), this.getReleaseYear());
	}
	
	public String toString(int spacing) {
		String indentation = "";
		int artistLength = getArtist().length();
		
		for (int i=0; i<spacing - artistLength; i++) {
			indentation = indentation + " ";
		}
		
		//return indentation + toString();
		return artistPrint(spacing);
		
	}
	
	public String toString(int artistSpacing, int titleSpacing) {
		return artistPrint(artistSpacing) + titlePrint(titleSpacing);
	}
	
	protected String artistPrint(int spacing) {
		String indentation = "";
		int length = getArtist().length();
		
		for (int i=0; i<spacing - length; i++) {
			indentation = indentation + " ";
		}
		
		return indentation + String.format("%s - ", getArtist());
	}
	
	protected String titlePrint(int spacing) {
		String indentation = "";
		int length = getTitle().length();
		
		for (int i=0; i<spacing - length; i++) {
			indentation = indentation + " ";
		}
		
		return indentation + String.format("%s [%d]", getTitle(), getReleaseYear());
	}
	
}
