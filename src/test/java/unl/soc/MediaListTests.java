package unl.soc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MediaListTests {
	private MediaList<Vinyl> vinylCollection;
	
	Comparator<Vinyl> comp = MediaComparator.vinylByArtist;
	
	private Vinyl vinyl01;
	private Vinyl vinyl02;
	private Vinyl vinyl03;
	private Vinyl vinyl04;
	private Vinyl vinyl05;
	private Vinyl vinyl06;
	
	private final Double TOLERANCE = 0.01;
	
	@BeforeEach
	public void setUp() {
		vinylCollection = new MediaList<Vinyl>(comp);
		
		vinyl01 = new Vinyl("frailty",            "Jane Remover", 			LocalDate.parse("2021-11-12"), 1, 57, 2);
		vinyl02 = new Vinyl("Census Designated",  "Jane Remover", 			LocalDate.parse("2023-10-20"), 2, 62, 2);
		vinyl03 = new Vinyl("Ants From Up There", "Black Country New Road", LocalDate.parse("2022-02-04"), 2, 59, 2);
		vinyl04 = new Vinyl("Forever Howlong",    "Black Country New Road", LocalDate.parse("2025-04-04"), 3, 52, 2);
		vinyl05 = new Vinyl("Revengeseekerz", 	  "Jane Remover", 			LocalDate.parse("2025-04-04"), 4, 49, 2);
		vinyl06 = new Vinyl("Ghostholding", 	  "Venturing", 				LocalDate.parse("2025-02-10"), 3, 51, 2);
		
		vinyl01.setSortTitle("Frailty");
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
	public void stressTest() {
		vinylCollection.add(vinyl01);
		vinylCollection.add(vinyl02);
		vinylCollection.add(vinyl03);
		vinylCollection.add(vinyl04);
		vinylCollection.add(vinyl05);
		vinylCollection.add(vinyl06);
		
		vinylCollection.add(vinyl01);
		vinylCollection.add(vinyl02);
		vinylCollection.add(vinyl03);
		vinylCollection.add(vinyl04);
		vinylCollection.add(vinyl05);
		vinylCollection.add(vinyl06);
		
		vinylCollection.add(vinyl01);
		vinylCollection.add(vinyl02);
		vinylCollection.add(vinyl03);
		vinylCollection.add(vinyl04);
		vinylCollection.add(vinyl05);
		vinylCollection.add(vinyl06);
		
		vinylCollection.add(vinyl01);
		vinylCollection.add(vinyl02);
		vinylCollection.add(vinyl03);
		vinylCollection.add(vinyl04);
		vinylCollection.add(vinyl05);
		vinylCollection.add(vinyl06);
		
		vinylCollection.add(vinyl01);
		vinylCollection.add(vinyl02);
		vinylCollection.add(vinyl03);
		vinylCollection.add(vinyl04);
		vinylCollection.add(vinyl05);
		vinylCollection.add(vinyl06);
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
	
	@Test
	public void cdMediaListTest() {
		List<CD> expected = new ArrayList<>();
		MediaList<CD> actual = new MediaList<CD>(MediaComparator.cdByArtist);
		
		CD cd01 = new CD("CHASER", 				   "Femtanyl",  LocalDate.parse("2023-08-27"), 1, 14, 1);
		CD cd02 = new CD("the jeriancore trilogy", "jerian", 	LocalDate.parse("2025-10-17"), 1, 81, 2);
		CD cd03 = new CD("Kid A", 				   "Radiohead", LocalDate.parse("2000-10-02"), 4, 50, 1);
		
		cd02.setSortArtist("Jerian");
		
		expected.add(cd01);
		expected.add(cd02);
		expected.add(cd03);
		
		Collections.sort(expected, MediaComparator.cdByArtist);
		
		actual.add(cd01);
		actual.add(cd02);
		actual.add(cd03);
		
		for (int i=0; i<expected.size(); i++) {
			assertEquals(expected.get(i), actual.get(i));
		}
		
	}
	
	@Test
	public void dimensionTest() {
		List<String> expected = new ArrayList<>();
		expected.add("Ants From Up There [2022] : [331.15mm x 12.70mm x 331.15mm]");
		expected.add(	"Forever Howlong [2025] : [331.15mm x 12.70mm x 331.15mm]");
		expected.add(			"frailty [2021] : [331.15mm x 12.70mm x 331.15mm]");
		expected.add( "Census Designated [2023] : [331.15mm x 12.70mm x 331.15mm]");
		expected.add(	   "Ghostholding [2025] : [331.15mm x 12.70mm x 331.15mm]");
		expected.add(	 "Revengeseekerz [2025] : [331.15mm x 12.70mm x 331.15mm]");
		
		Double expectedLength = 331.15 * 6.0;
		Double expectedWidth  =  12.7  * 6.0;
		Double expectedHeight = 331.15 * 6.0;
		
		List<String> actual = new ArrayList<>();
		
		vinylCollection.add(vinyl01);
		vinylCollection.add(vinyl02);
		vinylCollection.add(vinyl03);
		vinylCollection.add(vinyl04);
		vinylCollection.add(vinyl05);
		vinylCollection.add(vinyl06);
		
		for (int i=0; i<vinylCollection.size(); i++) {
			actual.add(vinylCollection.get(i).toStringDimension());
			assertEquals(expected.get(i), actual.get(i));
		}
		
		assertEquals(expectedLength, vinylCollection.getDimensions().getLength(), TOLERANCE, "length error");
		assertEquals(expectedWidth , vinylCollection.getDimensions().getWidth() , TOLERANCE, "width error");
		assertEquals(expectedHeight, vinylCollection.getDimensions().getHeight(), TOLERANCE, "height error");
		
	}
	
	
	
	
	
}
