package com.BackendShop.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
		
	private int amount;
	@ManyToMany
	@JoinTable(
			name ="color_product",
			joinColumns= {@JoinColumn(name="color_id",referencedColumnName = "id")},
			inverseJoinColumns= {@JoinColumn(name = "product_id",referencedColumnName = "id")}		
			)
	private Collection<Color> colors ;
	
	@ManyToMany
	@JoinTable(
			name = "size_product",
			joinColumns = {@JoinColumn(name="size_id", referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name="product_id",referencedColumnName = "id")}
			)	
	private Collection<Size> sizes ;
	
	@ManyToOne
	@JoinColumn(name = "trademark_id")
	private Trademark trademark;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@OneToMany(mappedBy = "product")
	private Collection<CartItem> cartItems;
	
	@OneToMany(mappedBy = "comment")
	private Collection<Comment> comments;
	
	@OneToMany(mappedBy = "product")
	private Collection<OrderDetail> orderItems;
}
