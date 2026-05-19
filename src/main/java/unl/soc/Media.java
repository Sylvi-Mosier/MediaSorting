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
	
	public String toStringDimension() {
		if (this.dimension == null) {return null;}
		
		switch (this.dimension.getUnit()) {
		case MILLIMETERS:
			return String.format("%s: %.2fmm", this.title, this.dimension.getWidth());
		case CENTIMETERS:
			return String.format("%s: %.2fcm", this.title, this.dimension.getWidth());
		case INCHES:
			return String.format("%s: %.2f'", this.title, this.dimension.getWidth());
		case FEET:
			return String.format("%s: %.2f\"", this.title, this.dimension.getWidth());
		}
		
		return String.format("%s: %.2f", this.title, this.dimension.getWidth());
	}
	
	public String toStringDimension(int titleSpacing) {
		if (this.dimension == null) {return null;}
		
		int titleLength = getTitle().length();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i<titleSpacing - titleLength; i++) {
			sb.append(" ");
		}
		
		switch (this.dimension.getUnit()) {
		case MILLIMETERS:
			sb.append(String.format("%s: %.2fmm", this.title, this.dimension.getWidth()));
			break;
		case CENTIMETERS:
			sb.append(String.format("%s: %.2fcm", this.title, this.dimension.getWidth()));
			break;
		case INCHES:
			sb.append(String.format("%s: %.2f'", this.title, this.dimension.getWidth()));
			break;
		case FEET:
			sb.append(String.format("%s: %.2f\"", this.title, this.dimension.getWidth()));
			break;
		default:
			sb.append(String.format("%s: %.2f", this.title, this.dimension.getWidth()));
		}
		
		return sb.toString();
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
	
	protected String titlePrint() {
		return String.format("%s [%d]", getTitle(), getReleaseYear());
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
