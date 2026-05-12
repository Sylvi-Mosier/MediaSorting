package unl.soc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MediaListTests {
	private MediaList<Vinyl> vinylCollection;
	
	Comparator<Vinyl> comp = new Comparator<Vinyl>() {
		public int compare(Vinyl a, Vinyl b) {
			
			int cmp = a.getSortArtist().compareTo(b.getSortArtist());
			if (cmp != 0) {return cmp;}
			
			cmp = a.getReleaseNumber().compareTo(b.getReleaseNumber());
			return cmp;
		}
	};
	
	private Vinyl vinyl01;
	private Vinyl vinyl02;
	private Vinyl vinyl03;
	private Vinyl vinyl04;
	private Vinyl vinyl05;
	private Vinyl vinyl06;
	
	@BeforeEach
	public void setUp() {
		vinylCollection = new MediaList<Vinyl>(comp);
		
		vinyl01 = new Vinyl("frailty",            "Jane Remover", 			LocalDate.parse("2021-11-12"), 1, 57, 2);
		vinyl02 = new Vinyl("Census Designated",  "Jane Remover", 			LocalDate.parse("2023-10-20"), 2, 62, 2);
		vinyl03 = new Vinyl("Ants From Up There", "Black Country New Road", LocalDate.parse("2022-02-04"), 2, 59, 2);
		vinyl04 = new Vinyl("Forever Howlong",    "Black Country New Road", LocalDate.parse("2025-04-04"), 3, 52, 2);
		vinyl05 = new Vinyl("Revengeseekerz", 	  "Jane Remover", 			LocalDate.parse("2025-04-04"), 4, 49, 2);
		vinyl06 = new Vinyl("Ghostholding", 	  "Venturing", 				LocalDate.parse("2025-02-10"), 3, 51, 2);
		vinyl06.setSortArtist("Jane Remover");
		
	}
	
	@Test
	public void constructorTest() {
		assertNotNull(vinylCollection);
		assertTrue(vinylCollection.isEmpty());
		assertEquals(vinylCollection.size(), 0);
	}
	
	@Test
	public void addElement() {
		List<Vinyl> expected = new ArrayList<>();
		
		expected.add(vinyl01);
		vinylCollection.add(vinyl01);
		
		assertEquals(expected.get(0), vinylCollection.get(0));
		assertEquals(expected.get(0).toString(), vinylCollection.get(0).toString());
	}
	
	@Test
	public void addElements() {
		vinylCollection.add(vinyl01);
		vinylCollection.add(vinyl02);
		vinylCollection.add(vinyl03);
		vinylCollection.add(vinyl04);
		vinylCollection.add(vinyl05);
		vinylCollection.add(vinyl06);
		
		List<Vinyl> expected = new ArrayList<>();
		
		expected.add(vinyl01);
		expected.add(vinyl02);
		expected.add(vinyl03);
		expected.add(vinyl04);
		expected.add(vinyl05);
		expected.add(vinyl06);
		
		Collections.sort(expected, comp);
		
		
		for (int i=0; i<expected.size(); i++) {
			assertEquals(expected.get(i), vinylCollection.get(i), "values don't match up on index " + i);
			
			assertEquals(		expected.get(i).toString(),
						 vinylCollection.get(i).toString());
		}
		
	}
	
	@Test
	public void iteratorTest() {
		vinylCollection.add(vinyl01);
		vinylCollection.add(vinyl02);
		vinylCollection.add(vinyl03);
		vinylCollection.add(vinyl04);
		vinylCollection.add(vinyl05);
		vinylCollection.add(vinyl06);
		
		List<Vinyl> expected = new ArrayList<>();
		
		expected.add(vinyl01);
		expected.add(vinyl02);
		expected.add(vinyl03);
		expected.add(vinyl04);
		expected.add(vinyl05);
		expected.add(vinyl06);
		
		Collections.sort(expected, comp);
		
		System.out.println("vinylCollection class: " + vinylCollection.getClassType());
		System.out.println("          vinyl class: " + vinyl03.getClass());
		
		
		int i=0;
		for (Vinyl vinyl : vinylCollection) {
			assertEquals(expected.get(i), vinyl, "values don't match up on index " + i);
			assertEquals(expected.get(i).toString(), vinyl.toString());
			i++;
		}
	}
	
	@Test
	public void printTest() {
		String expected = """
				+-------------------------------------------------------------------------+
				| Black Country New Road - Ants From Up There [2022]                      |
				| Black Country New Road -    Forever Howlong [2025]                      |
				|           Jane Remover -            frailty [2021]                      |
				|           Jane Remover -  Census Designated [2023]                      |
				|              Venturing -       Ghostholding [2025]                      |
				|           Jane Remover -     Revengeseekerz [2025]                      |
				+-------------------------------------------------------------------------+
				""";
		
		vinylCollection.add(vinyl01);
		vinylCollection.add(vinyl02);
		vinylCollection.add(vinyl03);
		vinylCollection.add(vinyl04);
		vinylCollection.add(vinyl05);
		vinylCollection.add(vinyl06);
		
		assertEquals(expected, vinylCollection.toString());
		
	}
	
}
