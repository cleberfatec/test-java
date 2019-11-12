package br.com.blz.testjava.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import springfox.documentation.annotations.ApiIgnore;

public class Produto {
	private int sku;
	private String name;
	private boolean isMarketable;
	private Inventory inventory;

	@ApiIgnore
	public int getSku() {
		return this.sku;
	}

	public void setSku(int sku) {
		this.sku = sku;
	}

	@JsonProperty("name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("inventory")
	public Inventory getInventory() {
		return this.inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	@ApiIgnore
	public boolean getIsMarketable() {
		return this.isMarketable;
	}

	public void setIsMarketable(boolean isMarketable) {
		this.isMarketable = isMarketable;
	}

}
