package com.ifsul.lp3activity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="preferences")
public class Preference {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
		
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "sort_option_id")
	private SortOption sortOption;
	
	private int pagination;
	
	@Column(name="categories_csv", length=45)
	private String categoriesCSV;
	
	@Column(name="locations_csv", length=45)
	private String locationsCSV;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public SortOption getSortOption() {
		return sortOption;
	}

	public void setSortOption(SortOption sortOption) {
		this.sortOption = sortOption;
	}

	public int getPagination() {
		return pagination;
	}

	public void setPagination(int pagination) {
		this.pagination = pagination;
	}

	public String getCategoriesCSV() {
		return categoriesCSV;
	}

	public void setCategoriesCSV(String categoriesCSV) {
		this.categoriesCSV = categoriesCSV;
	}

	public String getLocationsCSV() {
		return locationsCSV;
	}

	public void setLocationsCSV(String locationsCSV) {
		this.locationsCSV = locationsCSV;
	}
	
	
}
