package com.imlc.demo.entity;

import java.util.Date;

import com.imlc.demo.entity.T_Customer;
import com.imlc.demo.entity.T_Model;
import com.imlc.demo.entity.T_User;
import com.imlc.demo.exception.MsgException;

public class T_BorrowRecord {
	private Integer BorrowNo;
	private T_Customer CustomerID ;
	private String SendDatetime;
	private T_User BorrowPermitPerson;
	private T_User BorrowOperator;
	private Date BorrowOperatDatetime;
	private String PlanReturnDatetime;
	private T_Model ModelID;
	private String BorrowNumber;
	private String BorrowCheckNo;
	private Date ReturnDatetime;
	private T_User ReturnOperator;

	public T_BorrowRecord(){
		
	}
	
	
	
	public T_BorrowRecord(Integer borrowNo, T_Customer customerID, String sendDatetime, T_User borrowPermitPerson,
			T_User borrowOperator, Date borrowOperatDatetime, String planReturnDatetime, T_Model modelID,
			String borrowNumber, String borrowCheckNo, Date returnDatetime, T_User returnOperator) {
		//super();
		BorrowNo = borrowNo;
		CustomerID = customerID;
		SendDatetime = sendDatetime;
		BorrowPermitPerson = borrowPermitPerson;
		BorrowOperator = borrowOperator;
		BorrowOperatDatetime = borrowOperatDatetime;
		PlanReturnDatetime = planReturnDatetime;
		ModelID = modelID;
		BorrowNumber = borrowNumber;
		BorrowCheckNo = borrowCheckNo;
		ReturnDatetime = returnDatetime;
		ReturnOperator = returnOperator;
	}



	public Integer getBorrowNo() {
		return BorrowNo;
	}

	public void setBorrowNo(Integer borrowNo) {
		BorrowNo = borrowNo;
	}

	public T_Customer getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(T_Customer customerID) {
		CustomerID = customerID;
	}

	public String getSendDatetime() {
		return SendDatetime;
	}

	public void setSendDatetime(String sendDatetime) {
		SendDatetime = sendDatetime;
	}

	public T_User getBorrowPermitPerson() {
		return BorrowPermitPerson;
	}

	public void setBorrowPermitPerson(T_User borrowPermitPerson) {
		BorrowPermitPerson = borrowPermitPerson;
	}

	public T_User getBorrowOperator() {
		return BorrowOperator;
	}

	public void setBorrowOperator(T_User borrowOperator) {
		BorrowOperator = borrowOperator;
	}

	public Date getBorrowOperatDatetime() {
		return BorrowOperatDatetime;
	}

	public void setBorrowOperatDatetime(Date borrowOperatDatetime) {
		BorrowOperatDatetime = borrowOperatDatetime;
	}

	public String getPlanReturnDatetime() {
		return PlanReturnDatetime;
	}

	public void setPlanReturnDatetime(String planReturnDatetime) {
		PlanReturnDatetime = planReturnDatetime;
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

	public String getBorrowCheckNo() {
		return BorrowCheckNo;
	}

	public void setBorrowCheckNo(String borrowCheckNo) {
		BorrowCheckNo = borrowCheckNo;
	}

	public Date getReturnDatetime() {
		return ReturnDatetime;
	}

	public void setReturnDatetime(Date returnDatetime) {
		ReturnDatetime = returnDatetime;
	}

	public T_User getReturnOperator() {
		return ReturnOperator;
	}

	public void setReturnOperator(T_User returnOperator) {
		ReturnOperator = returnOperator;
	}

	@Override
	public String toString() {
		return "BorrowRecord [BorrowNo=" + BorrowNo + ", CustomerID=" + CustomerID + ", SendDatetime=" + SendDatetime
				+ ", BorrowPermitPerson=" + BorrowPermitPerson + ", BorrowOperator=" + BorrowOperator
				+ ", BorrowOperatDatetime=" + BorrowOperatDatetime + ", PlanReturnDatetime=" + PlanReturnDatetime
				+ ", ModelID=" + ModelID + ", BorrowNumber=" + BorrowNumber + ", BorrowCheckNo=" + BorrowCheckNo
				+ ", ReturnDatetime=" + ReturnDatetime + ", ReturnOperator=" + ReturnOperator + "]";
	}
	
	public void checkValue() throws MsgException{
		if(CustomerID==null || "".equals(CustomerID)){
			throw new MsgException("客户ID不能为空!");
		}
		if(SendDatetime==null || "".equals(SendDatetime)){
			throw new MsgException("发货时间不能为空!");
		}
		if(BorrowPermitPerson==null || "".equals(BorrowPermitPerson)){
			throw new MsgException("批准人不能为空!");
		}
		if(BorrowOperator==null || "".equals(BorrowOperator)){
			throw new MsgException("借机操作员不能为空!");
		}
		/*if(BorrowOperatDatetime==null || "".equals(BorrowOperatDatetime)){
			throw new MsgException("操作时间不能为空!");
		}*/
		if(PlanReturnDatetime==null || "".equals(PlanReturnDatetime)){
			throw new MsgException("预计归还时间不能为空!");
		}
		if(ModelID==null || "".equals(ModelID)){
			throw new MsgException("样机ID不能为空!");
		}
		if(BorrowNumber==null || "".equals(BorrowNumber)){
			throw new MsgException("借机数量不能为空!");
		}
		if(BorrowCheckNo==null || "".equals(BorrowCheckNo)){
			throw new MsgException("借条编号不能为空!");
		}
		if(!SendDatetime.matches("(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)")){
			throw new MsgException("发货时间的日期格式不正确!YYYY-MM-DD");
		}
		if(!PlanReturnDatetime.matches("(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)")){
			throw new MsgException("预计归还时间的日期格式不正确!YYYY-MM-DD");
		}
	}

}

