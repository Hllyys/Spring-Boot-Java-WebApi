package controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import common.ServiceResult;
import entity.Category;
import service.CategoryService;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping
	public ResponseEntity<ServiceResult<List<Category>>> fetchAll(){
		return new ResponseEntity<>(categoryService.getAllCategories(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ServiceResult<Void>> createCategory(@RequestBody Category category)
	{
		return new ResponseEntity<>(categoryService.saveCategory(category),HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<ServiceResult<Void>> updateCategory(@RequestBody Category category)
	{
		return new ResponseEntity<>(categoryService.saveCategory(category),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ServiceResult<Void>> deleteCategory(@PathVariable Integer id)
	{
		return new ResponseEntity<>(categoryService.deleteCategory(id),HttpStatus.OK);
	}
}
