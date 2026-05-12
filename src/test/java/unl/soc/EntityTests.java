package unl.soc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

public class EntityTests {
	
	@Test
	public void VinylTest01() {
		String title = "frailty";
		String artist = "Jane Remover";
		LocalDate releaseDate = LocalDate.parse("2021-11-12");
		Integer releaseNumber = 1;
		Integer runtime = 57;
		Integer numLPs = 2;
		
		Integer releaseYear = 2021;
		
		Vinyl frailty = new Vinyl(title, artist, releaseDate, releaseNumber, runtime, numLPs);
		
		assertEquals(frailty.getTitle(), title, "title does not match up");
		assertEquals(frailty.getArtist(), artist, "artist does not match up");
		assertEquals(frailty.getReleaseDate(), releaseDate, "releaseDate does not match up");
		assertEquals(frailty.getReleaseNumber(), releaseNumber, "releaseNumber does not match up");
		assertEquals(frailty.getRuntime(), runtime, "runtime does not match up");
		assertEquals(frailty.getNumLPs(), numLPs, "numLPs does not match up");
		assertEquals(frailty.getReleaseYear(), releaseYear, "releaseYear does not match up");
	}
	
	@Test
	public void cdTest01() {
		String title = "CHASER";
		String artist = "Femtanyl";
		LocalDate releaseDate = LocalDate.parse("2023-08-27");
		Integer releaseNumber = 1;
		Integer runtime = 14;
		Integer numCDs = 1;
		
		Integer releaseYear = 2023;
		
		CD chaser = new CD(title, artist, releaseDate, releaseNumber, runtime, numCDs);
		
		assertEquals(chaser.getTitle(), title, "title does not match up");
		assertEquals(chaser.getArtist(), artist, "artist does not match up");
		assertEquals(chaser.getReleaseDate(), releaseDate, "releaseDate does not match up");
		assertEquals(chaser.getReleaseNumber(), releaseNumber, "releaseNumber does not match up");
		assertEquals(chaser.getRuntime(), runtime, "runtime does not match up");
		assertEquals(chaser.getNumCDs(), numCDs, "numCDs does not match up");
		assertEquals(chaser.getReleaseYear(), releaseYear, "releaseYear does not match up");
	}
	
	@Test
	public void movieTest01() {
		String title = "Videodrome";
		String director = "David Cronenberg";
		LocalDate releaseDate = LocalDate.parse("1983-02-04");
		Integer releaseNumber = 8;
		Medium medium = Medium.LIVE_ACTION;
		VideoFormat format = VideoFormat.BLURAY;
		Integer runtime = 93;
		Integer numDiscs = 3;
		
		Integer releaseYear = 1983;
		
		Movie videodrome = new Movie(title, director, releaseDate, releaseNumber, medium, format, runtime, numDiscs);
		
		assertEquals(videodrome.getTitle(), title, "title does not match up");
		assertEquals(videodrome.getDirector(), director, "director does not match up");
		assertEquals(videodrome.getReleaseDate(), releaseDate, "releaseDate does not match up");
		assertEquals(videodrome.getReleaseNumber(), releaseNumber, "releaseNumber does not match up");
		assertEquals(videodrome.getMedium(), medium, "medium does not match up");
		assertEquals(videodrome.getFormat(), format, "format does not match up");
		assertEquals(videodrome.getRuntime(), runtime, "runtime does not match up");
		assertEquals(videodrome.getNumDiscs(), numDiscs, "numDiscs does not match up");
		assertEquals(videodrome.getReleaseYear(), releaseYear, "releaseYear does not match up");
	}
	
	@Test
	public void showTest01() {
		String title = "House Season 1";
		String lead = "Hugh Laurie";
		LocalDate releaseDate = LocalDate.parse("2004-11-16");
		Integer releaseNumber = 1;
		Medium medium = Medium.LIVE_ACTION;
		VideoFormat format = VideoFormat.DVD;
		Integer runtime = 972;
		Integer numDiscs = 6;
		
		Integer releaseYear = 2004;
		
		Show House01 = new Show(title, lead, releaseDate, releaseNumber, medium, format, runtime, numDiscs);
		
		assertEquals(House01.getTitle(), title, "title does not match up");
		assertEquals(House01.getLead(), lead, "lead does not match up");
		assertEquals(House01.getReleaseDate(), releaseDate, "releaseDate does not match up");
		assertEquals(House01.getReleaseNumber(), releaseNumber, "releaseNumber does not match up");
		assertEquals(House01.getMedium(), medium, "medium does not match up");
		assertEquals(House01.getFormat(), format, "format does not match up");
		assertEquals(House01.getRuntime(), runtime, "runtime does not match up");
		assertEquals(House01.getNumDiscs(), numDiscs, "numDiscs does not match up");
		assertEquals(House01.getReleaseYear(), releaseYear, "releaseYear does not match up");
	}
	
	@Test
	public void bookTest01() {
		String title = "Smell";
		String author = "Nagabe";
		LocalDate releaseDate = LocalDate.parse("2025-10-21");
		Integer releaseNumber = 1;
		BookType type = BookType.MANGA;
		Integer pageCount = 186;
		
		Book smell = new Book(title, author, releaseDate, releaseNumber, type, pageCount);
		
		assertEquals(smell.getTitle(), title, "title does not match up");
		assertEquals(smell.getAuthor(), author, "author does not match up");
		assertEquals(smell.getReleaseDate(), releaseDate, "releaseDate does not match up");
		assertEquals(smell.getReleaseNumber(), releaseNumber, "releaseNumber does not match up");
		assertEquals(smell.getType(), type, "type does not match up");
		assertEquals(smell.getPageCount(), pageCount, "pageCount does not match up");
		
	}
	
}
