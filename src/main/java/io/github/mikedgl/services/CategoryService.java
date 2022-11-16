package io.github.mikedgl.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.mikedgl.dto.CategoryDTO;
import io.github.mikedgl.entities.Category;
import io.github.mikedgl.repositories.CategoryRepository;
import io.github.mikedgl.services.exceptions.EntityNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll(){
		List<CategoryDTO> categoryDTOs = categoryRepository.findAll().stream().map(category -> new CategoryDTO(category)).collect(Collectors.toList());
		return categoryDTOs;
	}
	
	@Transactional(readOnly = true)
	public CategoryDTO findById(Long id){
		Category category =  categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found."));
		return new CategoryDTO(category);
	}
}
