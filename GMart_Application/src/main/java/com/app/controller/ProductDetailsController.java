package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ProductDetailsDto;
import com.app.entities.ProductDetails;
import com.app.services.ProductDetailsService;
//import com.app.services.ProductDetailsServiceImpl;

@RestController
@RequestMapping("/company/{companyId}")
public class ProductDetailsController {
	@Autowired
	private ProductDetailsService productDetailsService;
	
//	private ModelMapper modelMapper;
	
	//1 ->
	@GetMapping("/")
	public List<ProductDetailsDto> getAllProductsByCompanyId(@PathVariable Long companyId) {
		System.out.println("----------------Company Id = "+companyId);
		return productDetailsService.getAllProductsByCompanyId(companyId);
	}
	
	//2 ->
	@PostMapping("/add")
	public ResponseEntity<ProductDetails> addProduct(@RequestBody ProductDetailsDto productDetailsDto, @PathVariable Long companyId) {
		ProductDetails product = productDetailsService.addProduct(productDetailsDto, companyId);
		return new ResponseEntity<>(product, HttpStatus.CREATED);
	}
	
	//3 ->
	@DeleteMapping("/product/{productId}")
	public ResponseEntity<String> deleteAProduct(@PathVariable Long productId) {
		boolean isDeleted = productDetailsService.deleteAProduct(productId);
		if(isDeleted) {
			return new ResponseEntity<>("Product with ID "+productId+" deleted successfully", HttpStatus.OK);
		}
		return new ResponseEntity<>("Failed to delete product with ID " + productId+" because it is not present.", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//4 ->
	@GetMapping("/sortByName")
	public List<ProductDetailsDto> getAllProductsByCompanyIdByName(@PathVariable Long companyId) {
		return productDetailsService.getAllProductsByCompanyIdByName(companyId);
	}
	
	//5 ->
	@GetMapping("/outOfStock")
	public List<ProductDetailsDto> getAllOutOfStockProducts(@PathVariable Long companyId) {
		System.out.println("----------------Company Id = "+companyId+" Quantity = 0");
		return productDetailsService.getAllOutOfStockProducts(companyId);
	}
	
}