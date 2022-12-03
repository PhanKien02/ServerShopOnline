package com.BackendShop.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends AbstractAuditingEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "username", nullable = false, unique = true, length = 50)
	@NotNull
	@Size(min = 1 , max = 50)
	private String userName;
	
	@Column(name = "password", nullable = false, length = 255)
	@Size(min = 60, max = 60)
	@NotNull
	private String password;
	
	@Column(name = "name", length = 50)
	@Size(max = 50)
	private String name;
	
	@Column(name = "phone", length = 10)
	@Size(min = 10,max = 10)
	private String phone;
	
	@Column(name = "email",length = 255, unique = true)
	@Size(max = 255)
	private String email;
	
	@Column(name = "sex", length = 10)
	@Size(max = 10)
	private String sex;
	
	@Column(name = "activeKey" , length = 20)
	@Size(max=20)
	@JsonIgnore
	private String activeKey;
	@Column(name = "resetKey" , length = 20)
	@Size(max=20)
	@JsonIgnore
	private String resetkey;
	
	@Column(name = "active")
	private boolean active;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name = "user_authori",
			joinColumns ={ @JoinColumn(name = "user_id",referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name="authority_name",referencedColumnName = "authori")}			
			)
	private Set<Authorization>  authorization = new HashSet<>();
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name = "cart",
			joinColumns ={ @JoinColumn(name = "user_id",referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name="cart_item_id",referencedColumnName = "id")}			
			)
	private Set<CartItem> cartItems = new HashSet<>();
	
	@OneToMany(mappedBy = "users")
	private Collection<Comment> comments;
	
	@OneToMany(mappedBy = "user")
	private Collection<Order> orders;
}
