package com.SSSSWeb.model.business.service;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import com.SSSSWeb.model.business.dao.GoodsDAO;
import com.SSSSWeb.model.domain.GOODS_INF;
import com.SSSSWeb.model.domain.GoodsDetial;

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
	public int PageNum(int pageSize, String value) {
		int pageNum = goodsDAO.PageNum(pageSize, value);
		return pageNum;
	}

	@Transactional
	public ArrayList<GoodsDetial> SelectGoods(String chn_name) {

		ArrayList su = goodsDAO.SelectGoods(chn_name);
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
	public ArrayList<GoodsDetial> SelectAllDetialGoods(int pageSize, int pageNow) {
		ArrayList su = goodsDAO.SelectAllDetialGoods(pageSize,pageNow);
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
			to.setQuantity(Integer.valueOf(obj[13].toString()));
			reslist.add(to);
		}
		return reslist;
	}
//	public ArrayList<GOODS_INF> getAllAc(int pageSize, int pageNow) {
//		ArrayList list = goodsDAO.getAllAccessory(pageSize, pageNow);
//		ArrayList resultList = new ArrayList();
//		for (int i = 0; i < list.size(); i++) {
//			Object[] obj = (Object[]) list.get(i);
//			GOODS_INF ac = new GOODS_INF();
//			System.out.println(obj[0].toString());
//			ac.setId(Integer.valueOf(obj[0].toString()));
//			ac.setCode(obj[1].toString());
//			ac.setChn_name(obj[2].toString());
//			ac.setEng_name(obj[3].toString());
//			ac.setStandard(obj[4].toString());
//			ac.setPlace(obj[5].toString());
//			ac.setBrand(obj[6].toString());
//			// ac.setProvider(Integer.valueOf(obj[7].toString()));
//			// ac.setPrice(Integer.valueOf(obj[8].toString()));
//			ac.setPrice(100);
//			ac.setText(obj[9].toString());
//			resultList.add(ac);
//		}
//		return resultList;
//	}
	
	//查询配件
	

	// 新增配件
	@Transactional
	public int addAc(GOODS_INF goods) {
		int i = goodsDAO.insertAccessory(goods);
		return i;
	}

	// 删除配件
	public void deleteAc(int ID) {
		goodsDAO.deleteAccessory(ID);
	}

	// 修改配件
	@Transactional
	public void modifyAc(GOODS_INF goods) {
		goodsDAO.updateAccessory(goods);
	}
}
