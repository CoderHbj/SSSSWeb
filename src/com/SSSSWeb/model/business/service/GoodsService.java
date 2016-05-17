package com.SSSSWeb.model.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.SSSSWeb.model.business.dao.GoodsDAO;
import com.SSSSWeb.model.domain.GOODS_INF;
import com.SSSSWeb.model.domain.GoodsDetial;
import com.SSSSWeb.model.domain.Supplier;


public class GoodsService {

	private static int DONE = 1;
	private static int FAIL = 0;
	private GoodsDAO goodsDAO;

	public GoodsDAO getGoodsDAO() {
		return goodsDAO;
	}

	public void setGoodsDAO(GoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}
	
	@Transactional
	public ArrayList<GoodsDetial> SelectGoods(String chn_name) {
		
			ArrayList su=goodsDAO.SelectGoods(chn_name);
			ArrayList reslist = new ArrayList();
			for(int i=0;i<su.size();i++){
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
		ArrayList su=goodsDAO.SelectDetialGoods(id);
		ArrayList reslist = new ArrayList();
		for(int i=0;i<su.size();i++){
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
	
	//查询所有配件
	@Transactional
	public ArrayList<GOODS_INF> getAllAc(){
		return goodsDAO.getAllAccessory();
	}
	
	//新增配件
	@Transactional
	public void addAc(GOODS_INF goods) {
		goodsDAO.insertAccessory(goods);
	}
	
	//删除配件
	public void deleteAc(int ID){
		goodsDAO.deleteAccessory(ID);
	}
	
	//修改配件
	@Transactional
	public void modifyAc(GOODS_INF goods) {
		goodsDAO.updateAccessory(goods);
	}
}
