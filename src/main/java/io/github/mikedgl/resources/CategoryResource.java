package io.github.mikedgl.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.mikedgl.dto.CategoryDTO;
import io.github.mikedgl.entities.Category;
import io.github.mikedgl.services.CategoryService;
import io.github.mikedgl.services.exceptions.EntityNotFoundException;

@RestController
@RequestMapping(value = "/categorys")
public class CategoryResource {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll(){
		List<CategoryDTO> categories = categoryService.findAll();
		return ResponseEntity.status(200).body(categories);
	}
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<CategoryDTO> findById(@PathVariable Long id){
		CategoryDTO category = categoryService.findById(id);
		return ResponseEntity.status(200).body(category);
	}
	
}
