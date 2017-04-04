package com.bwie.test.database;

public class Person {
	private int id;
	private String name;
	private String phone;
	private String mima;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMima() {
		return mima;
	}

	public void setMima(String mima) {
		this.mima = mima;
	}

	public Person(int id, String name, String phone, String mima) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.mima = mima;
	}

	public Person() {
		super();
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", phone=" + phone
				+ ", mima=" + mima + "]";
	}

}
