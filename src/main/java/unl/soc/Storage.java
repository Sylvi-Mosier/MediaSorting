package unl.soc;

import java.util.Iterator;
import java.util.List;
import java.util.Comparator;


public class Storage {
	
	private String name;
	private Double length;
	private List<MediaList<? extends Media>> contents;
	
	public Storage() {
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public Double getLength() {
		return this.length;
	}
	
	public void addMediaList(MediaList<? extends Media> mediaList) {
		contents.add(mediaList);
	}
	
	public MediaList<? extends Media> getContents() {
		return (MediaList<? extends Media>) this.contents;
	}
	
	public MediaList<? extends Media> getMediaList() {
		
	}
	
	
	
	private String lineBreak() {
		return String.format("+-------------------------------------------------------------------------+\n");
	}

}
