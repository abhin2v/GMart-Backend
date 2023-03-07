package com.app.dto;

import java.math.BigDecimal;

import com.app.entities.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductDetailsDto {
	
	private String productName;
	private BigDecimal mrp;
	private BigDecimal discount;
	private Category category;
	private String description;
	private int quantity;
	private String image1;
	private String image2;
	private String image3;
}