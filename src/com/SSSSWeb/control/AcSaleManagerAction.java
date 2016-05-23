package com.SSSSWeb.control;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.SSSSWeb.model.business.service.GoodsService;
import com.SSSSWeb.model.business.service.IndentService;
import com.SSSSWeb.model.business.service.OrdersService;
import com.SSSSWeb.model.domain.GoodsDetial;
import com.SSSSWeb.model.domain.Indent;
import com.SSSSWeb.model.domain.Orders_Info;
import com.SSSSWeb.model.domain.UncheckedSubList;
import com.opensymphony.xwork2.ActionSupport;
/*
 * 配件销售管理Action，包含销售信息和订货信息
 * 1、审核销售单
 * 2、填写订货单
 * 3、审核订货单
 * 4、查看销售单和订货单（无修改权限）
 * */
public class AcSaleManagerAction extends ActionSupport implements SessionAware{
	
	private OrdersService ordersService;
	private IndentService indentService;
	private GoodsService goodsService;
	private List<UncheckedSubList> uncheckedSubList;
	private List<Orders_Info> ucSaleList;
	private List<GoodsDetial> aclist;
	private Map<String, Object> session;
	private String id;
	private String goods_id;
	private String quantity;

	public OrdersService getOrdersService() {
		return ordersService;
	}

	public void setOrdersService(OrdersService ordersService) {
		this.ordersService = ordersService;
	}

	public IndentService getIndentService() {
		return indentService;
	}

	public void setIndentService(IndentService indentService) {
		this.indentService = indentService;
	}

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public List<UncheckedSubList> getUncheckedSubList() {
		return uncheckedSubList;
	}

	public void setUncheckedSubList(List<UncheckedSubList> uncheckedSubList) {
		this.uncheckedSubList = uncheckedSubList;
	}

	public List<GoodsDetial> getAclist() {
		return aclist;
	}

	public void setAclist(List<GoodsDetial> aclist) {
		this.aclist = aclist;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public List<Orders_Info> getUcSaleList() {
		return ucSaleList;
	}

	public void setUcSaleList(List<Orders_Info> ucSaleList) {
		this.ucSaleList = ucSaleList;
	}

	//获取所有未审核订单
	public String getUncheckedSaleList() throws ParseException{
		ucSaleList = ordersService.getUncheckedOrders();
		return SUCCESS;
	}
	
	//审核订单
	public String checkSaleList(){
		ordersService.checkOrders(Integer.parseInt(id));
		return SUCCESS;
	}
	
	//取消订单
	public String cancelSale(){
		ordersService.cancelSale(Integer.parseInt(id));
		return SUCCESS;
	}
	
	//获取所有未签收订货单
	public String getSubList(){
		aclist = goodsService.getAllAc();
		uncheckedSubList = indentService.getUncheckedSubList();
		return SUCCESS;
	}
	
	//填写订货单
	public String addIndent(){
		Indent indent = new Indent();
		indent.setGoods_id(Integer.parseInt(goods_id));
		indent.setQuantity(Integer.parseInt(quantity));
		indentService.add(indent);
		return SUCCESS;
	}
	
	//签收订货单
	public String checkSubList(){
		indentService.check(Integer.parseInt(id));
		return SUCCESS;
	}
}
