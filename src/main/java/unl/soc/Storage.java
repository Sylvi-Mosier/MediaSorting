package unl.soc;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;


public class Storage {
	
	private String name;
	private Double length;
	private List<MediaList<? extends Media>> contents;
	
	public Storage(String name, Double length) {
		this.name = name;
		this.length = length;
		this.contents = new ArrayList<>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public Double getLength() {
		return this.length;
	}
	
	public boolean isEmpty() {
		if (this.contents.size() == 0) {return true;}
		return false;
	}
	
	public int contentSize() {
		return this.contents.size();
	}
	
	public void addMediaList(MediaList<? extends Media> mediaList) {
		this.contents.add(mediaList);
		//contents.add(mediaList);
	}
	
	public MediaList<? extends Media> getContents() {
		return (MediaList<? extends Media>) this.contents;
	}
	
	public MediaList<? extends Media> getMediaList() {
		
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(lineBreak());
		sb.append(String.format("| %-71s |\n", getName()));
		
		for (int i=0; i<contents.size(); i++) {
			sb.append(contents.get(i).storageString());
		}
		
		sb.append(lineBreak());
		return sb.toString();
	}
	
	private String lineBreak() {
		return String.format("+-------------------------------------------------------------------------+\n");
	}

}
