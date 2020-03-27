/**
 * 
 */
package com.star.onlineshopping.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

/**
 * @author User1
 *
 */
@Entity
@Table(name = "USER", uniqueConstraints = { @UniqueConstraint(columnNames = "id") })
@Setter
@Getter
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PHONE_NUMBER", unique = true)
	private String phoneNumber;

	@Column(name = "EMAIL", unique = true)
	private String email;

	@Column(name = "USER_TYPE")
	private String userType;

	@Column(name = "PASSWORD")
	private String password;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private List<PurchaseHistory> buyProduct;

}

