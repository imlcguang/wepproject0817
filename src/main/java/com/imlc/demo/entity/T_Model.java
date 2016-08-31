package com.imlc.demo.entity;

import com.imlc.demo.exception.MsgException;

public class T_Model {
	private Integer ModelID;
	private String ModelName;
	private String ModelVersion;
	private String ModelDesc;
	
	public T_Model(){
		
	}
	
	public T_Model(Integer modelID, String modelName, String modelVersion, String modelDesc) {
		//super();
		ModelID = modelID;
		ModelName = modelName;
		ModelVersion = modelVersion;
		ModelDesc = modelDesc;
	}

	public Integer getModelID() {
		return ModelID;
	}

	public void setModelID(Integer modelID) {
		ModelID = modelID;
	}

	public String getModelName() {
		return ModelName;
	}

	public void setModelName(String modelName) {
		ModelName = modelName;
	}

	public String getModelVersion() {
		return ModelVersion;
	}

	public void setModelVersion(String modelVersion) {
		ModelVersion = modelVersion;
	}

	public String getModelDesc() {
		return ModelDesc;
	}

	public void setModelDesc(String modelDesc) {
		ModelDesc = modelDesc;
	}

	@Override
	public String toString() {
		return "T_Model [ModelID=" + ModelID + ", ModelName=" + ModelName + ", ModelVersion=" + ModelVersion
				+ ", ModelDesc=" + ModelDesc + "]";
	}
	public void checkValue() throws MsgException{
		if(ModelName==null || "".equals(ModelName)){
			throw new MsgException("样机名称不能为空!");
		}
		if(ModelVersion==null || "".equals(ModelVersion)){
			throw new MsgException("样机版本不能为空!");
		}
	
	}
}
