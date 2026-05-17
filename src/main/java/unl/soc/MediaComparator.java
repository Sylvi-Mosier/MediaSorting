package unl.soc;

import java.util.Comparator;

/**
 * This class holds a bunch of Comparators for 
 * media objects. These comparators are necessary
 * for creating a MediaList
 * 
 */
public class MediaComparator {
	
	/**
	 * Comparator that's the standard for sorting vinyls.
	 * sorts vinyls by sortArtist, then releaseNumber
	 * 
	 */
	public static Comparator<Vinyl> vinylByArtist = new Comparator<>() {
		public int compare(Vinyl a, Vinyl b) {
			
			int cmp = a.getSortArtist().compareTo(b.getSortArtist());
			if (cmp != 0) {return cmp;}
			
			cmp = a.getReleaseNumber().compareTo(b.getReleaseNumber());
			return cmp;
		}
	};
	
	/**
	 * Comparator for sorting vinyls alphabetically by title.
	 * sorts vinyls by sortTitle, then sortArtist
	 * 
	 */
	public static Comparator<Vinyl> vinylByTitle = new Comparator<>() {
		public int compare(Vinyl a, Vinyl b) {
			
			int cmp = a.getSortTitle().compareTo(b.getSortTitle());
			if (cmp != 0) {return cmp;}
			
			cmp = a.getSortArtist().compareTo(b.getSortArtist());
			return cmp;
		}
	};
	
	/**
	 * Comparator that's the standard for sorting CDs.
	 * sorts CDs by sortArtist, then releaseNumber
	 * 
	 */
	public static Comparator<CD> cdByArtist = new Comparator<>() {
		public int compare(CD a, CD b) {
			
			int cmp = a.getSortArtist().compareTo(b.getSortArtist());
			if (cmp != 0) {return cmp;}
			
			cmp = a.getReleaseNumber().compareTo(b.getReleaseNumber());
			return cmp;
		}
	};
	
	public static Comparator<Show> showByTitle = new Comparator<>() {
		public int compare(Show a, Show b) {
			int cmp = a.getSortTitle().compareTo(b.getSortTitle());
			if (cmp != 0) {return cmp;}
			
			return a.getReleaseNumber().compareTo(b.getReleaseNumber());
		}
	};
	
	public static Comparator<Movie> movieByDirector = new Comparator<>() {
		public int compare(Movie a, Movie b) {
			int cmp = a.getSortArtist().compareTo(b.getSortArtist());
			if (cmp != 0) {return cmp;}
			
			return a.getReleaseNumber().compareTo(b.getReleaseNumber());
		}
	};
	
	public static Comparator<Movie> movieByTitle = new Comparator<>() {
		public int compare(Movie a, Movie b) {
			int cmp = a.getSortTitle().compareTo(b.getSortTitle());
			if (cmp != 0) {return cmp;}
			
			return a.getReleaseNumber().compareTo(b.getReleaseNumber());
		}
	};
	
	public static Comparator<Book> bookByTitle = new Comparator<>() {
		public int compare(Book a, Book b) {
			int cmp = a.getSortTitle().compareTo(b.getSortTitle());
			if (cmp != 0) {return cmp;}
			
			return a.getReleaseNumber().compareTo(b.getReleaseNumber());
		}
	};
	
}
