package unl.soc;

import java.util.Comparator;
import java.util.Iterator;

public class MediaList<T extends Media> implements Iterable<T> {
	private int size;
	private Media[] contents;
	private Comparator<T> comp;
	
	
	public MediaList(Comparator<T> comp) {
		this.comp = comp;
		this.contents = new Media[10];
		this.size = 0;
	}
	
	public int size() {
		return this.size;
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
		
		int insertIndex = findInsertIndex(element);
		
		for (int i=this.size; i > insertIndex; i--) {
			this.contents[i] = this.contents[i-1];
		}
		
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
		int maxArtist = 0;
		int maxTitle  = 0;
		
		for (int i=0; i<this.size; i++) {
			int artistLength = this.contents[i].getArtist().length();
			int titleLength = this.contents[i].getTitle().length();
			
			if (artistLength > maxArtist) {maxArtist = artistLength;}
			if (titleLength  > maxTitle)  {maxTitle = titleLength;}
		}
		
		String output = "";
		
		output = output + lineBreak();
		for (int i=0; i<this.size; i++) {
			output = output 
					+ String.format("| %-71s |\n", this.contents[i].toString(maxArtist, maxTitle));
		}
		output = output + lineBreak();
		
		return output;
	}
	
	
	public Object getClassType() {
		//return contents.getClass();
		if (this.size != 0) {return contents[0].getClass();}
		return null;
	}
	
	private String lineBreak() {
		return String.format("+-------------------------------------------------------------------------+\n");
	}
	
}
