package com.example.project.model.product;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class ProductDTO {
	private int product_code; //상품분류번호
	private String product_name; //상품아이디
	private int money; //원가
	private int price; //판매가
	private String description; //상품설명
	private int amount; //재고량
	private Date stockup; //입고일자
	private String coupon; //쿠폰가능여부
	private String filename; //파일이름
	private int views; //조회수
	private int likes; //좋아요수
	private int sales_volume; //판매량
	private MultipartFile file1; //상품이미지명
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
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getStockup() {
		return stockup;
	}
	public void setStockup(Date stockup) {
		this.stockup = stockup;
	}
	public String getCoupon() {
		return coupon;
	}
	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getSales_volume() {
		return sales_volume;
	}
	public void setSales_volume(int sales_volume) {
		this.sales_volume = sales_volume;
	}
	public MultipartFile getFile1() {
		return file1;
	}
	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}
	@Override
	public String toString() {
		return "ProductDTO [product_code=" + product_code + ", product_name=" + product_name + ", money=" + money
				+ ", price=" + price + ", description=" + description + ", amount=" + amount + ", stockup=" + stockup
				+ ", coupon=" + coupon + ", filename=" + filename + ", views=" + views + ", likes=" + likes
				+ ", sales_volume=" + sales_volume + ", file1=" + file1 + "]";
	}
	
	
	
}
