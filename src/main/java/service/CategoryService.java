package service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import common.ServiceResult;
import entity.Category;
import entity.Product;
import repository.ICategoryRepository;
import repository.IProductRepository;

@Service
public class CategoryService {
 
	private final ICategoryRepository categoryRepository;
	private final IProductRepository productrepository;

    public CategoryService( ICategoryRepository categoryRepository,IProductRepository productrepository)
    {
    	this.categoryRepository=categoryRepository;
    	this.productrepository=productrepository;
    }
	
    public ServiceResult<Void> saveCategory(Category category) {
    	
    	ServiceResult<Void> result = new ServiceResult<>();
    	
    	if(category.getName()==null)
    	{
    		result.setSuccess(false);
    		result.setErrorMessage("Name canot be null");
    	}
    categoryRepository.save(category);    	
    return result;
    }
    
    public ServiceResult<List<Category>> getAllCategories(){
    	   List<Category> categories = (List<Category>) categoryRepository.findAll();
    	    ServiceResult<List<Category>> result = new ServiceResult<>();
    	    result.setSuccess(true); // İşlem başarılı
    	    result.setData(categories); // Veriyi ata
    	    return result;
    }
    
    public ServiceResult<Void> deleteCategory(Integer id) {
        ServiceResult<Void> result = new ServiceResult<>();

        // Veritabanından kategori bulma
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        
        if (categoryOptional.isEmpty()) {
        	// İşlem başarılı ise result'u güncelle
        	result.setSuccess(false);
           result.setErrorMessage("Category not found");
           return result;
            
        } 
        
        List<Product> productsByCategory= productrepository.findAllByCategoryId(id);
        
        if(!productsByCategory.isEmpty()) {
        	// İşlem başarılı ise result'u güncelle
        	result.setSuccess(false);
           result.setErrorMessage("This category can not delete !");
           return result;
        }
        
        categoryRepository.delete(categoryOptional.get());
        return result;
    }

}
