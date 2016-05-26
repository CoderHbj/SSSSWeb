package com.SSSSWeb.control;

import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.SSSSWeb.model.business.service.ColorsService;
import com.SSSSWeb.model.business.service.GoodsService;
import com.SSSSWeb.model.business.service.SupplierService;
import com.SSSSWeb.model.domain.GoodsDetial;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CarManagerAction extends ActionSupport implements
		ModelDriven<GoodsDetial>, SessionAware {

	/**  */
	private static final long serialVersionUID = 1L;
	private List carlist;
	private List colorlist;
	private List cidlist;
	private List suplist;
	private String id;
	private String carid;
	private String chnName;
	private GoodsService service;
	private SupplierService supservice;
	private ColorsService colorsservice;
	private Map<String, Object> session;
	private GoodsDetial goods = new GoodsDetial();

	public SupplierService getSupservice() {
		return supservice;
	}

	public void setSupservice(SupplierService supservice) {
		this.supservice = supservice;
	}

	public String getCarid() {
		return carid;
	}

	public void setCarid(String carid) {
		this.carid = carid;
	}

	public List getSuplist() {
		return suplist;
	}

	public void setSuplist(List suplist) {
		this.suplist = suplist;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List getCarlist() {
		return carlist;
	}

	public void setCarlist(List carlist) {
		this.carlist = carlist;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getChnName() {
		return chnName;
	}

	public void setChnName(String chnName) {
		this.chnName = chnName;
	}

	public GoodsService getService() {
		return service;
	}

	public void setService(GoodsService service) {
		this.service = service;
	}

	public List getColorlist() {
		return colorlist;
	}

	public void setColorlist(List colorlist) {
		this.colorlist = colorlist;
	}

	public ColorsService getColorsservice() {
		return colorsservice;
	}

	public void setColorsservice(ColorsService colorsservice) {
		this.colorsservice = colorsservice;
	}

	public GoodsDetial getGoods() {
		return goods;
	}

	public void setGoods(GoodsDetial goods) {
		this.goods = goods;
	}

	public List getCidlist() {
		return cidlist;
	}

	public void setCidlist(List cidlist) {
		this.cidlist = cidlist;
	}

	public String SelectAllCar() {
		carlist = service.SelectAllCar();
		colorlist = colorsservice.SelectAllColor();
		suplist = supservice.SelectSupplier();
		return SUCCESS;
	}

	public String SelectCar() {
		carlist = service.SelectCar(chnName);
		return "success";
	}

	public String SelectCarByID() {
		HttpServletRequest request = ServletActionContext.getRequest();
		id = request.getParameter("id");
		cidlist = service.SelectCarByID(Integer.parseInt(id));
		return SUCCESS;
	}

	public String UpdateCar() {
		// cidlist = service.SelectCarByID(id);
		System.out.println(id);
		service.UpdateCar(goods);
		return SUCCESS;
	}

	public String DeleteCar() throws Exception {
		carid = carid.substring(2);
		StringTokenizer fenxi = new StringTokenizer(carid, ",");
		for (int i = 0; fenxi.hasMoreTokens(); i++) {
			String carid_str = fenxi.nextToken();
			int CarId = Integer.parseInt(carid_str);
			service.DeleteCar(CarId);
		}
		return "success";
	}

	@Override
	public GoodsDetial getModel() {
		return goods;
	}

	public String AddCar() {
		service.AddCar(goods);
		return SUCCESS;
	}

}
