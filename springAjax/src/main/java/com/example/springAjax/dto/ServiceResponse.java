package com.example.springAjax.dto;

public class ServiceResponse<T> {

	private String Status;
	private T data;
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public ServiceResponse(String status, T data) {
		super();
		Status = status;
		this.data = data;
	}
	public ServiceResponse() {
		
	}
	@Override
	public String toString() {
		return "ServiceResponse [Status=" + Status + ", data=" + data + "]";
	}
	
	
}
