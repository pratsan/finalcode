/**
 * 
 */
package com.star.onlineshopping.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.star.onlineshopping.entity.Products;

/**
 * @author User1
 *
 */
@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
	
	public List<Products> findByType(String type);

}
