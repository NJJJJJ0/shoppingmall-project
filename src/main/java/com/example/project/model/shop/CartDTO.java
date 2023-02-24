package com.example.project.model.shop;

public class CartDTO {
	private int cart_id;
	private String userid;
	private String name;
	private int product_code;
	private String product_name;
	private int price;
	private int amount;
	private int money;
	private int amt1;
	private int amt2;
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getProduct_code() {
		return product_code;
	}
	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getAmt1() {
		return amt1;
	}
	public void setAmt1(int amt1) {
		this.amt1 = amt1;
	}
	public int getAmt2() {
		return amt2;
	}
	public void setAmt2(int amt2) {
		this.amt2 = amt2;
	}
	@Override
	public String toString() {
		return "CartDTO [cart_id=" + cart_id + ", userid=" + userid + ", name=" + name + ", product_code="
				+ product_code + ", product_name=" + product_name + ", price=" + price + ", amount=" + amount
				+ ", money=" + money + ", amt1=" + amt1 + ", amt2=" + amt2 + "]";
	}
	
	
	
	
}
