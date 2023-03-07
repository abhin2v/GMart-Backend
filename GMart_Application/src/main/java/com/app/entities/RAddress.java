package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "retailer_addr")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RAddress extends BaseEntity{
	@NotNull
	@NotBlank
	private String shopNo;
	@NotBlank(message = "Street name cannot be blank")
    @Size(max = 50, message = "Street name cannot exceed {max} characters")
	@Column(name = "street_name")
    private String streetName;
    
    @NotBlank(message = "Locality cannot be blank")
    @Size(max = 50, message = "Locality cannot exceed {max} characters")
    private String locality;
    
    @NotBlank(message = "City cannot be blank")
    @Size(max = 50, message = "City name cannot exceed {max} characters")
    private String city;
    
    @NotBlank(message = "State cannot be blank")
    @Size(max = 50, message = "State name cannot exceed {max} characters")
    private String state;
    
    @NotNull(message = "Pincode cannot be null")
    @Pattern(regexp = "^[1-9][0-9]{5}$", message = "Pincode must be a 6-digit number")
    @Size(min = 6, max = 6)
    private String pincode;
	
	private boolean isDefault;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="retailer_id", nullable = false)
	private Retailer retailer;

	public RAddress(@NotNull @NotBlank String shopNo,
			@NotBlank(message = "Street name cannot be blank") @Size(max = 50, message = "Street name cannot exceed {max} characters") String streetName,
			@NotBlank(message = "Locality cannot be blank") @Size(max = 50, message = "Locality cannot exceed {max} characters") String locality,
			@NotBlank(message = "City cannot be blank") @Size(max = 50, message = "City name cannot exceed {max} characters") String city,
			@NotBlank(message = "State cannot be blank") @Size(max = 50, message = "State name cannot exceed {max} characters") String state,
			@NotNull(message = "Pincode cannot be null") @Pattern(regexp = "^[1-9][0-9]{5}$", message = "Pincode must be a 6-digit number") @Size(min = 6, max = 6) String pincode,
			Retailer retailer) {
		super();
		this.shopNo = shopNo;
		this.streetName = streetName;
		this.locality = locality;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.retailer = retailer;
	}
	
	
	
}
