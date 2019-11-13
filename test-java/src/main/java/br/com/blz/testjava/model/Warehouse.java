package br.com.blz.testjava.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Warehouse {

	private String type;
	private String locality;
	private int quantity;

	@JsonProperty("locality")
	public String getLocality() {
		return this.locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	@JsonProperty("quantity")
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@JsonProperty("type")
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
