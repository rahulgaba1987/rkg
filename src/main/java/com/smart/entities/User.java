package com.smart.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false,unique = true)
	@NotBlank(message = "Name cannot be blank")
	@Size(min=4,max =10,message = "Minimum character should be 4 & maximum 10 characters are allowed")
	
	
	
	private String name;
	@Column(unique = true)
	
	@NotBlank(message = "Please enter your email")
	private String email;
	@Column
	@NotBlank(message = "Please enter your password")
	private String password;
	@Column
	private String role;
	
	@Column
	private boolean enabled;
	@Column
	private String imageUrl;
	@Column
	private String about;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private List<Contact> contacts = new ArrayList();
	
}
