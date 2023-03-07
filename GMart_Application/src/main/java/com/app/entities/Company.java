package com.app.entities;

import java.util.List;

//import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "company_tbl")
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "password")
public class Company extends BaseEntity {
	
	@Column(name = "user_name", length = 40, unique = true)
	@Length(min = 6, max = 40, message = "Username should be between 6 and 40 characters")
	@NotBlank(message = "Username cannot be blank")
	@Pattern(regexp = "^[a-zA-Z0-9_-]+$")
	private String username;
	
	@Column(length = 300)
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d@$!%*#?&]{8,}$")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
//	@NotBlank(message = "Mobile Number cannot be blank")
//	@NotNull
//	@Column(name="mob_no",length = 20)
//	@Pattern(regexp = "^\\d{10}$")
//	private String mobileNo;
	
	@NotBlank(message = "Email cannot be blank")
	@Email(message = "Invalid email format")
	@Column(length = 40, unique = true)
	private String email;
	
	@NotNull
	@NotBlank(message = "Mobile Number cannot be blank")
	@Size(min=10, max=10)
	@Pattern(regexp = "^[1-9]\\d{9}$")
	@Column(name = "mob_no", unique = true, length = 10)
	private String contactNumber;
	
	@Column(name = "Alternate_Mobile_Number")
	@Size(min=10, max = 10)
	@Pattern(regexp = "^[1-9]\\d{9}$")
	private String alternateMobNumber;
	
	@Column(name="company_name",length = 40, unique = true)
	@NotBlank(message = "Company Name cannot be blank")
	private String companyName;
	
	
	@Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "streetName", column = @Column(name = "address_street")),
            @AttributeOverride(name = "locality", column = @Column(name = "address_locality")),
            @AttributeOverride(name = "city", column = @Column(name = "address_city")),
            @AttributeOverride(name = "state", column = @Column(name = "address_state")),
            @AttributeOverride(name = "pincode", column = @Column(name = "address_pin_code"))
    })
    private CAddress address;
	
	
    
    public Company(
			@Length(min = 6, max = 40, message = "Username should be between 6 and 40 characters") @NotBlank(message = "Username cannot be blank") @Pattern(regexp = "^[a-zA-Z0-9_-]+$") String username,
			@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d@$!%*#?&]{8,}$") String password,
			@NotBlank(message = "Email cannot be blank") @Email(message = "Invalid email format") String email,
			@NotNull @NotBlank(message = "Mobile Number cannot be blank") @Size(min = 10, max = 10) @Pattern(regexp = "^[1-9]\\d{9}$") String contactNumber,
			@Size(min = 10, max = 10) @Pattern(regexp = "^[1-9]\\d{9}$") String alternateMobNumber,
			@NotBlank(message = "Company Name cannot be blank") String companyName, CAddress address) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.contactNumber = contactNumber;
		this.alternateMobNumber = alternateMobNumber;
		this.companyName = companyName;
		this.address = address;
	}


    @JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "company",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProductDetails> prodDetailsList;

	
	
		
	
	
}
