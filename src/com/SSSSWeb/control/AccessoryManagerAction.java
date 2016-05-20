package com.SSSSWeb.control;

import java.util.List;

import com.SSSSWeb.model.business.service.GoodsService;
import com.SSSSWeb.model.domain.GOODS_INF;
import com.SSSSWeb.model.domain.GoodsDetial;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AccessoryManagerAction extends ActionSupport implements
		ModelDriven<GoodsDetial> {

	/**  */
	private static final long serialVersionUID = 1L;
	private List aclist;
	private int pageSize = 2;
	private int pageNow = 1;
	private int pageNum;
	private GoodsDetial goods = new GoodsDetial();
	private GoodsService service;
	private String id;

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

	public GoodsDetial getGoods() {
		return goods;
	}

	public void setGoods(GoodsDetial goods) {
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

	public void setId(String id) {
		this.id = id;
	}

	public String getAllAc() {
		String value = null;
		aclist = service.SelectAllDetialGoods(pageSize, pageNow);
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
	public GoodsDetial getModel() {
		return goods;
	}

}
