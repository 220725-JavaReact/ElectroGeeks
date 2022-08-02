package com.electrogeeks.models;

import com.electrogeeks.exceptions.InvalidPriceException;
import com.electrogeeks.exceptions.InvalidRatingException;
import com.electrogeeks.util.Logger;
import com.electrogeeks.util.Logger.LogLevel;

public class Electronic {
	private String name;
	private String model;
	private Double price;
	private int rating;
	// total number of user who rated
	private int count;
	// total rating points 
	private int ratingPoints;
	private String[] review;
	private String[] storeRecommendation;
	private String description;
	
	public Electronic(String name, String model, Double price,String[] storeRecommendation, String description) {
		super();
		this.name = name;
		this.model = model;
		this.price = price;
		this.rating = 0;
		this.ratingPoints = 0;
		this.review = new String[10];
		this.storeRecommendation = storeRecommendation;
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		if(price < 0) {
			throw new InvalidPriceException("Price must be greater than 0");
		}
		this.price = price;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		if(rating>5 && rating<1) {
			throw new InvalidRatingException("Rating should be between 1 and 5");
		}
		// a = 3   .. count =1, ratinp =3
		// b = 5   .. count =2, ratinp =8
		// avg = 8/2 = 4  ... 4
		// c= 1    .. count =3, ratinp =9
		// avg = 4+1 = 5/2 = 2.5 ... 3
		this.count ++;
		this.ratingPoints += rating;
		this.rating = this.ratingPoints/count;
		

	}

	public String[] getStoreRecommendation() {
		return storeRecommendation;
	}

	public void setStoreRecommendation(String[] storeRecommendation) {
		this.storeRecommendation = storeRecommendation;
	}
	
	@Override
	public String toString() {
//		StringBuilder string = new StringBuilder();
		String string = "";
		string += ("Product Name : " + this.getName() +"\n");
		string += ("Product Model : " + this.getModel() +"\n");
		string += ("Product Description : " + this.getDescription() +"\n");
		string += ("Product Price : " + this.getPrice() +"\n");
		string += ("Product average rating: " + this.getRating()+" ("+this.count+")" +"\n");
		string += ("Store Recommendation: ");
		for(int i =0; i<this.storeRecommendation.length;i++) {
			string += (this.storeRecommendation[i]);
			if(i < this.storeRecommendation.length-1) {
				string += (", ");
			}
		}
		return string;
	}
	
	
}
