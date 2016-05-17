package com.SSSSWeb.control;

import java.util.List;

import com.SSSSWeb.model.business.service.GoodsService;
import com.SSSSWeb.model.domain.GOODS_INF;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AccessoryManagerAction extends ActionSupport implements
		ModelDriven<GOODS_INF> {

	private GoodsService service;
	private GOODS_INF goods;
	private List<GOODS_INF> aclist;
	private String ID;

	public GoodsService getService() {
		return service;
	}

	public void setService(GoodsService service) {
		this.service = service;
	}

	public GOODS_INF getGoods() {
		return goods;
	}

	public void setGoods(GOODS_INF goods) {
		this.goods = goods;
	}

	public List<GOODS_INF> getAclist() {
		return aclist;
	}

	public void setAclist(List<GOODS_INF> aclist) {
		this.aclist = aclist;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	@Override
	public GOODS_INF getModel() {
		return null;
	}

	public String getAllAc() {
		aclist = service.getAllAc();
		return SUCCESS;
	}

	public String addAc() {
		service.addAc(goods);
		return SUCCESS;
	}

	public String deleteAc() {
		service.deleteAc(Integer.parseInt(ID));
		return SUCCESS;
	}

	public String modifyAc() {
		service.modifyAc(goods);
		return SUCCESS;
	}
}
