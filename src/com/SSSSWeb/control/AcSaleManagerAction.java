package com.SSSSWeb.control;

import com.opensymphony.xwork2.ActionSupport;

public class AcSaleManagerAction extends ActionSupport {

	//获取所有销售单
	public String getAllSaleList(){
		return SUCCESS;
	}
	
	//获取所有待审核销售单
	public String getUncheckedSaleList(){
		return SUCCESS;
	}
	
	//审核销售单
	public String checkAc(){
		return SUCCESS;
	}
	
	//获取所有订货单
	public String getAllSubList(){
		return SUCCESS;
	}
	
	//获取所有未签收订货单
	public String getUncheckedSubList(){
		return SUCCESS;
	}
	
	//签收订货单
	public String checkSub(){
		return SUCCESS;
	}
}
