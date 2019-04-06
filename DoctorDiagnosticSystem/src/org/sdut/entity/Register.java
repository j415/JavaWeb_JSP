package org.sdut.entity;

public class Register {
	private int id;
	private String name;
	private String pwd;
	
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Register() {
		
	}

	public Register(String name, String pwd) {
		this.name = name;
		this.pwd = pwd;
	}

	public Register(int id, String name, String pwd) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "Register [id=" + id + ", name=" + name + ", pwd=" + pwd + "]";
	}
	
	
	
	
	

}
