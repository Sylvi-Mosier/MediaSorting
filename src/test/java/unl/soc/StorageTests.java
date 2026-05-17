package unl.soc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.Comparator;


public class StorageTests {
	
	private Storage storage;
	private String storageName = "Vinyl Storage";
	private Double storageLength = 285.75;
	
	private MediaList<Vinyl> vinylCollection;
	private MediaList<CD> 		cdCollection;
	
	Comparator<Vinyl> vinylComp = MediaComparator.vinylByArtist;
	Comparator<CD> 		 cdComp = MediaComparator.cdByArtist;
	
	private Vinyl vinyl01;
	private Vinyl vinyl02;
	private Vinyl vinyl03;
	private Vinyl vinyl04;
	private Vinyl vinyl05;
	private Vinyl vinyl06;
	
	private CD cd01;
	private CD cd02;
	private CD cd03;
	
	@BeforeEach
	public void setUp() {
		storage = new Storage(storageName, storageLength);
		
		vinylCollection = new MediaList<Vinyl>(vinylComp);
		cdCollection = new MediaList<CD>(cdComp);
		
		vinyl01 = new Vinyl("frailty",            "Jane Remover", 			LocalDate.parse("2021-11-12"), 1, 57, 2);
		vinyl01.setSortTitle("Frailty");
		vinyl02 = new Vinyl("Census Designated",  "Jane Remover", 			LocalDate.parse("2023-10-20"), 2, 62, 2);
		vinyl03 = new Vinyl("Ants From Up There", "Black Country New Road", LocalDate.parse("2022-02-04"), 2, 59, 2);
		vinyl04 = new Vinyl("Forever Howlong",    "Black Country New Road", LocalDate.parse("2025-04-04"), 3, 52, 2);
		vinyl05 = new Vinyl("Revengeseekerz", 	  "Jane Remover", 			LocalDate.parse("2025-04-04"), 4, 49, 2);
		vinyl06 = new Vinyl("Ghostholding", 	  "Venturing", 				LocalDate.parse("2025-02-10"), 3, 51, 2);
		
		cd01 = new CD("CHASER", 				"Femtanyl",  LocalDate.parse("2023-08-27"), 1, 14, 1);
		cd02 = new CD("the jeriancore trilogy", "jerian", 	LocalDate.parse("2025-10-17"), 1, 81, 2);
		cd02.setSortArtist("Jerian");
		cd03 = new CD("Kid A", 				    "Radiohead", LocalDate.parse("2000-10-02"), 4, 50, 1);
		
		vinylCollection.add(vinyl01);
		vinylCollection.add(vinyl02);
		vinylCollection.add(vinyl03);
		vinylCollection.add(vinyl04);
		vinylCollection.add(vinyl05);
		vinylCollection.add(vinyl06);
		
		cdCollection.add(cd01);
		cdCollection.add(cd02);
		cdCollection.add(cd03);
		
	}
	
	
	
	@Test
	public void constructorTest() {
		Storage actual = new Storage("testName", 1.0);
		
		assertNotNull(actual);
		assertTrue(actual.isEmpty());
		assertEquals(actual.contentSize(), 0);
	}
	
	
	@Test
	public void addElement() {
		String expected = """
				+-------------------------------------------------------------------------+
				| Vinyl Storage                                                           |
				+----------------------------------Vinyl----------------------------------+
				| Black Country New Road - Ants From Up There [2022]                      |
				| Black Country New Road -    Forever Howlong [2025]                      |
				|           Jane Remover -            frailty [2021]                      |
				|           Jane Remover -  Census Designated [2023]                      |
				|           Jane Remover -     Revengeseekerz [2025]                      |
				|              Venturing -       Ghostholding [2025]                      |
				+-------------------------------------------------------------------------+
				""";
		
		storage.addMediaList(vinylCollection);
		
		//System.out.println(storage.toString());
		assertEquals(expected, storage.toString());
	}
	
	@Test
	public void addCollection() {
		String expected = """
				+-------------------------------------------------------------------------+
				| Vinyl Storage                                                           |
				+----------------------------------Vinyl----------------------------------+
				| Black Country New Road - Ants From Up There [2022]                      |
				| Black Country New Road -    Forever Howlong [2025]                      |
				|           Jane Remover -            frailty [2021]                      |
				|           Jane Remover -  Census Designated [2023]                      |
				|           Jane Remover -     Revengeseekerz [2025]                      |
				|              Venturing -       Ghostholding [2025]                      |
				+-----------------------------------CDs-----------------------------------+
				|  Femtanyl -                 CHASER [2023]                               |
				|    jerian - the jeriancore trilogy [2025]                               |
				| Radiohead -                  Kid A [2000]                               |
				+-------------------------------------------------------------------------+
				""";
		
		storage.addMediaList(vinylCollection);
		storage.addMediaList(cdCollection);
		
		System.out.println(storage.toString());
		assertEquals(expected, storage.toString());
	}
	
	
	
	
	
	
}
