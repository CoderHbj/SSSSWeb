package com.SSSSWeb.control;

import java.util.List;

import com.SSSSWeb.model.business.service.GoodsService;
import com.SSSSWeb.model.domain.GOODS_INF;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AccessoryManagerAction extends ActionSupport implements
		ModelDriven<GOODS_INF> {

	/**  */
	private static final long serialVersionUID = 1L;
	private List aclist;
	private int pageSize = 2;
	private int pageNow = 1;
	private int pageNum;
	private GOODS_INF goods = new GOODS_INF();
	private GoodsService service;
	private String id;
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List getAclist() {
		return aclist;
	}

	public void setAclist(List aclist) {
		this.aclist = aclist;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public GOODS_INF getGoods() {
		return goods;
	}

	public void setGoods(GOODS_INF goods) {
		this.goods = goods;
	}

	public GoodsService getService() {
		return service;
	}

	public void setService(GoodsService service) {
		this.service = service;
	}

	public String getId() {
		return id;
	}

	public void setId(String iD) {
		id = iD;
	}

	public String getAllAc() {
		String value = null;
		aclist = service.SelectAllDetialGoods(pageSize,pageNow);
		pageNum = service.PageNum(pageSize, value);
		return SUCCESS;
	}

	public String addAc() {
		service.addAc(goods);
		return SUCCESS;
	}

	public String deleteAc() {
		service.deleteAc(Integer.parseInt(id));
		return SUCCESS;
	}

	public String modifyAc() {
		service.modifyAc(goods);
		return SUCCESS;
	}

	@Override
	public GOODS_INF getModel() {
		return goods;
	}
}
