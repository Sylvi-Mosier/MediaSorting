package unl.soc;

import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Storage {
	
	private String name;
	private Dimension dimension;
	private List<MediaList<? extends Media>> contents;
	
	public Storage(String name, Dimension dimension) {
		this.name = name;
		this.dimension = dimension;
		this.contents = new ArrayList<>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public Dimension getDimension() {
		return this.dimension;
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
	}
	
	public void writeToOutput() {
		this.writeToFile("data/output.txt");
	}
	
	public void writeToFile(String fileName) {
		File f = new File(fileName);
		try {
			PrintWriter pw = new PrintWriter(f);
			pw.println(this.toString());
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
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
