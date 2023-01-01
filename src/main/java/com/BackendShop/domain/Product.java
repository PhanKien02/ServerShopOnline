package com.BackendShop.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.BackendShop.domain.enumeration.Color;
import com.BackendShop.domain.enumeration.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
@Builder
public class Product  extends AbstractAuditingEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name="price")
	private double price;
	
	@Column(name = "active")
	private Boolean active;
	
	@Column(name = "description")
	private String description;
	
	@Column(name="amount")
	private int amount;

	@Enumerated(EnumType.STRING)
	@Column(name="color")
	private Color color ;
	
	@Enumerated(EnumType.STRING)
	@Column(name="size")
	private Size size ;
	
	@ManyToOne
	@JoinColumn(name = "trademark_id")
	private Trademark trademark;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@OneToMany(mappedBy = "product")
	private Set<CartItem> cartItems;
	
	@OneToMany(mappedBy = "comment")
	private Set<Comment> comments;
	
	@OneToMany(mappedBy = "product")
	private Set<OrderDetail> orderItems;
	
}
