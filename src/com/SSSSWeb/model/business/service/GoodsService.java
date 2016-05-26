package com.SSSSWeb.model.business.service;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import com.SSSSWeb.model.business.dao.GoodsDAO;
import com.SSSSWeb.model.business.dao.StockDAO;
import com.SSSSWeb.model.domain.GOODS_INF;
import com.SSSSWeb.model.domain.GoodsDetial;
import com.SSSSWeb.model.domain.STOCK_INF;

public class GoodsService {
	private GoodsDAO goodsDAO;
	private StockDAO stockDAO;

	public GoodsDAO getGoodsDAO() {
		return goodsDAO;
	}

	public void setGoodsDAO(GoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}

	public StockDAO getStockDAO() {
		return stockDAO;
	}

	public void setStockDAO(StockDAO stockDAO) {
		this.stockDAO = stockDAO;
	}
	
	@Transactional
    public int PageNum(int pageSize, String value){
        int pageNum = goodsDAO.PageNum(pageSize, value);
        return pageNum;
    }

	@Transactional
	public ArrayList<GoodsDetial> SelectGoods(String chn_name) {
		ArrayList su = goodsDAO.SelectGoods(chn_name);
		ArrayList<GoodsDetial> reslist = new ArrayList<GoodsDetial>();
		for (int i = 0; i < su.size(); i++) {
			Object[] obj = (Object[]) su.get(i);
			GoodsDetial to = new GoodsDetial();
			to.setId(Integer.valueOf(obj[0].toString()));
			to.setCode(obj[1].toString());
			to.setChn_name(obj[2].toString());
			to.setEng_name(obj[3].toString());
			to.setType(obj[4].toString());
			to.setColor(obj[5].toString());
			to.setStandard(obj[6].toString());
			to.setDisplacement(obj[7].toString());
			to.setPlace(obj[8].toString());
			to.setBrand(obj[9].toString());
			to.setProvider(Integer.valueOf(obj[10].toString()));
			to.setPrice(Integer.valueOf(obj[11].toString()));
			to.setText(obj[12].toString());
			to.setImg(obj[13].toString());
			to.setQuantity(Integer.valueOf(obj[14].toString()));
			to.setNum(Integer.valueOf(obj[15].toString()));
			reslist.add(to);
		}
		return reslist;
	}

	@Transactional
	public ArrayList<GoodsDetial> SelectDetialGoods(int id) {
		ArrayList su = goodsDAO.SelectDetialGoods(id);
		ArrayList reslist = new ArrayList();
		for (int i = 0; i < su.size(); i++) {
			Object[] obj = (Object[]) su.get(i);
			GoodsDetial to = new GoodsDetial();
			to.setId(Integer.valueOf(obj[0].toString()));
			to.setCode(obj[1].toString());
			to.setChn_name(obj[2].toString());
			to.setEng_name(obj[3].toString());
			to.setType(obj[4].toString());
			to.setColor(obj[5].toString());
			to.setStandard(obj[6].toString());
			to.setDisplacement(obj[7].toString());
			to.setPlace(obj[8].toString());
			to.setBrand(obj[9].toString());
			to.setProvider(Integer.valueOf(obj[10].toString()));
			to.setPrice(Integer.valueOf(obj[11].toString()));
			to.setText(obj[12].toString());
			to.setImg(obj[13].toString());
			to.setQuantity(Integer.valueOf(obj[14].toString()));
			to.setNum(Integer.valueOf(obj[15].toString()));
			reslist.add(to);
		}
		return reslist;
	}

	// 查询所有配件
	@Transactional
	public ArrayList<GoodsDetial> getAllAc(int pageSize,int pageNow) {
		ArrayList su = goodsDAO.getAllAccessory(pageSize,pageNow);
		ArrayList reslist = new ArrayList();
		for (int i = 0; i < su.size(); i++) {
			Object[] obj = (Object[]) su.get(i);
			GoodsDetial to = new GoodsDetial();
			to.setId(Integer.valueOf(obj[0].toString()));
			to.setCode(obj[1].toString());
			to.setChn_name(obj[2].toString());
			to.setEng_name(obj[3].toString());
			to.setType(obj[4].toString());
			// to.setColor(obj[5].toString());
			to.setStandard(obj[6].toString());
			// to.setDisplacement(obj[7].toString());
			to.setPlace(obj[8].toString());
			to.setBrand(obj[9].toString());
			to.setProvider(Integer.valueOf(obj[10].toString()));
			to.setPrice(Integer.valueOf(obj[11].toString()));
			to.setText(obj[12].toString());
			to.setQuantity(Integer.valueOf(obj[13].toString()));
			reslist.add(to);
		}
		return reslist;
	}

	@Transactional
	public ArrayList<GoodsDetial> getAllAc_2() {
		ArrayList su = goodsDAO.getAllAccessory_2();
		ArrayList reslist = new ArrayList();
		for (int i = 0; i < su.size(); i++) {
			Object[] obj = (Object[]) su.get(i);
			GoodsDetial to = new GoodsDetial();
			to.setId(Integer.valueOf(obj[0].toString()));
			to.setCode(obj[1].toString());
			to.setChn_name(obj[2].toString());
			to.setEng_name(obj[3].toString());
			to.setType(obj[4].toString());
			// to.setColor(obj[5].toString());
			to.setStandard(obj[6].toString());
			// to.setDisplacement(obj[7].toString());
			to.setPlace(obj[8].toString());
			to.setBrand(obj[9].toString());
			to.setProvider(Integer.valueOf(obj[10].toString()));
			to.setPrice(Integer.valueOf(obj[11].toString()));
			to.setText(obj[12].toString());
			to.setQuantity(Integer.valueOf(obj[13].toString()));
			reslist.add(to);
		}
		return reslist;
	}
	
	// 查询配件
	public ArrayList<GoodsDetial> getAc(String chn_name) {
		ArrayList su = goodsDAO.getAccessory(chn_name);
		ArrayList reslist = new ArrayList();
		for (int i = 0; i < su.size(); i++) {
			Object[] obj = (Object[]) su.get(i);
			GoodsDetial to = new GoodsDetial();
			to.setId(Integer.valueOf(obj[0].toString()));
			to.setCode(obj[1].toString());
			to.setChn_name(obj[2].toString());
			to.setEng_name(obj[3].toString());
			to.setType(obj[4].toString());
			// to.setColor(obj[5].toString());
			to.setStandard(obj[6].toString());
			// to.setDisplacement(obj[7].toString());
			to.setPlace(obj[8].toString());
			to.setBrand(obj[9].toString());
			to.setProvider(Integer.valueOf(obj[10].toString()));
			to.setPrice(Integer.valueOf(obj[11].toString()));
			to.setText(obj[12].toString());
			to.setQuantity(Integer.valueOf(obj[13].toString()));
			reslist.add(to);
		}
		return reslist;
	}

	// 通过ID查询一个配件
	public GoodsDetial getOneAc(int id) {
		GOODS_INF ac = goodsDAO.getGoodsById(id);
		STOCK_INF stock = stockDAO.getStockByGoodsId(id);
		GoodsDetial to = new GoodsDetial();
		to.setId(ac.getId());
		to.setCode(ac.getCode());
		to.setChn_name(ac.getChn_name());
		to.setEng_name(ac.getEng_name());
		to.setType(ac.getType());
		to.setColor(ac.getColor());
		to.setStandard(ac.getStandard());
		to.setDisplacement(ac.getDisplacement());
		to.setPlace(ac.getPlace());
		to.setBrand(ac.getBrand());
		to.setProvider(ac.getProvider());
		to.setPrice(ac.getPrice());
		to.setText(ac.getText());
		to.setQuantity(stock.getQuantity());
		return to;
	}

	// 新增配件
	@Transactional
	public void addAc(GoodsDetial goods) {
		GOODS_INF accessory = new GOODS_INF();
		accessory.setCode(goods.getCode());
		accessory.setChn_name(goods.getChn_name());
		accessory.setEng_name(goods.getEng_name());
		accessory.setType("2");
		accessory.setStandard(goods.getStandard());
		accessory.setPlace(goods.getPlace());
		accessory.setBrand(goods.getBrand());
		accessory.setProvider(goods.getProvider());
		accessory.setPrice(goods.getPrice());
		accessory.setText(goods.getText());
		goodsDAO.insertAccessory(accessory);

		int goods_id = goodsDAO.getGoodsByCode(goods.getCode()).getId();
		STOCK_INF stock = new STOCK_INF();
		stock.setGoods_id(goods_id);
		stock.setQuantity(goods.getQuantity());
		stockDAO.insertStock(stock);
	}

	// 删除配件
	public void deleteAc(int ID) {
		STOCK_INF stock = stockDAO.getStockByGoodsId(ID);
		goodsDAO.deleteAccessory(ID);
		stockDAO.deleteStock(stock.getId());
	}

	// 修改配件
	@Transactional
	public void modifyAc(GoodsDetial goods) {
		GOODS_INF accessory = goodsDAO.getGoodsById(goods.getId());
		accessory.setCode(goods.getCode());
		accessory.setChn_name(goods.getChn_name());
		accessory.setEng_name(goods.getEng_name());
		accessory.setStandard(goods.getStandard());
		accessory.setPlace(goods.getPlace());
		accessory.setBrand(goods.getBrand());
		accessory.setProvider(goods.getProvider());
		accessory.setPrice(goods.getPrice());
		accessory.setText(goods.getText());
		STOCK_INF stock = stockDAO.getStockByGoodsId(goods.getId());
		stock.setQuantity(goods.getQuantity());
		goodsDAO.updateAccessory(accessory);
		stockDAO.updateStock(stock);
	}

	// 查询所有车辆
	@Transactional
	public ArrayList<GoodsDetial> SelectAllCar() {
		ArrayList su = goodsDAO.SelectAllCar();
		ArrayList reslist = new ArrayList();
		for (int i = 0; i < su.size(); i++) {
			Object[] obj = (Object[]) su.get(i);
			GoodsDetial to = new GoodsDetial();
			to.setId(Integer.valueOf(obj[0].toString()));
			to.setCode(obj[1].toString());
			to.setChn_name(obj[2].toString());
			to.setEng_name(obj[3].toString());
			to.setColor(obj[4].toString());
			to.setDisplacement(obj[5].toString());
			to.setPlace(obj[6].toString());
			to.setBrand(obj[7].toString());
			to.setProvider(Integer.valueOf(obj[8].toString()));
			to.setPrice(Integer.valueOf(obj[9].toString()));
			to.setQuantity(Integer.valueOf(obj[10].toString()));
			reslist.add(to);
		}
		return reslist;
	}

	// 查询车辆
	@Transactional
	public ArrayList<GoodsDetial> SelectCar(String chn_name) {

		ArrayList su = goodsDAO.SelectCar(chn_name);
		ArrayList reslist = new ArrayList();
		for (int i = 0; i < su.size(); i++) {
			Object[] obj = (Object[]) su.get(i);
			GoodsDetial to = new GoodsDetial();
			to.setId(Integer.valueOf(obj[0].toString()));
			to.setCode(obj[1].toString());
			to.setChn_name(obj[2].toString());
			to.setEng_name(obj[3].toString());
			to.setColor(obj[4].toString());
			to.setDisplacement(obj[5].toString());
			to.setPlace(obj[6].toString());
			to.setBrand(obj[7].toString());
			to.setProvider(Integer.valueOf(obj[8].toString()));
			to.setPrice(Integer.valueOf(obj[9].toString()));
			to.setQuantity(Integer.valueOf(obj[10].toString()));
			reslist.add(to);
		}
		return reslist;
	}

	// 查询车辆BY ID
	@Transactional
	public ArrayList<GoodsDetial> SelectCarByID(int id) {
		ArrayList su = goodsDAO.SelectCarByID(id);
		ArrayList reslist = new ArrayList();
		for (int i = 0; i < su.size(); i++) {
			Object[] obj = (Object[]) su.get(i);
			GoodsDetial to = new GoodsDetial();
			to.setId(Integer.valueOf(obj[0].toString()));
			to.setCode(obj[1].toString());
			to.setChn_name(obj[2].toString());
			to.setEng_name(obj[3].toString());
			to.setColor(obj[4].toString());
			to.setDisplacement(obj[5].toString());
			to.setPlace(obj[6].toString());
			to.setBrand(obj[7].toString());
			to.setProvider(Integer.valueOf(obj[8].toString()));
			to.setPrice(Integer.valueOf(obj[9].toString()));
			to.setQuantity(Integer.valueOf(obj[10].toString()));
			reslist.add(to);
		}
		return reslist;
	}

	// 修改车辆
	@Transactional
	public void UpdateCar(GoodsDetial goods) {
		GOODS_INF car = goodsDAO.getGoodsById(goods.getId());
		car.setId(goods.getId());
		car.setCode(goods.getCode());
		car.setChn_name(goods.getChn_name());
		car.setEng_name(goods.getEng_name());
		car.setColor(goods.getColor());
		car.setPlace(goods.getPlace());
		car.setBrand(goods.getBrand());
		car.setProvider(goods.getProvider());
		car.setPrice(goods.getPrice());
		car.setText(goods.getText());
		STOCK_INF stock = stockDAO.getStockByGoodsId(goods.getId());
		stock.setQuantity(goods.getQuantity());
		goodsDAO.UpdateCar(car);
		stockDAO.updateStock(stock);
	}

	// 删除车辆
	@Transactional
	public void DeleteCar(int CarId) {
		// TODO Auto-generated method stub
		goodsDAO.DeleteCar(CarId);
	}

	// 新增车辆
	@Transactional
	public void AddCar(GoodsDetial goods) {
		GOODS_INF car = new GOODS_INF();
		car.setCode(goods.getCode());
		car.setChn_name(goods.getChn_name());
		car.setEng_name(goods.getEng_name());
		car.setType("1");
		car.setColor(goods.getColor());
		car.setDisplacement(goods.getDisplacement());
		car.setPlace(goods.getPlace());
		car.setBrand(goods.getBrand());
		car.setProvider(goods.getProvider());
		car.setPrice(goods.getPrice());
		car.setText(goods.getText());
		goodsDAO.insertCar(car);
		int goods_id = goodsDAO.getCarByCode(goods.getCode()).getId();
		STOCK_INF stock = new STOCK_INF();
		stock.setGoods_id(goods_id);
		stock.setQuantity(goods.getQuantity());
		stockDAO.insertStock(stock);
	}
}
