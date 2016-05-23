package com.SSSSWeb.control;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.SSSSWeb.model.business.service.GoodsService;
import com.SSSSWeb.model.business.service.SupplierService;
import com.SSSSWeb.model.domain.GoodsDetial;
import com.SSSSWeb.model.domain.Supplier;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/*
 * 配件基本信息维护Action（包含配件基本信息和库存信息）
 * 1、新配件入库
 * 2、删除配件
 * 3、更新配件信息
 * 4、查询配件信息
 * */
public class AccessoryManagerAction extends ActionSupport implements
		ModelDriven<GoodsDetial>,SessionAware {

	/**  */
	
	private static final long serialVersionUID = 1L;
	private List<GoodsDetial> aclist;
	private List<Supplier> suplist;
	private GoodsDetial goods = new GoodsDetial();
	private GoodsService service;
	private SupplierService supservice;
	private Map<String, Object> session;
	private String id;
	private String key;

	public List<GoodsDetial> getAclist() {
		return aclist;
	}

	public void setAclist(List<GoodsDetial> aclist) {
		this.aclist = aclist;
	}

	public List<Supplier> getSuplist() {
		return suplist;
	}

	public void setSuplist(List<Supplier> suplist) {
		this.suplist = suplist;
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

	public SupplierService getSupservice() {
		return supservice;
	}

	public void setSupservice(SupplierService supservice) {
		this.supservice = supservice;
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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	//获取所有配件信息
	public String getAllAc() {
		aclist = service.getAllAc();
		suplist = supservice.SelectSupplier();
		return SUCCESS;
	}
	
	//查询配件信息
	public String getAc() {
		aclist = service.getAc(key);
		return SUCCESS;
	}
	
	//通过ID查询一个配件
	public String getOneAc() {
		HttpServletRequest request=ServletActionContext.getRequest();
		id = request.getParameter("id");
		System.out.println(id);
		goods = service.getOneAc(Integer.parseInt(id));
		return SUCCESS;
	}

	//新增配件
	public String addAc() {
		service.addAc(goods);
		return SUCCESS;
	}

	//删除配件
	public String deleteAc() {
		HttpServletRequest request=ServletActionContext.getRequest();
		id = request.getParameter("id");
		System.out.println(id);
		service.deleteAc(Integer.parseInt(id));
		return SUCCESS;
	}

	//修改配件信息
	public String modifyAc() {
		service.modifyAc(goods);
		return SUCCESS;
	}

	@Override
	public GoodsDetial getModel() {
		return goods;
	}

}
