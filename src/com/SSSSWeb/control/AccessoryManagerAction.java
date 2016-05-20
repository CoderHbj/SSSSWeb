package com.SSSSWeb.control;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.SSSSWeb.model.business.service.GoodsService;
import com.SSSSWeb.model.business.service.SupplierService;
import com.SSSSWeb.model.domain.GoodsDetial;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AccessoryManagerAction extends ActionSupport implements
		ModelDriven<GoodsDetial>,SessionAware {

	/**  */
	
	private static final long serialVersionUID = 1L;
	private List aclist;
	private List suplist;
//	private int pageSize = 2;
//	private int pageNow = 1;
//	private int pageNum;
	private GoodsDetial goods = new GoodsDetial();
	private GoodsService service;
	private SupplierService supservice;
	private Map<String, Object> session;
	private String id;
	private String key;

	public List getAclist() {
		return aclist;
	}

	public void setAclist(List aclist) {
		this.aclist = aclist;
	}

	public List getSuplist() {
		return suplist;
	}

	public void setSuplist(List suplist) {
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

	public Map<String, Object> getSession() {
        return session;
    }
	
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

	public SupplierService getSupservice() {
		return supservice;
	}

	public void setSupservice(SupplierService supservice) {
		this.supservice = supservice;
	}

	public String getAllAc() {
		aclist = service.getAllAc();
		suplist = supservice.SelectSupplier();
		return SUCCESS;
	}
	
	public String getAc() {
		aclist = service.getAc(key);
		return SUCCESS;
	}
	
	public String getOneAc() {
		HttpServletRequest request=ServletActionContext.getRequest();
		id = request.getParameter("id");
		System.out.println(id);
		goods = service.getOneAc(Integer.parseInt(id));
		return SUCCESS;
	}

	public String addAc() {
		service.addAc(goods);
		return SUCCESS;
	}

	public String deleteAc() {
		HttpServletRequest request=ServletActionContext.getRequest();
		id = request.getParameter("id");
		System.out.println(id);
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
