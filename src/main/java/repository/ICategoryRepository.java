package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entity.Category;

@Repository
public interface ICategoryRepository extends CrudRepository<Category,Integer> {

}
