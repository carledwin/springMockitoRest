package com.wordpress.carledwinj.spring.mockito.rest.util;

import java.nio.charset.Charset;

import org.springframework.http.MediaType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtil {

	public static final String UTF_8 = "UTF-8";
	
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), 
																		MediaType.APPLICATION_JSON.getSubtype(), 
																		Charset.forName(UTF_8));
	
	public static byte[] convertObjectToJsonBytes(Object object) throws JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		
		return mapper.writeValueAsBytes(object);
	}
}
