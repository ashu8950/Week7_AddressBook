package com.example.address_book.dto;

import java.time.LocalTime;



public class Response {
	
	private String status;
	private String message;
	private Object data;
	private LocalTime time;
	public Response(String string, String string2,Object data, LocalTime now) {
		// TODO Auto-generated constructor stub
		this.setStatus(string);
		this.setMessage(string2);
		this.setTime(now);
		this.setData(data);
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
