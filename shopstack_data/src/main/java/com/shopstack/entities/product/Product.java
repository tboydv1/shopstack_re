package com.shopstack.entities.product;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
/**
 * @author RAY-ABEL
 *
 */
@Entity
@Table(name="ss_product")
public class Product {

@Id
@Column(name="product_code")
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;

@Column(name="product_name")
private String productName;

@Column(name="purchase_date")
private Date purchaseDate;

@ManyToOne(cascade=CascadeType.ALL)
@JoinColumn(name="category_id")
private Category category;

@Column(name="price")
private Double price;

@Column(name="decription")
private String description;

public Product() {
	
}



public Product( String productName, Date purchaseDate, Category category, Double price, String description) {
	

	this.productName = productName;
	this.purchaseDate = purchaseDate;
	this.category = category;
	this.price = price;
	this.description = description;
}



public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}

public Date getPurchaseDate() {
	return purchaseDate;
}

public void setPurchaseDate(Date purchaseDate) {
	this.purchaseDate = purchaseDate;
}

public Category getCategory() {
	return category;
}

public void setCategory(Category category) {
	this.category = category;
}

public Double getPrice() {
	return price;
}

public void setPrice(Double price) {
	this.price = price;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

@Override
public String toString() {
	return "Product [id=" + id + ", productName=" + productName + ", purchaseDate=" + purchaseDate + ", category="
			+ category + ", price=" + price + ", description=" + description + "]";
}

}
