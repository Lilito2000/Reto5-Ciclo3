package com.usa.ciclo3.ciclo3.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.usa.ciclo3.ciclo3.model.Category;
import com.usa.ciclo3.ciclo3.service.CategoryService;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/all")
	public List<Category> getCategories() {
		return categoryService.getAll();
	}

	@GetMapping("/{id}")
	public Optional<Category> getCategory(@PathVariable("id") int id) {
		return categoryService.getCategory(id);
	}

	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Category saveCategory(@RequestBody Category category) {
		return categoryService.save(category);
	}

	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Category updateCategory(@RequestBody Category category) {
		return categoryService.update(category);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean deleteCategory(@PathVariable("id") int categoryId) {
		return categoryService.deleteCategory(categoryId);
	}
}