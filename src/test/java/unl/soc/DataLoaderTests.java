package unl.soc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class DataLoaderTests {
		
	
	@Test
	public void VinylCSVTest() {
		List<String> expected = new ArrayList<String>();
		List<String> actual = new ArrayList<String>();
		
		String fileName = "data/vinyl.csv";
		
		expected.add("frailty,Jane Remover,2021-11-12,1,57,2");
		expected.add("Census Designated,Jane Remover,2023-10-20,2,62,2");
		expected.add("Ants From Up There,Black Country New Road,2022-02-04,2,59,2");
		expected.add("Forever Howlong,Black Country New Road,2025-04-04,3,52,2");
		expected.add("In The Aeroplane Over The Sea,Neutral Milk Hotel,1998-02-10,2,40,1");
		
		
		actual = DataLoader.dataLoader(fileName);
		
		for (int i=0; i<expected.size(); i++) {
			assertEquals(expected.get(i), actual.get(i));
		}
		
	}
	
	@Test
	public void CdCSVTest() {
		List<String> expected = new ArrayList<String>();
		List<String> actual = new ArrayList<String>();
		
		String fileName = "data/cd.csv";
		
		expected.add("CHASER,Femtanyl,2023-08-27,1,14,1");
		expected.add("the jeriancore trilogy,jerian,2025-10-17,1,81,2");
		expected.add("Kid A,Radiohead,2000-10-02,4,50,1");
		
		
		actual = DataLoader.dataLoader(fileName);
		
		for (int i=0; i<expected.size(); i++) {
			assertEquals(expected.get(i), actual.get(i));
		}
	}
	
	@Test
	public void movieCSVTest() {
		List<String> expected = new ArrayList<String>();
		List<String> actual = new ArrayList<String>();
		
		String fileName = "data/movies.csv";
		
		expected.add("Videodrome,David Cronenberg,1983-02-04,8,Live Action,Blu-Ray,93,3");
		
		
		actual = DataLoader.dataLoader(fileName);
		
		for (int i=0; i<expected.size(); i++) {
			assertEquals(expected.get(i), actual.get(i));
		}
	}
	
	@Test
	public void showCSVTest() {
		List<String> expected = new ArrayList<String>();
		List<String> actual = new ArrayList<String>();
		
		String fileName = "data/show.csv";
		
		expected.add("House Season 1,Hugh Laurie,2004-11-16,1,Live Action,DVD,972,6");
		
		
		actual = DataLoader.dataLoader(fileName);
		
		for (int i=0; i<expected.size(); i++) {
			assertEquals(expected.get(i), actual.get(i));
		}
	}
	
	@Test
	public void bookCSVTest() {
		List<String> expected = new ArrayList<String>();
		List<String> actual = new ArrayList<String>();
		
		String fileName = "data/book.csv";
		
		expected.add("Smell,Nagabe,2025-10-21,1,Manga,186");
		
		actual = DataLoader.dataLoader(fileName);
		
		for (int i=0; i<expected.size(); i++) {
			assertEquals(expected.get(i), actual.get(i));
		}
	}
}
