package com.cg.bookStore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="bookstore_book_category")
@DynamicInsert
@DynamicUpdate
public class BookCategory {

	@Id
	@Column(name="category_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="categoryIdGenerator")
	@SequenceGenerator(name="categoryIdGenerator", initialValue=100)
	private int categoryId;
	
	@Column(name="category_name")
	private String categoryName;
	

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}