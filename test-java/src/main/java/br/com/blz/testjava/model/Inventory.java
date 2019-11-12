package br.com.blz.testjava.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Inventory {
	private int quantity;
	private List<Warehouse> warehouses;

	@JsonProperty("quantity")
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@JsonProperty("warehouses")
	public List<Warehouse> getWarehouses() {
		return this.warehouses;
	}

	public void setWarehouses(List<Warehouse> warehouses) {
		this.warehouses = warehouses;
	}

}
