package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

//there is no use of cartId tht's y it is nt required to extend BaseEntity
@Entity
@Table
public class Cart  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="serial_no")
	private Long SrNo;  // id can be taken base entity also 
	
	@NotNull(message = "Quantity cannot be null.")
    @Min(value = 1, message = "Quantity must be at least 1.")
    private Integer quantity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false) // FK
	private ProductDetails product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "retailer_id", nullable = false) // FK
	private Retailer retailer;
}
