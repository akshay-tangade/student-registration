package com.student.registration.util;

public class ResponseMessage<T> {
	int status;
	String statusText;
	T result;
    int totalElements;
	public ResponseMessage() {
		super();
	}
	public ResponseMessage(int status, String statusText, T result, int totalElements) {
		super();
		this.status = status;
		this.statusText = statusText;
		this.result = result;
		this.totalElements = totalElements;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStatusText() {
		return statusText;
	}
	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}
	public T getResult() {
		return result;
	}
	public void setResult(T result) {
		this.result = result;
	}
	public int getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(int totalElements) {
		this.totalElements = totalElements;
	}
	@Override
	public String toString() {
		return "ResponseMessage [status=" + status + ", statusText=" + statusText + ", result=" + result
				+ ", totalElements=" + totalElements + "]";
	}
    
}
