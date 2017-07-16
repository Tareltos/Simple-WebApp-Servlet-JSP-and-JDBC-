package org.myprj.beans;

public class Product {
	
	private String code;
	private String part_name;
	private String group;
	private String brand;
	private double discount;
	private double opt_price;
	private double rzn_price;
	
	
	public Product() {
	
	}
	public Product(String code, String part_name, String group, String brand, double discount, double opt_price,
			double rzn_price) {
	
		this.code = code;
		this.part_name = part_name;
		this.group = group;
		this.brand = brand;
		this.discount = discount;
		this.opt_price = opt_price;
		this.rzn_price = rzn_price;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPart_name() {
		return part_name;
	}
	public void setPart_name(String part_name) {
		this.part_name = part_name;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getOpt_price() {
		return opt_price;
	}
	public void setOpt_price(double opt_price) {
		this.opt_price = opt_price;
	}
	public double getRzn_price() {
		return rzn_price;
	}
	public void setRzn_price(double rzn_price) {
		this.rzn_price = rzn_price;
	}
	
	
}
