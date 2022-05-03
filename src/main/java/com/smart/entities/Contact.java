package com.smart.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class Contact 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	@Column(nullable = false,unique = true)
	private String name;
	
	@Column
	private String secondName;
	
	@Column
	private String email;
	
	@Column
	private String work;
	
	@Column
	private String phone;
	
	@Column
	private String image;
	
	@Column(length = 5000)
	private String description;
	
	@ManyToOne
	private User user;
	
	
	

}
