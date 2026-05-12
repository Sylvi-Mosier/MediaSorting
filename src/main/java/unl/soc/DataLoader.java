package unl.soc;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataLoader {
	
	public static List<String> dataLoader(String FileName) {
		List<String> result = new ArrayList<String>();
		
		String line = null;
		
		try (Scanner s = new Scanner(new File(FileName))) {
			line = s.nextLine();
			while (s.hasNext()) {
				line = s.nextLine();
				result.add(line);
			}		
			
			s.close();
			return result;
			
		} catch (Exception e) {
			throw new RuntimeException("Encountered Error on line " + line, e);
		}
		
	}
	
}
