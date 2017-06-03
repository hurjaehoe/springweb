package com.roamstory.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;

/*
 * 확장자를 가지고 이미지 타입인지를 판단
 */
public class MediaUtils {
	
	private static Map<String, MediaType> mediaMap;
	
	static {
		
		mediaMap = new HashMap<String, MediaType>();
		mediaMap.put("JPG", MediaType.IMAGE_JPEG);
		mediaMap.put("PNG", MediaType.IMAGE_PNG);
		mediaMap.put("GIF", MediaType.IMAGE_GIF);
	}
	
	
	public static MediaType getMediaType(String type) {
		return mediaMap.get(type.toUpperCase());
	}

}
