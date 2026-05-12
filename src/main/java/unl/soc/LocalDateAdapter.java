package unl.soc;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

//Source - https://stackoverflow.com/a/39193077
//Posted by Drux
//Retrieved 2026-05-12, License - CC BY-SA 3.0

public class LocalDateAdapter implements JsonSerializer<LocalDate> {

	public JsonElement serialize(LocalDate date, Type typeOfSrc, JsonSerializationContext context) {
		return new JsonPrimitive(date.format(DateTimeFormatter.ISO_LOCAL_DATE)); // "yyyy-mm-dd"
	}
}
