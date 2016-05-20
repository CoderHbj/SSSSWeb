package com.SSSSWeb.model.business.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.SSSSWeb.model.domain.GOODS_INF;
import com.SSSSWeb.model.domain.GoodsDetial;
import com.SSSSWeb.model.domain.STOCK_INF;

public class GoodsDAO {

	private static int DONE = 1;
	private static int FAIL = 0;
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public ArrayList<GoodsDetial> SelectGoods(String chn_name) {
		Session session = sf.openSession();
		String hql = "select g.id,g.code,g.chn_name,g.eng_name,g.type,g.color,g.standard,g.displacement,g.place,g.brand,g.provider,g.price,g.text,c.url,s.quantity,sa.num"
				+ " from GOODS_INF g,CAR_IMG_INF c,STOCK_INF s,sale sa  "
				+ " where g.chn_name like '%"
				+ chn_name
				+ "%'"
				+ " and c.level=1 "
				+ " and g.id=c.goods_ID "
				+ " and g.id=sa.goods_ID " + " and g.id=s.goods_ID ";
		Query query = session.createSQLQuery(hql);
		ArrayList resultList = (ArrayList) query.list();
		session.close();
		return resultList;
	}

	public ArrayList<GoodsDetial> SelectDetialGoods(int id) {
		Session session = sf.openSession();
		String hql = "select g.id,g.code,g.chn_name,g.eng_name,g.type,g.color,g.standard,g.displacement,g.place,g.brand,g.provider,g.price,g.text,c.url,s.quantity,sa.num"
				+ " from GOODS_INF g,CAR_IMG_INF c,STOCK_INF s,sale sa  "
				+ " where g.id ="
				+ id
				+ " "
				+ " and g.id=c.goods_ID "
				+ " and g.id=sa.goods_ID " + " and g.id=s.goods_ID ";
		Query query = session.createSQLQuery(hql);
		ArrayList resultList = (ArrayList) query.list();
		session.close();
		return resultList;
	}

	// 查询所有配件
	public ArrayList<GoodsDetial> getAllAccessory() {
		Session session = sf.openSession();
		String hql = "select g.id,g.code,g.chn_name,g.eng_name,g.type,g.color,g.standard,g.displacement,g.place,g.brand,g.provider,g.price,g.text,s.quantity"
				+ " from GOODS_INF g,STOCK_INF s  "
				+ " where type='2'"
				+ " and g.id=s.goods_ID ";
		Query query = session.createSQLQuery(hql);
		ArrayList resultList = (ArrayList) query.list();
		session.close();
		return resultList;
	}

	// 查询配件
	public ArrayList<GOODS_INF> getAccessory(String chnName) {
		Session session = sf.openSession();
		String hql = "select g.id,g.code,g.chn_name,g.eng_name,g.type,g.color,g.standard,g.displacement,g.place,g.brand,g.provider,g.price,g.text,s.quantity"
				+ " from GOODS_INF g,STOCK_INF s  "
				+ " where type='2'"
				+ " and g.id=s.goods_id "
				+ " and chn_name like '%"+chnName+"%'";
		Query query = session.createQuery(hql);
		ArrayList resultList = (ArrayList) query.list();
		session.close();
		return resultList;
	}

	// 新增配件
	public void insertAccessory(GOODS_INF accessory) {
		Session session = sf.openSession();
		session.save(accessory);
		session.close();
	}

	// 删除配件
	public void deleteAccessory(int ID) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		GOODS_INF accessory = (GOODS_INF) session.get(GOODS_INF.class, ID);
		session.delete(accessory);
		tx.commit();
		session.close();
	}

	// 编辑配件信息
	public void updateAccessory(GOODS_INF accessory) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		GOODS_INF old_ac = (GOODS_INF) session.get(GOODS_INF.class,
				accessory.getId());
		old_ac.setCode(accessory.getCode());
		old_ac.setChn_name(accessory.getChn_name());
		old_ac.setEng_name(accessory.getEng_name());
		old_ac.setStandard(accessory.getStandard());
		old_ac.setPlace(accessory.getPlace());
		old_ac.setBrand(accessory.getBrand());
		old_ac.setProvider(accessory.getProvider());
		old_ac.setPrice(accessory.getPrice());
		old_ac.setText(accessory.getText());
		session.save(old_ac);
		tx.commit();
		session.close();
	}

	public GOODS_INF getGoodsById(int id) {
		Session session = sf.openSession();
		GOODS_INF goods = (GOODS_INF) session.get(GOODS_INF.class, id);
		return goods;
	}

	public GOODS_INF getGoodsByCode(String code) {
		Session session = sf.openSession();
		String hql = "select * from GOODS_INF where code='" + code + "'";
		Query query = session.createSQLQuery(hql);
		ArrayList list = (ArrayList) query.list();
		Object[] obj = (Object[]) list.get(0);
		GOODS_INF to = new GOODS_INF();
		to.setId(Integer.valueOf(obj[0].toString()));
		to.setCode(obj[1].toString());
		to.setChn_name(obj[2].toString());
		to.setEng_name(obj[3].toString());
		to.setType(obj[4].toString());
		to.setStandard(obj[6].toString());
		to.setPlace(obj[8].toString());
		to.setBrand(obj[9].toString());
		to.setProvider(Integer.valueOf(obj[10].toString()));
		to.setPrice(Integer.valueOf(obj[11].toString()));
		to.setText(obj[12].toString());
		return to;
	}

//	public int PageNum(int pageSize, String value) {
//		int pageNum;
//		String hql = null;
//		ArrayList resultList;
//		Session session = sf.openSession();
//		if (value == null) {
//			hql = "select * from GOODS_INF";
//			Query query = session.createSQLQuery(hql);
//			resultList = (ArrayList) query.list();
//		} else {
//			hql = "select * from GOODS_INF" + " where chn_name= '" + value
//					+ "'";
//			Query query = session.createSQLQuery(hql);
//			System.out.println(query.list());
//			resultList = (ArrayList) query.list();
//		}
//		if (resultList.size() / pageSize == 0)
//			pageNum = 1;
//		else
//			pageNum = (int) Math.ceil(resultList.size() / (double) pageSize);
//		session.close();
//		return pageNum;
//	}
}
