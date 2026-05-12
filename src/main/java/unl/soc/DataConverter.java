package unl.soc;

import java.time.LocalDate;
import java.util.ArrayList;
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
	
	
	public static void main(String[] args) {
		
		List<String> rawVinyls = new ArrayList<>();
		List<String> rawCDs = new ArrayList<>();
		List<String> rawMovies = new ArrayList<>();
		List<String> rawShows = new ArrayList<>();
		List<String> rawBooks = new ArrayList<>();
		
		rawVinyls = DataLoader.dataLoader("data/vinyl.csv");
		rawCDs = DataLoader.dataLoader("data/cd.csv");
		rawMovies = DataLoader.dataLoader("data/movies.csv");
		rawShows = DataLoader.dataLoader("data/show.csv");
		rawBooks = DataLoader.dataLoader("data/book.csv");
		
		List<Vinyl> vinyl = DataConverter.vinylConverter(rawVinyls);
		List<CD> cds = DataConverter.cdConverter(rawCDs);
		List<Movie> movies = DataConverter.movieConverter(rawMovies);
		List<Show> shows = DataConverter.showConverter(rawShows);
		List<Book> books = DataConverter.bookConverter(rawBooks);
		
		
		JsonParser.movieJson(movies, "data/movie.json");
		JsonParser.showJson(shows, "data/shows.json");
		JsonParser.vinylJson(vinyl, "data/vinyl.json");
		JsonParser.cdJson(cds, "data/cd.json");
		JsonParser.bookToJson(books, "data/book.json");
		
	}

}
