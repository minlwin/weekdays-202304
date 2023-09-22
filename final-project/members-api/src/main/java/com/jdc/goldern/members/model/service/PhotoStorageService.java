package com.jdc.goldern.members.model.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PhotoStorageService {
	
	@Value("${com.jdc.goldern.members.photo.path}")
	private String storage;

	public List<String> save(long id, MultipartFile ... files) {
		
		var list = new ArrayList<String>();
		
		var directory = getDirectory(id);
		
		for(var i = 0; i < files.length; i ++) {
			var photoName = savePhoto(directory, i, files[i]);
			if(null != photoName) {
				list.add(photoName);
			}
		}
		
		return list;
	}
	
	private String savePhoto(Path directory, int index, MultipartFile file) {
		
		try {
			var photoName = getPhotoName(index, file);
			var photo = directory.resolve(photoName);
			Files.copy(file.getInputStream(), photo, StandardCopyOption.REPLACE_EXISTING);
			return photo.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private String getPhotoName(int index, MultipartFile file) {
		var extension = getExtension(file);
		return "PHOTO%02d.%s".formatted(index, extension);
	}
	
	private String getExtension(MultipartFile file) {
		var array = file.getOriginalFilename().split("\\.");
		return array[array.length - 1];
	}
	
	private Path getDirectory(long id) {
		var directory = Path.of(storage, "CATALOG%05d".formatted(id));
		try {
			FileSystemUtils.deleteRecursively(directory);
			Files.createDirectories(directory);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return directory;
	}
	
	
}
