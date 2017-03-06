package com.nandini.javaprojectbackend.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {

	
	/*
	 * private members
	 * 
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String name;
	private String description;
	@Column(name="image_url")
	private String ImageURL;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageURL() {
		return ImageURL;
	}
	public void setImageURL(String imageURL) {
		ImageURL = imageURL;
	}
	@Override
	public String toString() {
		return "Category [Id=" + Id + ", name=" + name + ", description=" + description + ", ImageURL=" + ImageURL
				+ "]";
	}
	
	
}
