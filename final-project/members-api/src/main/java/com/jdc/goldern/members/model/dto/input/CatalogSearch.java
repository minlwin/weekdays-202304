package com.jdc.goldern.members.model.dto.input;

import java.util.Optional;

import lombok.Data;

@Data
public class CatalogSearch {

	private Optional<String> keyword;

	private Optional<Integer> categoryId;

}