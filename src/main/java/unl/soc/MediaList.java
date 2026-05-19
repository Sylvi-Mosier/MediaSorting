package unl.soc;

import java.util.Comparator;
import java.util.Iterator;

public class MediaList<T extends Media> implements Iterable<T> {
	private int size;
	private Media[] contents;
	private Dimension dimensions;
	private Comparator<T> comp;
	private Integer titleSpacing;
	private Integer artistSpacing;
	
	
	public MediaList(Comparator<T> comp) {
		this.comp = comp;
		this.contents = new Media[10];
		this.size = 0;
		this.titleSpacing = 0;
		this.artistSpacing = 0;
		this.dimensions = new Dimension(0.0, 0.0, 0.0);
	}
	
	public int size() {
		return this.size;
	}
	
	public Dimension getDimensions() {
		return this.dimensions;
	}
	
	
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	@SuppressWarnings("unchecked")
	public T get(int index) {
		return (T) this.contents[index];
	}
	
	public void add(T element) {
		if (this.size == this.contents.length) {
			resize();
		}
		
		// spacing for artist, related to .toString()
		if (element.getArtist().length() > this.artistSpacing) {
			this.artistSpacing = element.getArtist().length();
		}
		
		// spacing for title, related to .toString()
		if (element.getTitle().length() > this.titleSpacing) {
			this.titleSpacing = element.getTitle().length();
		}
		
		int insertIndex = findInsertIndex(element);
		
		for (int i=this.size; i > insertIndex; i--) {
			this.contents[i] = this.contents[i-1];
		}
		
		this.dimensions.increaseLength(element.getDimensions().getLength());
		this.dimensions.increaseWidth (element.getDimensions(). getWidth());
		this.dimensions.increaseHeight(element.getDimensions().getHeight());
		
		
		this.contents[insertIndex] = element;
		this.size++;
		
	}
	
	@SuppressWarnings("unchecked")
	private int findInsertIndex(T element) {
		for (int i=0; i<this.size; i++) {
			
			if (comp.compare(element, (T) this.contents[i]) <= 0) {
				return i;
			}
		}
		
		return this.size;
	}
	
	private void resize() {
		Media[] newContents = new Media[this.contents.length * 2];
		for (int i=0; i<this.size; i++) {
			newContents[i] = this.contents[i];
		}
		this.contents = newContents;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private int position = 0;
			
			public boolean hasNext() {
				return position < size;
			}
			
			@SuppressWarnings("unchecked")
			public T next() {
				return (T) contents[position++];
			}
		};
	}
	
	@Override
	public String toString() {
		int maxArtist = this.artistSpacing;
		int maxTitle = this.titleSpacing;
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(lineBreak());
		for (int i=0; i<this.size; i++) {
			sb.append(String.format("| %-71s |\n", this.contents[i].toString(maxArtist, maxTitle)));
		}
		sb.append(lineBreak());
		
		return sb.toString();
	}
	
	public String storageString() {
		StringBuilder sb = new StringBuilder();
		int maxArtist = this.artistSpacing;
		int maxTitle = this.titleSpacing;
		
		sb.append(lineHeader());
		for (int i=0; i<this.size; i++) {
			sb.append(String.format("| %-71s |\n", this.contents[i].toString(maxArtist, maxTitle)));
		}
		
		return sb.toString();
	}
	
	public Object getClassType() {
		if (this.size != 0) {return contents[0].getClass();}
		return null;
	}
	
	private String lineHeader() {
		return contents[0].lineHeader();
	}
	
	private String lineBreak() {
		return String.format("+-------------------------------------------------------------------------+\n");
	}
	
	
	
}
