package com.SSSSWeb.model.business.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.SSSSWeb.model.domain.GOODS_INF;
import com.SSSSWeb.model.domain.GoodsDetial;

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

	//查询所有配件
	public ArrayList<GOODS_INF> getAllAccessory() {
		Session session = sf.openSession();
		String hql = "select code,chn_name,eng_name,standard,place,brand,provider,price from GOODS_INF where type=2";
		Query query = session.createQuery(hql);
		ArrayList resultList = (ArrayList) query.list();
		session.close();
		return resultList;
	}
	
	//查询配件
	public ArrayList<GOODS_INF> getAccessory(GOODS_INF goods) {
		Session session = sf.openSession();
		String hql = "select code,chn_name,eng_name,standard,place,brand,provider,price "
					+"from GOODS_INF "
					+"where type=2";
		Query query = session.createQuery(hql);
		ArrayList resultList = (ArrayList) query.list();
		session.close();
		return resultList;
	}
	
	//新增配件
	public int insertAccessory(GOODS_INF goods){
		int flag = 0;
		Session session = sf.openSession();
		flag = (Integer)session.save(goods);
		session.close();
		if(flag != 0) {
			return DONE;
		} else {
			return FAIL;
		}
	}
	
	//删除配件
	public void deleteAccessory(int ID) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction(); 
		GOODS_INF accessory = (GOODS_INF) session.get(GOODS_INF.class, ID);
		session.delete(accessory);
		tx.commit();
		session.close();
	}
	
	//编辑配件信息
	public void updateAccessory(GOODS_INF goods) {
		Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        GOODS_INF accessory = (GOODS_INF) session.get(GOODS_INF.class, goods.getId());
        session.delete(accessory);
        session.save(goods);
        tx.commit();
        session.close();
	}
}
