package com.lhy.fool.admin.person.controller.supplier;

import java.util.List;

public class Point{
	/**
	  * 子公司
	  */
	 private String subsidiary;
	
	 /**
	  * 账期
	  */
	 private String accountPeriond;
	
	 /**
	  * 网点编号组
	  */
	 private List<String> pointCodes;

	public String getSubsidiary() {
		return subsidiary;
	}

	public void setSubsidiary(String subsidiary) {
		this.subsidiary = subsidiary;
	}

	public String getAccountPeriond() {
		return accountPeriond;
	}

	public void setAccountPeriond(String accountPeriond) {
		this.accountPeriond = accountPeriond;
	}

	public List<String> getPointCodes() {
		return pointCodes;
	}

	public void setPointCodes(List<String> pointCodes) {
		this.pointCodes = pointCodes;
	}

	
	
	@Override
	public String toString() {
		return "Point [subsidiary=" + subsidiary + ", accountPeriond="
				+ accountPeriond + ", pointCodes=" + pointCodes + "]";
	}
	 
	 
}
