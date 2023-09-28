package com.jdc.goldern.members.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.jdc.goldern.members.model.dto.input.CatalogEdit;
import com.jdc.goldern.members.model.dto.input.CatalogSearch;
import com.jdc.goldern.members.model.dto.input.ReviewForm;
import com.jdc.goldern.members.model.dto.output.CatalogDetails;
import com.jdc.goldern.members.model.dto.output.CatalogDto;
import com.jdc.goldern.members.model.repo.CatalogRepo;
import com.jdc.goldern.members.model.repo.CategoryRepo;
import com.jdc.goldern.members.model.utils.exceptions.ApiBusinessException;

@Service
@Transactional
public class CatalogService {
	
	@Autowired
	private CatalogRepo repo;
	@Autowired
	private CategoryRepo  categoryRepo;
	
	@Autowired
	private PhotoStorageService storageService;

	@Transactional(readOnly = true)
	public Page<CatalogDto> search(CatalogSearch form, int page, int size) {
		return repo.findAll(form.where(), PageRequest.of(page, size)).map(CatalogDto::from);
	}

	@Transactional(readOnly = true)
	public CatalogDetails findDetails(long id) {
		return repo.findById(id).map(CatalogDetails::from)
				.orElseThrow(() -> new ApiBusinessException("There is no catalog with id %d".formatted(id)));
	}

	public CatalogDetails create(CatalogEdit form) {
		var entity = repo.save(form.entity(id -> categoryRepo.getReferenceById(id)));
		return findDetails(entity.getId());
	}

	public CatalogDetails update(long id, CatalogEdit form) {
		return repo.findById(id).map(entity -> {
			entity.setName(form.getName());
			entity.setCategories(form.getCategories().stream().map(categoryRepo::getReferenceById).toList());
			entity.setDescription(form.getDescription());
			entity.setPurity(form.getPurity());
			entity.setWeight(form.getWeight());
			entity.setLostWeight(form.getLostWeight());
			entity.setPrice(form.getPrice());
			return findDetails(id);
		})
		.orElseThrow(() -> new ApiBusinessException("There is no catalog with id %d".formatted(id)));
				
	}

	public CatalogDetails photoUpload(long id, MultipartFile[] files) {
		repo.findById(id).ifPresent(entity -> {
			var photos = storageService.save(id, files);
			if(!photos.isEmpty()) {
				entity.setImages(photos);
				entity.setCoverImage(photos.get(0));
			}
		});
		return findDetails(id);
	}

	public CatalogDetails makeReview(long catalogId, String username, ReviewForm form) {
		// TODO Auto-generated method stub
		return null;
	}

}
