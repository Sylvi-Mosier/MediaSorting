package unl.soc;

import java.util.HashMap;

public enum BookType {
	MANGA,
	GRAPHIC_NOVEL,
	PAPERBACK,
	HARD_COVER;
	
	private static HashMap<String, BookType> hashMap = new HashMap<>();
	
	public static BookType stringToBookType(String rawType) {
		hashMap.put(        "Manga", MANGA);
		hashMap.put("Graphic Novel", GRAPHIC_NOVEL);
		hashMap.put(    "Paperback", PAPERBACK);
		hashMap.put(   "Hard Cover", HARD_COVER);
		
		return hashMap.get(rawType);
	}
	
}
