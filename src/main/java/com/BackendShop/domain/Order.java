package com.BackendShop.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "_order")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  long id;
	
	@Column(name = "orderTotal")
	private double orderTotal;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "status")
	private String	status ;
	
	@Column(name = "active")
	private Boolean active;
	
	@OneToOne
	@JoinColumn(name = "label_id")
	private Label label;
	
	@OneToMany(mappedBy = "order")
	private Collection<OrderDetail> orderDetailrs;
	
	@OneToOne
	@JoinColumn(name = "address_id")
	private DeliveryAddress deliveryAddress;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
}
