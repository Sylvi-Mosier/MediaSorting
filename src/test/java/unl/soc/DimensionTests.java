package unl.soc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DimensionTests {
	private Dimension feet;
	private Dimension inches;
	private Dimension centimeters;
	private Dimension millimeters;
	
	private Double[] dimensionsFeet   = {  1.6 ,   1.2 ,   1.33, 		2.5536};
	private Double[] dimensionsInches = { 19.25,  14.48,  15.98, 	 4454.2652};
	private Double[] dimensionsCenti  = { 48.9 ,  36.8 ,  40.6 ,    73060.512 };
	private Double[] dimensionsMilli  = {489.0 , 368.0 , 406.0 , 73060512.0	  };
	
	private final int length = 0;
	private final int width  = 1;
	private final int height = 2;
	private final int volume = 3;
	
	private final Double TOLERANCE = 0.01;
	
	/*
	 * storage used for unit testing:
	 * https://www.turntablelab.com/collections/ttl-staples/products/line-phono-cube-plus-turntable-stand-record-storage
	 */
	
	@BeforeEach
	public void setUp() {
		millimeters = new Dimension(489.0 , 368.0 , 406.0, LengthUnit.MILLIMETERS);
		centimeters = new Dimension( 48.9 ,  36.8 ,  40.6 , LengthUnit.CENTIMETERS);
			 inches = new Dimension( 19.25,  14.48,  15.98, LengthUnit.INCHES);
			   feet = new Dimension(  1.6 ,   1.2 ,   1.33, LengthUnit.FEET);
	}
	
	@Test
	public void millimeters() {
		String expected = "[489.00mm x 368.00mm x 406.00mm]";
		
		assertEquals(dimensionsMilli[length], millimeters.getLength(), TOLERANCE, "length failure");
		assertEquals(dimensionsMilli [width], millimeters.getWidth() , TOLERANCE, "width failure");
		assertEquals(dimensionsMilli[height], millimeters.getHeight(), TOLERANCE, "height failure");
		assertEquals(dimensionsMilli[volume], millimeters.volume()	 , TOLERANCE, "volume failure");
		assertEquals(LengthUnit.MILLIMETERS , millimeters.getUnit());
		assertEquals(expected, millimeters.toString(), "toString() failure");
		
		millimeters.setLength(dimensionsMilli[length]);
		millimeters.setWidth(dimensionsMilli[width]);
		millimeters.setHeight(dimensionsMilli[height]);
		
		assertEquals(dimensionsMilli[length], millimeters.getLength(), TOLERANCE, "setLength failure");
		assertEquals(dimensionsMilli [width], millimeters.getWidth() , TOLERANCE, "setWidth failure");
		assertEquals(dimensionsMilli[height], millimeters.getHeight(), TOLERANCE, "setHeight failure");
		assertEquals(dimensionsMilli[volume], millimeters.volume()	 , TOLERANCE, "volume failure");
		assertEquals(LengthUnit.MILLIMETERS , millimeters.getUnit());
		assertEquals(expected, millimeters.toString(), "setDimension toString() failure");
	}
	
	@Test
	public void centimeters() {
		String expected = "[48.90cm x 36.80cm x 40.60cm]";
		
		
		assertEquals(dimensionsCenti[length], centimeters.getLength(), TOLERANCE, "length failure");
		assertEquals(dimensionsCenti [width], centimeters.getWidth() , TOLERANCE, "width failure");
		assertEquals(dimensionsCenti[height], centimeters.getHeight(), TOLERANCE, "height failure");
		assertEquals(dimensionsCenti[volume], centimeters.volume()	 , TOLERANCE, "volume failure");
		assertEquals(LengthUnit.CENTIMETERS , centimeters.getUnit());
		assertEquals(expected, centimeters.toString());
		
		centimeters.setLength(dimensionsCenti[length]);
		centimeters.setWidth(dimensionsCenti[width]);
		centimeters.setHeight(dimensionsCenti[height]);
		
		assertEquals(dimensionsCenti[length], centimeters.getLength(), TOLERANCE, "setLength failure");
		assertEquals(dimensionsCenti [width], centimeters.getWidth() , TOLERANCE, "setWidth failure");
		assertEquals(dimensionsCenti[height], centimeters.getHeight(), TOLERANCE, "setHeight failure");
		assertEquals(dimensionsCenti[volume], centimeters.volume()	 , TOLERANCE, "volume failure");
		assertEquals(LengthUnit.CENTIMETERS , centimeters.getUnit());
		assertEquals(expected, centimeters.toString(), "setDimension toString() failure");
	}
	
	@Test
	public void inches() {
		String expected = "[19.25' x 14.48' x 15.98']";
		
		assertEquals(dimensionsInches[length], inches.getLength(), TOLERANCE, "length failure");
		assertEquals(dimensionsInches [width], inches.getWidth() , TOLERANCE, "width failure");
		assertEquals(dimensionsInches[height], inches.getHeight(), TOLERANCE, "height failure");
		assertEquals(dimensionsInches[volume], inches.volume()	 , TOLERANCE, "volume failure");
		assertEquals(LengthUnit.INCHES		 , inches.getUnit());
		assertEquals(expected, inches.toString());
		
		inches.setLength(dimensionsInches[length]);
		inches.setWidth(dimensionsInches[width]);
		inches.setHeight(dimensionsInches[height]);
		
		assertEquals(dimensionsInches[length], inches.getLength(), TOLERANCE, "setLength failure");
		assertEquals(dimensionsInches [width], inches.getWidth() , TOLERANCE, "setWidth failure");
		assertEquals(dimensionsInches[height], inches.getHeight(), TOLERANCE, "setHeight failure");
		assertEquals(dimensionsInches[volume], inches.volume()	 , TOLERANCE, "volume failure");
		assertEquals(LengthUnit.INCHES		 , inches.getUnit());
		assertEquals(expected, inches.toString(), "setDimension toString() failure");
	}
	
	@Test
	public void feet() {
		String expected = "[1.60\" x 1.20\" x 1.33\"]";
		
		
		assertEquals(dimensionsFeet[length], feet.getLength(), TOLERANCE, "length failure");
		assertEquals(dimensionsFeet [width], feet.getWidth() , TOLERANCE, "width failure");
		assertEquals(dimensionsFeet[height], feet.getHeight(), TOLERANCE, "height failure");
		assertEquals(dimensionsFeet[volume], feet.volume()	 , TOLERANCE, "volume failure");
		assertEquals(LengthUnit.FEET	   , feet.getUnit());
		assertEquals(expected, feet.toString());
		
		inches.setLength(dimensionsFeet[length]);
		inches.setWidth(dimensionsFeet[width]);
		inches.setHeight(dimensionsFeet[height]);
		
		assertEquals(dimensionsFeet[length], feet.getLength(), TOLERANCE, "setLength failure");
		assertEquals(dimensionsFeet [width], feet.getWidth() , TOLERANCE, "setWidth failure");
		assertEquals(dimensionsFeet[height], feet.getHeight(), TOLERANCE, "setHeight failure");
		assertEquals(dimensionsFeet[volume], feet.volume()	 , TOLERANCE, "volume failure");
		assertEquals(LengthUnit.FEET	   , feet.getUnit());
		assertEquals(expected, feet.toString(), "setDimension toString() failure");
	}
	
	@Test
	public void allCasesToString() {
		System.out.println(millimeters.toString());
		System.out.println(centimeters.toString());
		System.out.println(inches.toString());
		System.out.println(feet.toString());
	}
	
}
