package com.BackendShop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "authorization")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Authorization {

	@Id
	@Size(max = 50)
	@Column(name = "authori")
	private String authori;
	
	@Column(name = "description", length = 50)
	@Size(max=50)
	private String description;
	 
}
