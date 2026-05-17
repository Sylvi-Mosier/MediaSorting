package unl.soc;

/**
 * Object that contains the length, width,
 * and height of an item in {@code Millimeters}
 */
public class Dimension {
	
	private Double length;
	private Double height;
	private Double width;
	
	public Dimension(Double length, Double width, Double height) {
		this.length = length;
		this.width = width;
		this.height = height;
	}
	
	public Double length() {
		return this.length;
	}
	
	public Double width() {
		return this.width;
	}
	
	public Double height() {
		return this.height;
	}
	
	public Double volume() {
		return this.length * this.width * this.height;
	}
	
	@Override
	public String toString() {
		return String.format("[%.2f x %.2f x %.2f]\n", this.length, this.width, this.height);
	}
	
}
