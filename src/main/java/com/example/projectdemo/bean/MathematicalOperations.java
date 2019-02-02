package com.example.projectdemo.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MathematicalOperations implements Serializable {

	private static final long serialVersionUID = -7196980686123761979L;
	private String description;
	private int code;
	private List<String> list = new ArrayList<>();

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

}