package com.app.services;

import java.util.List;

import com.app.dto.ProductDetailsDto;
import com.app.entities.ProductDetails;

public interface ProductDetailsService {

	//to get list but not sorted
	List<ProductDetailsDto> getAllProductsByCompanyId(Long companyId);

	//adding a new product
	ProductDetails addProduct(ProductDetailsDto productDetailsDto, Long companyId);
	
	//delete a product by id
	boolean deleteAProduct(Long productId);
	
	//to get sorted list
	List<ProductDetailsDto> getAllProductsByCompanyIdByName(Long companyId);
	
	List<ProductDetailsDto> getAllOutOfStockProducts(Long companyId);

}
