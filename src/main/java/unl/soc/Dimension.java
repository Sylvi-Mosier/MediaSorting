package unl.soc;

/**
 * Object that contains the length, width,
 * and height of an item. Unless the unit 
 * of length is specified, the constructor
 * will automatically assume you're using
 * millimeters
 */
public class Dimension {
	
	private LengthUnit unit;
	private Double length;
	private Double height;
	private Double width;
	
	public Dimension(Double length, Double width, Double height) {
		this.length = length;
		this.width = width;
		this.height = height;
		this.unit = LengthUnit.MILLIMETERS;
	}
	
	public Dimension(Double length, Double width, Double height, LengthUnit unit) {
		this.unit = unit;
		switch (this.unit) {
			case MILLIMETERS:
				this.length = length;
				 this.width = width;
				this.height = height;
				break;
			case CENTIMETERS:
				this.length = centiToMillimeters(length);
				 this.width = centiToMillimeters(width);
				this.height = centiToMillimeters(height);
				break;
			case INCHES:
				this.length = inchesToMillimeters(length);
				 this.width = inchesToMillimeters(width);
				this.height = inchesToMillimeters(height);
				break;
			case FEET:
				this.length = feetToMillimeters(length);
				 this.width = feetToMillimeters(width);
				this.height = feetToMillimeters(height);
				break;
			default:
				this.length = length;
				 this.width = width;
				this.height = height;
				break;
		}
		
	}
	
	public Double getLength() {
		return convertOutput(this.length);
	}
	
	public void setLength(double length) {
		this.length = convertInput(length);
	}
	
	public void increaseLength(double length) {
		this.length = this.length + convertInput(length);
	}
	
	public Double getWidth() {
		return convertOutput(this.width);
	}
	
	public void setWidth(double width) {
		this.width = convertInput(width);
	}
	
	public void increaseWidth(double width) {
		this.width = this.width + convertInput(width);
	}
	
	public Double getHeight() {
		return convertOutput(this.height);
	}
	
	public void setHeight(double height) {
		this.height = convertInput(height);
	}
	
	public void increaseHeight(double height) {
		this.height = this.height + convertInput(height);
	}
	
	public Double volume() {
		return getLength() * getWidth() * getHeight();
	}
	
	public LengthUnit getUnit() {
		return this.unit;
	}
	
	private Double convertInput(Double input) {
		switch (this.unit) {
			case MILLIMETERS:
				return input;
			case CENTIMETERS:
				return centiToMillimeters(input);
			case INCHES:
				return inchesToMillimeters(input);
			case FEET:
				return feetToMillimeters(input);
			default:
				return input;
		}
	}
	
	private Double convertOutput(Double output) {
		switch (this.unit) {
			case MILLIMETERS:
				return output;
			case CENTIMETERS:
				return millimetersToCentimeters(output);
			case INCHES:
				return millimetersToInches(output);
			case FEET:
				return millimetersToFeet(output);
			default:
				return output;
		}
	}
	
	private Double centiToMillimeters(Double centimeters) {
		return centimeters * 10.0;
	}
	
	private Double inchesToMillimeters(Double inches) {
		return inches * 25.4;
	}
	
	private Double feetToMillimeters(Double feet) {
		return feet * 304.8;
	}
	
	private Double millimetersToCentimeters(Double millimeters) {
		return millimeters / 10.0;
	}
	
	private Double millimetersToInches(Double millimeters) {
		return millimeters / 25.4;
	}
	
	private Double millimetersToFeet(Double millimeters) {
		return millimeters / 304.8;
	}
	
	@Override
	public String toString() {
		switch (this.unit) {
			case MILLIMETERS:
				return String.format("[%.2fmm x %.2fmm x %.2fmm]", this.length, this.width, this.height);
			case CENTIMETERS:
				return String.format("[%.2fcm x %.2fcm x %.2fcm]", millimetersToCentimeters(this.length), 
																   millimetersToCentimeters(this.width), 
																   millimetersToCentimeters(this.height));
			case INCHES:
				return String.format("[%.2f' x %.2f' x %.2f']", millimetersToInches(this.length), 
						   										millimetersToInches(this.width), 
						   										millimetersToInches(this.height));
			case FEET:
				return String.format("[%.2f\" x %.2f\" x %.2f\"]", millimetersToFeet(this.length), 
																   millimetersToFeet(this.width), 
																   millimetersToFeet(this.height));
			default:
				return String.format("[%.2f x %.2f x %.2f]", this.length, this.width, this.height);
		}
	}
	
}
