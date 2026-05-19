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
	private Dimension dimension = new Dimension(489.0, 368.0, 406.0, LengthUnit.MILLIMETERS);
	
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
		storage = new Storage(storageName, dimension);
		
		vinylCollection = new MediaList<Vinyl>(vinylComp);
		cdCollection = new MediaList<CD>(cdComp);
		
		vinyl01 = new Vinyl("frailty",            "Jane Remover", 			LocalDate.parse("2021-11-12"), 1, 57, 2);
		vinyl01.setSortTitle("Frailty");
		vinyl02 = new Vinyl("Census Designated",  "Jane Remover", 			LocalDate.parse("2023-10-20"), 2, 62, 2);
		vinyl03 = new Vinyl("Ants From Up There", "Black Country New Road", LocalDate.parse("2022-02-04"), 2, 59, 2);
		vinyl04 = new Vinyl("Forever Howlong",    "Black Country New Road", LocalDate.parse("2025-04-04"), 3, 52, 2);
		vinyl05 = new Vinyl("Revengeseekerz", 	  "Jane Remover", 			LocalDate.parse("2025-04-04"), 4, 49, 2);
		vinyl06 = new Vinyl("Ghostholding", 	  "Venturing", 				LocalDate.parse("2025-02-10"), 3, 51, 2);
		vinyl06.setSortArtist("Jane Remover");
		
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
		Storage actual = new Storage("testName", dimension);
		
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
				|              Venturing -       Ghostholding [2025]                      |
				|           Jane Remover -     Revengeseekerz [2025]                      |
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
				|              Venturing -       Ghostholding [2025]                      |
				|           Jane Remover -     Revengeseekerz [2025]                      |
				+-----------------------------------CDs-----------------------------------+
				|  Femtanyl -                 CHASER [2023]                               |
				|    jerian - the jeriancore trilogy [2025]                               |
				| Radiohead -                  Kid A [2000]                               |
				+-------------------------------------------------------------------------+
				""";
		
		storage.addMediaList(vinylCollection);
		storage.addMediaList(cdCollection);
		
		assertEquals(expected, storage.toString());
	}
	
	
	@Test
	public void storageReportTest() {
		String expected = """
				+-------------------------------------------------------------------------+
				| Vinyl Storage [489.00mm]                                                |
				+----------------------------------Vinyl----------------------------------+
				| Ants From Up There: 12.70mm                                             |
				|    Forever Howlong: 12.70mm                                             |
				|            frailty: 12.70mm                                             |
				|  Census Designated: 12.70mm                                             |
				|       Ghostholding: 12.70mm                                             |
				|     Revengeseekerz: 12.70mm                                             |
				+-----------------------------------CDs-----------------------------------+
				|                 CHASER: 10.00mm                                         |
				| the jeriancore trilogy: 10.00mm                                         |
				|                  Kid A: 10.00mm                                         |
				+-------------------------------------------------------------------------+
				| Media Summary:                                                          |
				|      Vinyl size -  76.20mm                                              |
				|         CD size -  24.00mm                                              |
				|           total - 100.20mm                                              |
				|                                                                         |
				| Storage:                                                                |
				|       Vinyl Storage: 489.00mm                                           |
				|   Remaining Storage: 388.80mm                                           |
				|                                                                         |
				|                                                                         |
				+-------------------------------------------------------------------------+
				|                   there is enough space for the media                   |
				+-------------------------------------------------------------------------+
				""";
		
		storage.addMediaList(vinylCollection);
		storage.addMediaList(cdCollection);
		System.out.println(storage.storageReport());
		
		assertEquals(expected, storage.storageReport());
		
	}
	
	@Test
	public void storageReportMultipleLengthUnits() {
		String expected = """
				+-------------------------------------------------------------------------+
				| Vinyl Storage [489.00mm]                                                |
				+----------------------------------Vinyl----------------------------------+
				|            frailty: 12.70mm                                             |
				|  Census Designated: 12.70mm                                             |
				|       Ghostholding: 12.70mm                                             |
				|     Revengeseekerz: 12.70mm                                             |
				+-------------------------------------------------------------------------+
				| Media Summary:                                                          |
				|      Vinyl size -  76.20mm                                              |
				|           total -  76.20mm                                              |
				|                                                                         |
				| Storage:                                                                |
				|       Vinyl Storage: 489.00mm                                           |
				|   Remaining Storage: 412.80mm                                           |
				|                                                                         |
				|                                                                         |
				+-------------------------------------------------------------------------+
				|                   there is enough space for the media                   |
				+-------------------------------------------------------------------------+
				""";
		
		Dimension frailtySize 		 = new Dimension(331.15, 12.7, 331.15, LengthUnit.MILLIMETERS);
		Dimension censusSize 		 = new Dimension(33.115, 1.27, 33.115, LengthUnit.CENTIMETERS);
		Dimension ghostHoldingSize   = new Dimension(13.037, 0.5, 13.037 , LengthUnit.INCHES);
		Dimension revengeSeekerzSize = new Dimension(1.086, 0.04, 1.086  , LengthUnit.FEET);
		
		Vinyl frailty = new Vinyl("frailty", "Jane Remover", LocalDate.parse("2021-11-12"), 1, 57, 2, frailtySize);
		Vinyl census = new Vinyl("Census Designated", "Jane Remover", LocalDate.parse("2023-10-20"), 2, 62, 2, censusSize);
		Vinyl ghostHolding = new Vinyl("Ghostholding", "Venturing", LocalDate.parse("2025-02-10"), 3, 51, 2, ghostHoldingSize);
		Vinyl revengeSeekerz = new Vinyl("Revengeseekerz", "Jane Remover", LocalDate.parse("2025-04-04"), 4, 49, 2, revengeSeekerzSize);
		ghostHolding.setSortArtist("Jane Remover");
		frailty.setSortTitle("Frailty");
		
		MediaList<Vinyl> janeVinyls = new MediaList<Vinyl>(vinylComp);
		janeVinyls.add(frailty);
		janeVinyls.add(census);
		janeVinyls.add(ghostHolding);
		janeVinyls.add(revengeSeekerz);
		
		Storage actual = new Storage(storageName, dimension);
		actual.addMediaList(janeVinyls);
		
		assertEquals(expected, actual.storageReport());
		
	}
	
	
}
