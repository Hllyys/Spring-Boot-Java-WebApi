package repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entity.Product;

@Repository
public interface IProductRepository extends CrudRepository<Product,Integer> {

	List<Product> findAllByCategoryId(Integer categoryId);
}
