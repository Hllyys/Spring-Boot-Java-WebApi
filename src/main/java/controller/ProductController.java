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
import entity.Product;
import service.ProductService;

@RestController
@RequestMapping("api/products")
public class ProductController {
	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	public ResponseEntity<ServiceResult<List<Product>>> fetchAll(){
		return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ServiceResult<Void>> createProduct(@RequestBody Product product)
	{
		return new ResponseEntity<>(productService.saveProduct(product),HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<ServiceResult<Void>> updateProduct(@RequestBody Product product)
	{
		return new ResponseEntity<>(productService.saveProduct(product),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ServiceResult<Void>> deleteProduct(@PathVariable Integer id)
	{
		return new ResponseEntity<>(productService.deleteProduct(id),HttpStatus.OK);
	}
	

}
