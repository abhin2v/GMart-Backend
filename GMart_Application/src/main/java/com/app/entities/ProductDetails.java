package com.app.entities;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
//import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="product_details")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"image1","image2","image3"})
//@AllArgsConstructor
public class ProductDetails extends BaseEntity {
	
	@NotNull(message = "Product name cannot be null")
	@NotBlank(message = "Product name cannot be blank")
	@Column(name="prod_name", nullable = false)
    private String productName;

    @NotNull(message = "MRP cannot be null")
    @DecimalMin(value = "0.01", message = "MRP must be greater than 0")
    private BigDecimal mrp;

    @DecimalMax(value = "100.00", message = "Discount cannot be greater than 100%")
    @DecimalMin(value = "0.00", message = "Discount cannot be negative")
    private BigDecimal discount;

    //@NotBlank(message = "Category cannot be blank")
    @NotNull(message = "Category cannot be blank")
    @Enumerated(EnumType.STRING)
    private Category category;

    @Min(value = 0, message = "Total number of orders cannot be negative")
    @Column(name="total_orders")
    private int totalNoOfOrders;  //it will be zero by default when the product is added

    @NotBlank(message = "Description cannot be blank")
    private String description;

    @Min(value = 0, message = "Quantity cannot be negative")
    private int quantity;

    private boolean isAvailable = true;
    
    @NotNull
    @NotBlank(message = "Image path cannot be blank")
    private String image1;

    private String image2;

    private String image3;
    
    
	@ManyToOne /* (fetch = FetchType.EAGER) */
	@JoinColumn(name = "company_id", nullable = false) // FK
	private Company company;


	public ProductDetails(
			@NotNull(message = "Product name cannot be null") @NotBlank(message = "Product name cannot be blank") String productName,
			@NotNull(message = "MRP cannot be null") @DecimalMin(value = "0.01", message = "MRP must be greater than 0") BigDecimal mrp,
			@DecimalMax(value = "100.00", message = "Discount cannot be greater than 100%") @DecimalMin(value = "0.00", message = "Discount cannot be negative") BigDecimal discount,
			@NotBlank(message = "Category cannot be blank") @NotNull(message = "Category cannot be blank") Category category,
			@Min(value = 0, message = "Total number of orders cannot be negative") int totalNoOfOrders,
			@NotBlank(message = "Description cannot be blank") String description,
			@Min(value = 0, message = "Quantity cannot be negative") int quantity, boolean isAvailable,
			@NotNull @NotBlank(message = "Image path cannot be blank") String image1, String image2, String image3) {
		super();
		this.productName = productName;
		this.mrp = mrp;
		this.discount = discount;
		this.category = category;
		this.totalNoOfOrders = totalNoOfOrders;
		this.description = description;
		this.quantity = quantity;
		this.isAvailable = isAvailable;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
	}
    
    
    
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product",cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<ProductList> prodList;
}
