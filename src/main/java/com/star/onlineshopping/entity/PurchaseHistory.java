package com.star.onlineshopping.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class PurchaseHistory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
	@ManyToOne
private User user;
	@ManyToOne
private Products products;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
private float rating;
private int quantity;
private float price;
}
