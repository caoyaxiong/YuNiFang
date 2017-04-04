package com.bwie.test.database;

public class ShangPing {
	private String name;
	private String imgurl;
	private String sid;
	private int count;
	private double price;
	private boolean flag;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public ShangPing(String name, String imgurl, String sid, int count, double price, boolean flag) {
		this.name = name;
		this.imgurl = imgurl;
		this.sid = sid;
		this.count = count;
		this.price = price;
		this.flag = flag;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public ShangPing( String name, String imgurl, String sid, int count, double price) {
		super();
		this.name = name;
		this.imgurl = imgurl;
		this.sid = sid;
		this.count = count;
		this.price = price;
	}
	public ShangPing() {
		super();
	}
	@Override
	public String toString() {
		return "ShangPing [name=" + name + ", imgurl=" + imgurl + ", sid=" + sid + ", count=" + count
				+ ", price=" + price + "]";
	}


}
