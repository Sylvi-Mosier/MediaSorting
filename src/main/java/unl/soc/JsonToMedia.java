package unl.soc;

import com.google.gson.Gson;

public class JsonToMedia {
	
	public static Vinyl vinylFromJson() {
		String json = """
				"numLPs": 2,
				"runtime": 57,
				"title": "frailty",
				"artist": "Jane Remover",
				"sortTitle": null,
				"sortArtist": null,
				"releaseDate": "2021-11-12",
				"releaseNumber": 1,
				"dimension": {
				    "length": 331.15,
				    "height": 331.15,
				    "width": 12.7
				}
				""";
		
		Gson gson = new Gson();
		// Vinyl vinyl = gson.getAdapter(null).fromJson(json, Vinyl.class);
		
		//return vinyl;
		return null;
	}
	
}
