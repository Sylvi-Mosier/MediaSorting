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
	
	public boolean hasEnoughSpace() {
		Double width = 0.0;
		for (int i=0; i<contents.size(); i++) {
			width = width + contents.get(i).getDimensions().getWidth();
		}
		
		return this.dimension.getLength() > width;
	}
	
	public boolean hasEnoughSpace(double width) {
		return this.dimension.getLength() > width;
	}
	
	public boolean hasEnoughSpace(Dimension dimension) {
		return this.dimension.getLength() > dimension.getWidth();
	}
	
	public String storageReport() {
		return storageHeader() + storageBody() + storageSummary() + storageConclusion();
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
	
	private String getStorageName() {
		String storageName = null;
		switch (this.dimension.getUnit()) {
		case MILLIMETERS:
			storageName = String.format("%s [%3.2fmm]", this.name, this.dimension.getLength());
			break;
		case CENTIMETERS:
			storageName = String.format("%s [%3.2fcm]", this.name, this.dimension.getLength());
			break;
		case INCHES:
			storageName = String.format("%s [%3.2f']", this.name, this.dimension.getLength());
			break;
		case FEET:
			storageName = String.format("%s [%3.2f\"]", this.name, this.dimension.getLength());
			break;
		default:
			storageName = String.format("%s [%3.2f]", this.name, this.dimension.getLength());
			break;
		}
		
		return storageName;
	}
	
	private String storageHeader() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(lineBreak());
		sb.append(String.format("| %-71s |\n", getStorageName()));
		
		return sb.toString();
	}
	
	private String storageBody() {
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i<contents.size(); i++) {
			sb.append(contents.get(i).storageReport());
		}
		
		return sb.toString();
	}
	
	private String storageSummary() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(lineBreak());
		sb.append(String.format("| Media Summary:                                                          |\n"));
		
		
		sb.append(lineBreak());
		return sb.toString();
	}
	
	private String storageConclusion() {
		StringBuilder sb = new StringBuilder();
		
		if (hasEnoughSpace()) {
			sb.append(String.format("|                   there is enough space for the media                   |\n"));
		} else {
			sb.append(String.format("|              there's too much stuff for this storage unit               |\n"));
		}
		
		sb.append(lineBreak());
		return sb.toString();
	}
	
	private String lineBreak() {
		return String.format("+-------------------------------------------------------------------------+\n");
	}

}
