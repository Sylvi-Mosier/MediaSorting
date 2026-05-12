package unl.soc;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;


public class JsonParser {
	
	public static void movieJson(List<Movie> movies, String fileName) {
		File f = new File(fileName);
		try {
			PrintWriter pw = new PrintWriter(f);
			
			Gson gson = new GsonBuilder()
							.setPrettyPrinting()
							.registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
							.create();
			
			pw.printf("{\n\"movies\": [\n");
			
			Integer iteration = 0;
			for (Movie movie : movies) {
				iteration++;
				if (iteration != movies.size()) {pw.println(gson.toJson(movie) + ",");} 
				else 							{pw.println(gson.toJson(movie));}
				
			}
			
			pw.printf("]}");
			
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void showJson(List<Show> shows, String fileName) {
		File f = new File(fileName);
		try {
			PrintWriter pw = new PrintWriter(f);
			
			Gson gson = new GsonBuilder()
							.setPrettyPrinting()
							.registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
							.create();
			
			pw.printf("{\n\"shows\": [\n");
			
			Integer iteration = 0;
			for (Show show : shows) {
				iteration++;
				if (iteration != shows.size()) {pw.println(gson.toJson(show) + ",");} 
				else 						   {pw.println(gson.toJson(show));}
				
			}
			
			pw.printf("]}");
			
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void vinylJson(List<Vinyl> vinyls, String fileName) {
		File f = new File(fileName);
		try {
			PrintWriter pw = new PrintWriter(f);
			
			Gson gson = new GsonBuilder()
							.setPrettyPrinting()
							.registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
							.create();
			
			pw.printf("{\n\"vinyls\": [\n");
			
			Integer iteration = 0;
			for (Vinyl vinyl : vinyls) {
				iteration++;
				if (iteration != vinyls.size()) {pw.println(gson.toJson(vinyl) + ",");} 
				else 							{pw.println(gson.toJson(vinyl));}
				
			}
			
			pw.printf("]}");
			
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void cdJson(List<CD> cds, String fileName) {
		File f = new File(fileName);
		try {
			PrintWriter pw = new PrintWriter(f);
			
			Gson gson = new GsonBuilder()
							.setPrettyPrinting()
							.registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
							.create();
			
			pw.printf("{\n\"cds\": [\n");
			
			Integer iteration = 0;
			for (CD cd : cds) {
				iteration++;
				if (iteration != cds.size()) {pw.println(gson.toJson(cd) + ",");} 
				else 						 {pw.println(gson.toJson(cd));}
				
			}
			
			pw.printf("]}");
			
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void bookToJson(List<Book> books, String fileName) {
		File f = new File(fileName);
		try {
			PrintWriter pw = new PrintWriter(f);
			
			Gson gson = new GsonBuilder()
							.setPrettyPrinting()
							.registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
							.create();
			
			for (Book book : books) {
				pw.println(gson.toJson(book));
			}
			
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}

