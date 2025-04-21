package service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import common.ServiceResult;
import entity.Category;
import entity.Product;
import repository.IProductRepository;

@Service
public class ProductService {

	private final IProductRepository productRepository;

	public ProductService(IProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	
	 public ServiceResult<Void> saveProduct(Product product) {
	    	
	    	ServiceResult<Void> result = new ServiceResult<>();
	    	
	    	if(product.getTitle()==null|| product.getPrice()==null)
	    	{
	    		result.setSuccess(false);
	    		result.setErrorMessage("Please fill all fields");
	    	}
	    productRepository.save(product);    	
	    return result;
	    }
	 
	    
	    public ServiceResult<List<Product>> getAllProducts(){
	    	   List<Product> products = (List<Product>) productRepository.findAll();
	    	    ServiceResult<List<Product>> result = new ServiceResult<>();
	    	    result.setSuccess(true);
	    	    result.setData(products); 
	    	    return result;
	    }
	    
	    public ServiceResult<Void> deleteProduct(Integer id) {
	        ServiceResult<Void> result = new ServiceResult<>();

	        // Veritabanından kategori bulma
	        Optional<Product> productOptional = productRepository.findById(id);
	        
	        if (productOptional.isEmpty()) {
	        	// İşlem başarılı ise result'u güncelle
	        	result.setSuccess(false);
	           result.setErrorMessage("Categor not found");
	           return result;
	            
	        } 
	        productRepository.delete(productOptional.get());
	        return result;
	    }
	
}
