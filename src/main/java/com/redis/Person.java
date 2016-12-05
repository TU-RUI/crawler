package com.redis;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = -5428470312985357852L;
	
	private String name;
	private String age;
	private String sex;
	
	public Person(String name, String age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}
