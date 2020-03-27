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
@Setter
@Getter
@Entity
@Table(name = "Products", uniqueConstraints = { @UniqueConstraint(columnNames = "id") })
public class Products implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "PRICE")
	private Double price;

	@Column(name = "PRODUCT_CODE")
	private String productCode;
	@Column(name = "QUANTITY")
	private int quantity;

	@Column(name = "TYPE")
	private String type;
	private float rating;
	 @OneToMany(cascade = CascadeType.ALL,mappedBy = "products")
		private List<PurchaseHistory> buyProduct;
	}
