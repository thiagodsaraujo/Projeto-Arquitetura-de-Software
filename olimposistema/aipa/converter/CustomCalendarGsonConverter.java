package br.com.olimposistema.aipa.converter;

import br.com.olimposistema.aipa.service.ConvertDateService;
import com.google.gson.*;

import javax.enterprise.context.Dependent;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Dependent
public class CustomCalendarGsonConverter implements JsonDeserializer<Calendar>, JsonSerializer<Calendar> {

	@Override
	public JsonElement serialize(Calendar calendar, Type typeOfSrc, JsonSerializationContext context) {
		String dateString = new SimpleDateFormat(ConvertDateService.formatIso).format(ConvertDateService.toDate(calendar)); 
		return new JsonPrimitive(dateString); 
	}

	@Override
	public Calendar deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		
		try { 
			if (json.isJsonNull()) return null;
			return ConvertDateService.toCalendar(json.getAsString());
		} catch (ParseException e) { 
			throw new JsonSyntaxException(json.getAsString(), e); 
		} 
	}

}
