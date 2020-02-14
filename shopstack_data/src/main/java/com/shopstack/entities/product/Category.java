package com.shopstack.entities.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author RAY-ABEL
 *
 */
@Entity
@Table(name="category")
public class Category {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="category_id")	
 private int id;

@Column(name="category_name")
private String categoryName;

public Category() {
	
}

public Category(String categoryName) {
	
	this.categoryName = categoryName;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getCategoryName() {
	return categoryName;
}

public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}

@Override
public String toString() {
	return "Category [id=" + id + ", categoryName=" + categoryName + "]";
}


}
