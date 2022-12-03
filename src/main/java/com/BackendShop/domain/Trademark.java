package com.BackendShop.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "trademark")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Trademark {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "logo")
	private String logo;
	
	@Column(name = "active")
	private Boolean active ;
	
	@OneToMany(mappedBy = "trademark")
	private Set<Product> products;
	
}
