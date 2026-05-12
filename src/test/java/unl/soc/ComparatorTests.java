package unl.soc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;
import java.util.HashMap;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorTests {
	
	private MediaList<Vinyl> vinylCollection;
	private MediaList<CD> 		cdCollection;
	private MediaList<Show>   showCollection;
	private MediaList<Movie> movieCollection;
	private MediaList<Book>	  bookCollection;
	
	private Comparator<MediaList<? extends Media>> mediaListComp = new Comparator<>() {
		private HashMap<Object, Integer> mediaHash = new HashMap<>();
		
		public int compare(MediaList<?> a, MediaList<?> b) {
			mediaHash.put( unl.soc.Vinyl.class, 0);
			mediaHash.put(  unl.soc.Book.class, 1);
			mediaHash.put(  unl.soc.Show.class, 2);
			mediaHash.put( unl.soc.Movie.class, 3);
			mediaHash.put(    unl.soc.CD.class, 4);
			
			System.out.println("[A]: " + mediaHash.get(a.getClassType()) + " (" + a.getClassType() + ")" +
							" | [B]: " + mediaHash.get(b.getClassType()) + " (" + b.getClassType() + ")");
			
			int cmp = mediaHash.get(a.getClassType()).compareTo
					 (mediaHash.get(b.getClassType()));
			
			return cmp;
		}
	};
	
	private Vinyl vinyl01;
	private Vinyl vinyl02;
	private Vinyl vinyl03;
	private Vinyl vinyl04;
	private Vinyl vinyl05;
	private Vinyl vinyl06;
	
	private CD cd01;
	private CD cd02;
	private CD cd03;
	
	private Movie movie01;
	private Show show01;
	private Book book01;
	
	@BeforeEach
	public void setUp() {
		vinylCollection = new MediaList<Vinyl> (MediaComparator.vinylByArtist);
		cdCollection    = new MediaList<CD>	   (MediaComparator.cdByArtist);
		showCollection  = new MediaList<Show>  (MediaComparator.showByTitle);
		movieCollection = new MediaList<Movie> (MediaComparator.movieByDirector);
		bookCollection  = new MediaList<Book>  (MediaComparator.bookByTitle);
		
		vinyl01 = new Vinyl("frailty",            "Jane Remover", 			LocalDate.parse("2021-11-12"), 1, 57, 2);
		vinyl02 = new Vinyl("Census Designated",  "Jane Remover", 			LocalDate.parse("2023-10-20"), 2, 62, 2);
		vinyl03 = new Vinyl("Ants From Up There", "Black Country New Road", LocalDate.parse("2022-02-04"), 2, 59, 2);
		vinyl04 = new Vinyl("Forever Howlong",    "Black Country New Road", LocalDate.parse("2025-04-04"), 3, 52, 2);
		vinyl05 = new Vinyl("Revengeseekerz", 	  "Jane Remover", 			LocalDate.parse("2025-04-04"), 4, 49, 2);
		vinyl06 = new Vinyl("Ghostholding", 	  "Venturing", 				LocalDate.parse("2025-02-10"), 3, 51, 2);
		vinyl01.setSortTitle("Frailty");
		vinyl06.setSortArtist("Jane Remover");
		
		cd01 = new CD("CHASER", 				"Femtanyl",  LocalDate.parse("2023-08-27"), 1, 14, 1);
		cd02 = new CD("the jeriancore trilogy", "jerian", 	LocalDate.parse("2025-10-17"), 1, 81, 2);
		cd02.setSortArtist("Jerian");
		cd03 = new CD("Kid A", 				    "Radiohead", LocalDate.parse("2000-10-02"), 4, 50, 1);
		
		movie01 = new Movie("Videodrome", "David Cronenberg", LocalDate.parse("1983-02-04"), 
							8, Medium.LIVE_ACTION, VideoFormat.BLURAY, 93, 3);
		
		show01 = new Show("House Season 1", "Hugh Laurie", LocalDate.parse("2004-11-16"), 
						  1, Medium.LIVE_ACTION, VideoFormat.DVD, 972, 6);
		
		book01 = new Book("Smell", "Nagabe", LocalDate.parse("2025-10-21"), 1, BookType.MANGA, 186);
		
		vinylCollection.add(vinyl01);
		vinylCollection.add(vinyl02);
		vinylCollection.add(vinyl03);
		vinylCollection.add(vinyl04);
		vinylCollection.add(vinyl05);
		vinylCollection.add(vinyl06);
		
		cdCollection.add(cd01);
		cdCollection.add(cd02);
		cdCollection.add(cd03);
		
		movieCollection.add(movie01);
		 showCollection.add(show01);
		 bookCollection.add(book01);
	}
	
	@Test
	public void vinylSort() {
		List<Vinyl> expected = new ArrayList<>();
		expected.add(vinyl03);
		expected.add(vinyl04);
		expected.add(vinyl01);
		expected.add(vinyl02);
		expected.add(vinyl06);
		expected.add(vinyl05);
		
		for (int i=0; i<expected.size(); i++) {
			assertEquals(expected.get(i), vinylCollection.get(i));
		}
		
	}
	
	@Test
	public void cdSort() {
		List<CD> expected = new ArrayList<>();
		expected.add(cd01);
		expected.add(cd02);
		expected.add(cd03);
		
		
		for (int i=0; i<expected.size(); i++) {
			assertEquals(expected.get(i), cdCollection.get(i));
		}
	}
	
	
	@Test
	public void mediaListSort() {
		List<MediaList<?>> expected = new ArrayList<>();
		List<MediaList<?>> actual = new ArrayList<>();
		
		expected.add(vinylCollection);
		expected.add(bookCollection);
		expected.add(showCollection);
		expected.add(movieCollection);
		expected.add(cdCollection);
		
		
		actual.add(vinylCollection);
		actual.add(cdCollection);
		actual.add(showCollection);
		actual.add(movieCollection);
		actual.add(bookCollection);
		
		Collections.sort(actual, mediaListComp);
		
		for (int i=0; i<expected.size(); i++) {
			System.out.println("index " + i + ": " + actual.get(i).getClassType());
			assertEquals(expected.get(i), actual.get(i));
		}
	}
	
	
}
