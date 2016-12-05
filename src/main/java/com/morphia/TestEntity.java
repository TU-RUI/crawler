package com.morphia;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity(value="testEntity")
public class TestEntity {
	@Id
	private ObjectId id;
	private String name;
	@Embedded
	private List<String> list;
	private int num;
	
	
	public TestEntity() {
		super();
	}

	public TestEntity(ObjectId id, String name, List<String> list, int num) {
		super();
		this.id = id;
		this.name = name;
		this.list = list;
		this.num = num;
	}
	
	public TestEntity(int num) {
		name = "abc";
		this.num = num;
		list = new ArrayList<String>();
		list.add("qwe");
		list.add("qaz");
		list.add("qqsx");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("id:");
		sb.append(id);
		sb.append(" , name:");
		sb.append(name);
		sb.append(" , list:{");
		for(String s:list){
			sb.append(s);
			sb.append(" , ");
		}
		sb.delete(sb.length()-2,sb.length());
		sb.append("} , num:");
		sb.append(num);
		return sb.toString();
	}
}
