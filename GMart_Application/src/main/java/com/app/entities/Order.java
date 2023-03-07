package com.app.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="order_tbl")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Order extends BaseEntity {

    @NotNull(message = "Order date cannot be null.")
    @PastOrPresent(message = "Order date cannot be in the future.")
    @Column(name="order_date")
    private LocalDate orderDate; //@createTimeStamp

    @NotNull(message = "Order status cannot be null.")
    @Column(name="order_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus; //we are not allowing user to fill this field so @NotNull is 
    //not required

    @NotNull(message = "Estimated delivery date cannot be null.")
    private LocalDate estimatedDeliveryDate; //same for this

    @NotNull(message = "Total price cannot be null.")
    @Positive(message = "Total price must be positive.")
    private BigDecimal totalPrice;   //not null is not required

    private LocalDate deliveryDate;

    @NotNull(message = "Total quantity cannot be null.")
    @Positive(message = "Total quantity must be positive.")
    private Integer totalQuantity;

	public Order(
			@NotNull(message = "Estimated delivery date cannot be null.") LocalDate estimatedDeliveryDate,
			@NotNull(message = "Total price cannot be null.") @Positive(message = "Total price must be positive.") BigDecimal totalPrice,
			LocalDate deliveryDate,
			@NotNull(message = "Total quantity cannot be null.") @Positive(message = "Total quantity must be positive.") Integer totalQuantity) {
		super();
		this.orderDate = LocalDate.now();
		this.orderStatus = OrderStatus.CREATED;
		this.estimatedDeliveryDate = estimatedDeliveryDate;
		this.totalPrice = totalPrice;
		this.deliveryDate = deliveryDate;
		this.totalQuantity = totalQuantity;
	}


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProductList> prodList;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "retailer_id", nullable = false) // FK
	private Retailer retailer;
    
    
    
}
