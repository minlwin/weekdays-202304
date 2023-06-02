package com.jdc.demo.model;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.Part;

public class ImageStorageService {
	

	public List<String> saveImages(String folder, List<Part> files) {
		List<String> list = new ArrayList<>();
		
		try {
			for(int i = 0; i < files.size(); i ++) {
				
				// Generate File Name
				var part = files.get(i);
				var fileName = new FileName(i, part).getValue();
				
				// Copy Uploaded File to destination
				Files.copy(part.getInputStream(), Path.of(folder, fileName), StandardCopyOption.REPLACE_EXISTING);
				
				// Add file Name to list
				list.add(fileName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	private class FileName {
		
		private String extension;
		private int index;
		
		FileName(int index, Part part) {
			this.index = index;
			
			var name = part.getSubmittedFileName();
			
			if(null != name) {
				var array = part.getSubmittedFileName().split("\\.");
				extension = array[array.length - 1];
			} else {
				extension = "png";
			}			
		}
		
		String getValue() {
			var current = LocalDateTime.now()
					.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
			return "%s-%d.%s".formatted(current, index, extension);
		}
		
	}	
}
