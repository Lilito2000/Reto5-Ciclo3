package com.usa.ciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.ciclo3.ciclo3.model.Category;
import com.usa.ciclo3.ciclo3.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> getAll() {
		return categoryRepository.getAll();
	}

	public Optional<Category> getCategory(int id) {
		return categoryRepository.getCategory(id);
	}

	public Category save(Category category) {
		if (category.getId() == null) {
			return categoryRepository.save(category);
		} else {
			Optional<Category> categoryAux = categoryRepository.getCategory(category.getId());
			if (categoryAux.isEmpty()) {
				return categoryRepository.save(category);
			} else {
				return category;
			}
		}
	}

	public Category update(Category category) {
		if (category.getId() != null) {
			Optional<Category> categoryEjemplo = categoryRepository.getCategory(category.getId());
			if (!categoryEjemplo.isEmpty()) {
				if (category.getName() != null) {
					categoryEjemplo.get().setName(category.getName());
				}
				if (category.getDescription() != null) {
					categoryEjemplo.get().setDescription(category.getDescription());
				}
				categoryRepository.save(categoryEjemplo.get());
				return categoryEjemplo.get();
			} else {
				return category;
			}
		} else {
			return category;
		}
	}

	public boolean deleteCategory(int id) {
		Boolean aBoolean = getCategory(id).map(category -> {
			categoryRepository.delete(category);
			return true;
		}).orElse(false);
		return aBoolean;
	}
}
