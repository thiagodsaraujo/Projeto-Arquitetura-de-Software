package br.com.olimposistema.aipa.converter;

import br.com.olimposistema.aipa.service.ConvertDateService;
import com.google.gson.*;

import javax.enterprise.context.Dependent;
import java.lang.reflect.Type;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Dependent
public class CustomDateGsonConverter implements JsonDeserializer<Date>, JsonSerializer<Date> {
	
	@Override public JsonElement serialize(Date date, Type typeOfSrc, JsonSerializationContext context) { 
		if(typeOfSrc == Time.class) {
			String timeString = new SimpleDateFormat(ConvertDateService.formatTimeBrNotSecounds).format(date); //HH:mm
			return new JsonPrimitive(timeString);
		}
		String dateString = new SimpleDateFormat(ConvertDateService.formatIso).format(date); //2020-10-22T08:57:39.519-03:00 
		return new JsonPrimitive(dateString); 
		
	}

	@Override public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException { 
		try { 
			if (json.isJsonNull()) return null;
			return ConvertDateService.toDate(json.getAsString()); 
		} catch (ParseException e) { 
			throw new JsonSyntaxException(json.getAsString(), e); 
		} 
		
	}

}
