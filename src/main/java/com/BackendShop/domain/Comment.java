package com.BackendShop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "comment")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment extends AbstractAuditingEntity{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "comment")
	private	String comment;
	
	@Column(name = "rating")
	@Size(max = 5)
	private int rating ;
	
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private User users;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	
	
}
