package com.app.entities;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table()
public class Feedback extends BaseEntity{
   
	@NotBlank(message = "Full name cannot be blank")
	@NotNull(message = "Enter valid name")
	@Column(name = "full_name", length = 20,nullable = false)
	@Length(min = 4, max = 20, message="Number of characters in name field should be between 4 to 20")
    private String name;
	
	@NotNull
	@NotBlank
	@Column(name = "email_id",length = 20, unique = true, nullable = false)
	@Email(message = "Invalid email format")
    private String emailId;
	
	@NotBlank(message = "Mobile Number cannot be blank")
	@NotNull
	@Column(name="mob_no",length = 20,nullable = false)
	@Pattern(regexp = "^\\d{10}$")
    private String phoneNo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private int rating;
    
    
    @Lob
    @Column(nullable = false, length = 300)
    private String description;
}
