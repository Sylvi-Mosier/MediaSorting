package unl.soc;

import java.time.LocalDate;

public class Book extends Media {
	
	Integer pageCount;
	BookType type;
	
	public Book(String title, String author, LocalDate releaseDate, Integer releaseNumber, BookType type, Integer pageCount) {
		super(title, author, releaseDate, releaseNumber);
		this.type = type;
		this.pageCount = pageCount;
	}
	
	public Book(String title, String author, LocalDate releaseDate, Integer releaseNumber, BookType type, Integer pageCount, Dimension dimension) {
		super(title, author, releaseDate, releaseNumber, dimension);
		this.type = type;
		this.pageCount = pageCount;
	}
	
	public String getAuthor() {
		return this.getArtist();
	}
	
	public Integer getPageCount() {
		return pageCount;
	}

	public BookType getType() {
		return type;
	}
	
	@Override
	protected String lineHeader() {
		return String.format("+----------------------------------Books----------------------------------+\n");
	}
	
}
