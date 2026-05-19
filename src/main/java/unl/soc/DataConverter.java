package unl.soc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DataConverter {
	
	public static List<Vinyl> vinylConverter(List<String> rawVinyls) {
		List<Vinyl> processedVinyl = new ArrayList<>();
		
		for (String rawVinyl : rawVinyls) {
			String tokens[] = rawVinyl.split(",");
			
			String title = tokens[0];
			String artist = tokens[1];
			LocalDate releaseDate = LocalDate.parse(tokens[2]);
			Integer releaseNumber = Integer.parseInt(tokens[3]);
			Integer runtime = Integer.parseInt(tokens[4]);
			Integer numLPs = Integer.parseInt(tokens[5]);
			
			Vinyl vinyl = new Vinyl(title, artist, releaseDate, releaseNumber, runtime, numLPs);
			processedVinyl.add(vinyl);
		}
		
		return processedVinyl;
	}
	
	public static MediaList<Vinyl> vinylConverter(List<String> rawVinyls, Comparator<Vinyl> comp) {
		MediaList<Vinyl> processedVinyl = new MediaList<Vinyl>(comp);
		
		for (String rawVinyl : rawVinyls) {
			Vinyl vinyl;
			
			String tokens[] = rawVinyl.split(",");
			
			String title = tokens[0];
			String artist = tokens[1];
			LocalDate releaseDate = LocalDate.parse(tokens[2]);
			Integer releaseNumber = Integer.parseInt(tokens[3]);
			Integer runtime = Integer.parseInt(tokens[4]);
			Integer numLPs = Integer.parseInt(tokens[5]);
			
			if (!isNull(tokens[8]) && 
				!isNull(tokens[9]) && 
				!isNull(tokens[10])) {
				Dimension dimension = new Dimension(Double.parseDouble(tokens[8]), 
													Double.parseDouble(tokens[9]), 
													Double.parseDouble(tokens[10]));
				
				vinyl = new Vinyl(title, artist, releaseDate, releaseNumber, dimension, runtime, numLPs);
			} else {
				vinyl = new Vinyl(title, artist, releaseDate, releaseNumber, runtime, numLPs);
			}
			
			
			if (!isNull(tokens[6])) { vinyl.setSortTitle(tokens[6]);}
			if (!isNull(tokens[7])) { vinyl.setSortArtist(tokens[7]);}
			
			
			
			
			processedVinyl.add(vinyl);
		}
		
		return processedVinyl;
	}
	
	public static List<CD> cdConverter(List<String> rawCDs) {
		List<CD> cds = new ArrayList<>();
		
		for (String rawCD : rawCDs) {
			String tokens[] = rawCD.split(",");
			
			String title = tokens[0];
			String artist = tokens[1];
			LocalDate releaseDate = LocalDate.parse(tokens[2]);
			Integer releaseNumber = Integer.parseInt(tokens[3]);
			Integer runtime = Integer.parseInt(tokens[4]);
			Integer numCDs = Integer.parseInt(tokens[5]);
			
			CD cd = new CD(title, artist, releaseDate, releaseNumber, runtime, numCDs);
			cds.add(cd);
		}
		
		return cds;
	}
	
	public static MediaList<CD> cdConverter(List<String> rawCDs, Comparator<CD> comp) {
		MediaList<CD> cds = new MediaList<CD>(comp);
		
		for (String rawCD : rawCDs) {
			String tokens[] = rawCD.split(",");
			
			String title = tokens[0];
			String artist = tokens[1];
			LocalDate releaseDate = LocalDate.parse(tokens[2]);
			Integer releaseNumber = Integer.parseInt(tokens[3]);
			Integer runtime = Integer.parseInt(tokens[4]);
			Integer numCDs = Integer.parseInt(tokens[5]);
			Dimension dimension = stringToDimension(tokens[8], 
				    								tokens[9], 
				    								tokens[10], 
				    								tokens[11]);
			
			if (dimension == null) {
				CD cd = new CD(title, artist, releaseDate, releaseNumber, runtime, numCDs);
				cds.add(cd);
			} else {
				CD cd = new CD(title, artist, releaseDate, releaseNumber, runtime, numCDs, dimension);
				cds.add(cd);
			}
			
			
		}
		
		return cds;
	}
	
	public static List<Movie> movieConverter(List<String> rawMovies) {
		List<Movie> movies = new ArrayList<>();
		
		for (String rawMovie : rawMovies) {
			String tokens[] = rawMovie.split(",");
			
			String title = tokens[0];
			String director = tokens[1];
			LocalDate releaseDate = LocalDate.parse(tokens[2]);
			Integer releaseNumber = Integer.parseInt(tokens[3]);
			Medium medium = Medium.stringToMedium(tokens[4]);
			VideoFormat format = VideoFormat.stringToFormat(tokens[5]);
			
			Integer runtime = Integer.parseInt(tokens[6]);
			Integer numDiscs = Integer.parseInt(tokens[7]);
			
			Movie movie = new Movie(title, director, releaseDate, releaseNumber, medium, format, runtime, numDiscs);
			
			movies.add(movie);
		}
		
		return movies;
	}
	
	public static MediaList<Movie> movieConverter(List<String> rawMovies, Comparator<Movie> comp) {
		MediaList<Movie> movies = new MediaList<>(comp);
		
		for (String rawMovie : rawMovies) {
			String tokens[] = rawMovie.split(",");
			
			String title = tokens[0];
			String director = tokens[1];
			LocalDate releaseDate = LocalDate.parse(tokens[2]);
			Integer releaseNumber = Integer.parseInt(tokens[3]);
			Medium medium = Medium.stringToMedium(tokens[4]);
			VideoFormat format = VideoFormat.stringToFormat(tokens[5]);
			
			Integer runtime = Integer.parseInt(tokens[6]);
			Integer numDiscs = Integer.parseInt(tokens[7]);
			Dimension dimension = stringToDimension(tokens[8], 
												    tokens[9], 
												    tokens[10], 
												    tokens[11]);
			Movie movie;
			
			if (dimension == null) {
				movie = new Movie(title, director, releaseDate, releaseNumber, 
								  medium, format, runtime, numDiscs);
				movies.add(movie);
			} else {
				movie = new Movie(title, director, releaseDate, releaseNumber, 
								  medium, format, runtime, numDiscs, dimension);
				movies.add(movie);
			}
		}
		
		return movies;
	}
	
	public static List<Show> showConverter(List<String> rawShows) {
		List<Show> shows = new ArrayList<>();
		
		for (String rawShow : rawShows) {
			String tokens[] = rawShow.split(",");
			
			String title = tokens[0];
			String lead = tokens[1];
			LocalDate releaseDate = LocalDate.parse(tokens[2]);
			Integer releaseNumber = Integer.parseInt(tokens[3]);
			Medium medium = Medium.stringToMedium(tokens[4]);
			VideoFormat format = VideoFormat.stringToFormat(tokens[5]);
			Integer runtime = Integer.parseInt(tokens[6]);
			Integer numDiscs = Integer.parseInt(tokens[7]);
			
			Show show = new Show(title, lead, releaseDate, releaseNumber, medium, format, runtime, numDiscs);
			shows.add(show);
		}
		
		return shows;
	}
	
	public static MediaList<Show> showConverter(List<String> rawShows, Comparator<Show> comp) {
		MediaList<Show> shows = new MediaList<>(comp);
		
		for (String rawShow : rawShows) {
			String tokens[] = rawShow.split(",");
			
			String title = tokens[0];
			String lead = tokens[1];
			LocalDate releaseDate = LocalDate.parse(tokens[2]);
			Integer releaseNumber = Integer.parseInt(tokens[3]);
			Medium medium = Medium.stringToMedium(tokens[4]);
			VideoFormat format = VideoFormat.stringToFormat(tokens[5]);
			Integer runtime = Integer.parseInt(tokens[6]);
			Integer numDiscs = Integer.parseInt(tokens[7]);
			
			Show show = new Show(title, lead, releaseDate, releaseNumber, medium, format, runtime, numDiscs);
			shows.add(show);
		}
		
		return shows;
	}
	
	public static List<Book> bookConverter(List<String> rawBooks) {
		List<Book> books = new ArrayList<>();
		
		for (String rawBook : rawBooks) {
			String tokens[] = rawBook.split(",");
			
			String title = tokens[0];
			String author = tokens[1];
			LocalDate releaseDate = LocalDate.parse(tokens[2]);
			Integer releaseNumber = Integer.parseInt(tokens[3]);
			BookType type = BookType.stringToBookType(tokens[4]);
			Integer pageCount = Integer.parseInt(tokens[5]);
			
			Book book = new Book(title, author, releaseDate, releaseNumber, type, pageCount);
			books.add(book);
		}
		
		return books;
	}
	
	public static MediaList<Book> bookConverter(List<String> rawBooks, Comparator<Book> comp) {
		MediaList<Book> books = new MediaList<>(comp);
		
		for (String rawBook : rawBooks) {
			String tokens[] = rawBook.split(",");
			
			String title = tokens[0];
			String author = tokens[1];
			LocalDate releaseDate = LocalDate.parse(tokens[2]);
			Integer releaseNumber = Integer.parseInt(tokens[3]);
			BookType type = BookType.stringToBookType(tokens[4]);
			Integer pageCount = Integer.parseInt(tokens[5]);
			Dimension dimension = stringToDimension(tokens[8], 
												    tokens[9], 
												    tokens[10], 
												    tokens[11]);
			
			Book book = new Book(title, author, releaseDate, releaseNumber, type, pageCount, dimension);
			books.add(book);
		}
		
		return books;
	}
	
	private static Dimension stringToDimension(String length, String width, String height, String unit) {
		if (isNull(length) &&
			isNull(width)  &&
			isNull(height)) {
			return null;
		} else {
			if (isNull(unit)) {
				return new Dimension(Double.parseDouble(length),
						 			 Double.parseDouble(width), 
						 			 Double.parseDouble(height));
			} else {
				return new Dimension(Double.parseDouble(length),
									 Double.parseDouble(width),
									 Double.parseDouble(height),
									 LengthUnit.parseUnit(unit));
			}
		}
		
		
	}
	
	private static boolean isNull(String conditional) {
		if (conditional.compareTo("null") == 0) {return true;}
		return false;
	}
	
	public static void main(String[] args) {
		
		List<String> rawVinyls = new ArrayList<>();
		List<String> rawCDs = new ArrayList<>();
		List<String> rawMovies = new ArrayList<>();
		List<String> rawShows = new ArrayList<>();
		List<String> rawBooks = new ArrayList<>();
		List<String> rawVinylsFancy = new ArrayList<>();
		List<String> rawMoviesFancy = new ArrayList<>();
		List<String> rawBooksFancy = new ArrayList<>();
		List<String> rawCDsFancy = new ArrayList<>();
		
		rawVinyls = DataLoader.dataLoader("data/test/vinyl.csv");
		rawCDs = DataLoader.dataLoader("data/test/cd.csv");
		rawMovies = DataLoader.dataLoader("data/test/movies.csv");
		rawShows = DataLoader.dataLoader("data/test/show.csv");
		rawBooks = DataLoader.dataLoader("data/test/book.csv");
		rawVinylsFancy = DataLoader.dataLoader("data/vinyl.csv");
		rawMoviesFancy = DataLoader.dataLoader("data/movies.csv");
		rawBooksFancy = DataLoader.dataLoader("data/book.csv");
		rawCDsFancy = DataLoader.dataLoader("data/cd.csv");
		
		List<Vinyl> vinyl = DataConverter.vinylConverter(rawVinyls);
		List<CD> cds = DataConverter.cdConverter(rawCDs);
		List<Movie> movies = DataConverter.movieConverter(rawMovies);
		List<Show> shows = DataConverter.showConverter(rawShows);
		List<Book> books = DataConverter.bookConverter(rawBooks);
		
		MediaList<Vinyl> fancyVinyl = DataConverter.vinylConverter(rawVinylsFancy, MediaComparator.vinylByArtist);
		MediaList<CD> fancyCDs = DataConverter.cdConverter(rawCDsFancy, MediaComparator.cdByArtist);
		MediaList<Movie> fancyMovies = DataConverter.movieConverter(rawMoviesFancy, MediaComparator.movieByFormat);
		MediaList<Show> fancyShows = DataConverter.showConverter(rawShows, MediaComparator.showByTitle);
		MediaList<Book> fancyBooks = DataConverter.bookConverter(rawBooksFancy, MediaComparator.bookByTitle);
		
		
		
		Storage storage = new Storage("Media Storage", new Dimension(19.25, 14.48, 15.98, LengthUnit.INCHES));
		
		storage.addMediaList(fancyVinyl);
		storage.addMediaList(fancyCDs);
		storage.addMediaList(fancyMovies);
		storage.addMediaList(fancyShows);
		storage.addMediaList(fancyBooks);
		
		storage.writeToOutput();
		
		JsonParser.movieJson(fancyMovies, "data/movie.json");
		JsonParser.showJson(shows, "data/shows.json");
		JsonParser.vinylJson(vinyl, "data/vinyl.json");
		JsonParser.cdJson(fancyCDs, "data/cd.json");
		JsonParser.bookToJson(fancyBooks, "data/book.json");
		
		for (int i=0; i<fancyBooks.size(); i++) {
			System.out.printf("%s: %s\n", fancyBooks.get(i).getTitle(), fancyBooks.get(i).getDimensions().toString());
		}
		
	}

}
