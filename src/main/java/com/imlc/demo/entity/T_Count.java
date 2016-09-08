package com.imlc.demo.entity;


public class T_Count {
	private T_Customer CustomerID ;
	private T_Model ModelID;
	private String BorrowNumber;	
	
	public T_Customer getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(T_Customer customerID) {
		CustomerID = customerID;
	}
	public T_Model getModelID() {
		return ModelID;
	}
	public void setModelID(T_Model modelID) {
		ModelID = modelID;
	}
	public String getBorrowNumber() {
		return BorrowNumber;
	}
	public void setBorrowNumber(String borrowNumber) {
		BorrowNumber = borrowNumber;
	}
	@Override
	public String toString() {
		return "T_Count [CustomerID=" + CustomerID + ", ModelID=" + ModelID + ", BorrowNumber=" + BorrowNumber + "]";
	}
	
}
